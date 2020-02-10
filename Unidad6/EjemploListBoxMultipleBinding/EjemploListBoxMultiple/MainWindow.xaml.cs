using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
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

namespace EjemploListBoxMultiple
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public List<String> ListaDeportes { get; set; }
        public ObservableCollection<String> ListaSeleccion { get; set; }

        public MainWindow()
        {
            InitializeComponent();
            List<String> listaDeportes = new List<string>();
            ObservableCollection<String> listaSeleccion = new ObservableCollection<String>();
            listaDeportes.Add("Fútbol");
            listaDeportes.Add("Baloncesto");
            listaDeportes.Add("Natación");
            listaDeportes.Add("Athetismo");
            listaDeportes.Add("Piraguismo");
            ListaDeportes = listaDeportes;
            ListaSeleccion = listaSeleccion;
            this.DataContext=this;
        }

        private void ListBox1_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            //sender contiene el objeto que genero el evento si quisiesemos hacer referencia a él deberiamos hacer un cast ej. ((ComboBox)sender)

            //e contiene una serie de datos para el evento
            //AddedItemsObtiene una lista que contiene los elementos que se seleccionaron.
            //RemovedItems Obtiene una lista que contiene los elementos cuya selección se anuló.


            //ListBox2.Items.Add añade el item indicado
            if (e.AddedItems.Count != 0) ListaSeleccion.Add((String)e.AddedItems[0]);
            
            //ListBox2.Items.Remove borra el item indicado
            if (e.RemovedItems.Count != 0) ListaSeleccion.Remove((String)e.RemovedItems[0]);

            

        }
    }
}
