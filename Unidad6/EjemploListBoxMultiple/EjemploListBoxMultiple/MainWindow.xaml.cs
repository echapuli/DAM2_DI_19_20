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

namespace EjemploListBoxMultiple
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            ListBox1.Items.Add("Fútbol");
            ListBox1.Items.Add("Baloncesto");
            ListBox1.Items.Add("Natación");
            ListBox1.Items.Add("Athetismo");
            ListBox1.Items.Add("Piraguismo");
        }

        private void ListBox1_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            //sender contiene el objeto que genero el evento si quisiesemos hacer referencia a él deberiamos hacer un cast ej. ((ComboBox)sender)

            //e contiene una serie de datos para el evento
            //AddedItemsObtiene una lista que contiene los elementos que se seleccionaron.
            //RemovedItems Obtiene una lista que contiene los elementos cuya selección se anuló.
           

            //ListBox2.Items.Add añade el item indicado
            if (e.AddedItems.Count != 0) ListBox2.Items.Add(e.AddedItems[0]);
            
            //ListBox2.Items.Remove borra el item indicado
            if (e.RemovedItems.Count != 0) ListBox2.Items.Remove(e.RemovedItems[0]);


        }

    }
}
