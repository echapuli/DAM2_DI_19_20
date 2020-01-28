using AplicacionVideo7.dto;
using AplicacionVideo7.logica;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace AplicacionVideo7
{
    /// <summary>
    /// Lógica de interacción para DialogoLibro.xaml
    /// </summary>
    public partial class DialogoLibro : Window
    {
        private LogicaNegocio logicaNegocio;
        public Libro libro;
        private int posicion;
        private Boolean modificar;
        private int errores;

        public DialogoLibro(LogicaNegocio logicaNegocio)
        {
            InitializeComponent();
            this.logicaNegocio = logicaNegocio;
            libro = new Libro();
            this.DataContext = libro;
            modificar = false;
        }

        public DialogoLibro(LogicaNegocio logicaNegocio, Libro libroModificar, int posicion)
        {
            InitializeComponent();
            this.logicaNegocio = logicaNegocio;
            this.libro = libroModificar;
            this.posicion = posicion;
            this.DataContext = libro;
            modificar = true;
        }

        private void ButtonCancelar_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void ButtonAceptar_Click(object sender, RoutedEventArgs e)
        {
            if (modificar)
                logicaNegocio.modificarLibro(libro, posicion);
            else
                logicaNegocio.aniadirLibro(libro);

            this.Close();
        }

        private void Validation_Error(object sender, ValidationErrorEventArgs e)
        {
            if (e.Action == ValidationErrorEventAction.Added)
                errores++;
            else
                errores--;

            if (errores == 0)
                ButtonAceptar.IsEnabled = true;
            else
                ButtonAceptar.IsEnabled = false;
        }
    }
}
