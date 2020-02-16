using IngresosGastos.dto;
using IngresosGastos.gui;
using IngresosGastos.logica;
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

namespace IngresosGastos
{
    //¡¡¡OJO!! AL HABER CAMBIADO LA VENTANA PRINCIPAL DENTRO DE LA CARPETA GUI 
    //ten en cuenta que si se lo cambias de nombre o mueves de sitio el mainwindow.xaml (por ejemplo lo metes en una carpeta dentro de la solución)
    //tienes que ir al app.xaml y actualizar el startupUri:

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
            DataGridIngresosoGastos.DataContext = logicaNegocio;
        }

        private void DataGridIngresosoGastos_MouseDoubleClick(object sender, MouseButtonEventArgs e)
        {
            //se entraria en modo modificación, al hacer doble click sobre una fila del DataGrid, en caso de que no se seleccione ninguna fila (caso de que este vacia) no hace nada
            if (DataGridIngresosoGastos.SelectedItem != null)
            {
                VentanaDialogo dialogoLibro = new VentanaDialogo(logicaNegocio, (IngresoGasto)((IngresoGasto)DataGridIngresosoGastos.SelectedItem).Clone(), DataGridIngresosoGastos.SelectedIndex);
                dialogoLibro.ShowDialog(); //ventana modal
                //dialogoLibro.Show(); //ventana no modal
            }

        }

        private void MenuItem_Click_1(object sender, RoutedEventArgs e)
        {
            VentanaDialogo dialogoLibro = new VentanaDialogo(logicaNegocio);
            dialogoLibro.ShowDialog(); //ventana modal
            //dialogoLibro.Show(); //ventana no modal
        }
    }
}
