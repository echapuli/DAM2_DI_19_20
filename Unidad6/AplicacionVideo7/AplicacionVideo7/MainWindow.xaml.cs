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
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace AplicacionVideo7
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private LogicaNegocio logicaNegocio;

        public MainWindow()
        {
            InitializeComponent();
            logicaNegocio = new LogicaNegocio();
            DataGridLibros.DataContext = logicaNegocio;
        }

        private void MenuItem_Click_1(object sender, RoutedEventArgs e)
        {
            DialogoLibro dialogoLibro = new DialogoLibro(logicaNegocio);
            dialogoLibro.Show();
        }

        private void ButtonModificar_Click(object sender, RoutedEventArgs e)
        {
            if (DataGridLibros.SelectedIndex != -1)
            {
                Libro libro = (Libro)DataGridLibros.SelectedItem;
                DialogoLibro dialogoLibro = new DialogoLibro(logicaNegocio, (Libro)libro.Clone(), DataGridLibros.SelectedIndex);
                dialogoLibro.Show();
            }
        }
    }
}
