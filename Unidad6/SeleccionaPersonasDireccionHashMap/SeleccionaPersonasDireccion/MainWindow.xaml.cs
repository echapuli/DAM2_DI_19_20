using SeleccionaPersonasDireccion.dto;
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

namespace SeleccionaPersonasDireccion
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>

    public partial class MainWindow : Window
    {
        //ejemplo utilizando Dictionary
        Dictionary<Personas, List<Direcciones>> lpersonas = new Dictionary<Personas, List<Direcciones>>();

        public MainWindow()
        {
            InitializeComponent();
            //relleno lista de personas y sus direcciones
            List<Direcciones> listaDirecciones= new List<Direcciones>();
            listaDirecciones.Add(new Direcciones("Pola de Siero", "Asturias", "C/Boladro nº5E"));
            listaDirecciones.Add(new Direcciones("Las Rozas", "Madrid", "C/Mª Tubau nº19 portal c 1º izq"));
            lpersonas.Add(new Personas("12345678E", "Eduardo", "Chápuli González"), listaDirecciones);
            List<Direcciones> listaDirecciones2 = new List<Direcciones>();
            listaDirecciones2.Add(new Direcciones("Puerto de Vega", "Asturias", "C/Parroco Fernández Nº31 1º E"));
            listaDirecciones2.Add(new Direcciones("Oviedo", "Asturias", "C/Luis González Nº97 5º Izq"));
            lpersonas.Add(new Personas("13579123E", "Sonia", "García Méndez"), listaDirecciones2);
            List<Direcciones> listaDirecciones3 = new List<Direcciones>();
            listaDirecciones3.Add(new Direcciones("Gijón", "Asturias", "C/Las Armas Nº5 bajo"));
            listaDirecciones3.Add(new Direcciones("Avilés", "Asturias", "C/Martinez de la Rosa Nº7 2º Izq"));
            lpersonas.Add(new Personas("87654321E", "Iván", "Fernández Díaz"), listaDirecciones3);
            List<Direcciones> listaDirecciones4 = new List<Direcciones>();
            listaDirecciones4.Add(new Direcciones("Benidorm", "Alicante", "Plaza el Torreon nº3 3 D"));
            lpersonas.Add(new Personas("11223344E", "Alba", "García González"), listaDirecciones4);
            //cargamos la combobox personas
            foreach (KeyValuePair<Personas, List<Direcciones>> persona in lpersonas)
            {
                ComboBoxItem cbi = new ComboBoxItem();
                cbi.Content = persona.Key;
                comboBoxPersonas.Items.Add(cbi);
            }

        }

        private void comboBoxPersonas_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            //borramos los items de la ListBoxDirecciones
            ListBoxDirecciones.Items.Clear();
            ComboBoxItem cbi=(ComboBoxItem)comboBoxPersonas.SelectedItem;
            Personas persona=(Personas)cbi.Content;
            List<Direcciones> lDirecciones = lpersonas[persona];
            //cargamos la Listbox durecciones
            foreach (Direcciones d in lDirecciones)
            {
                    ListBoxItem lbi = new ListBoxItem();
                    lbi.Content = d;
                    ListBoxDirecciones.Items.Add(lbi);
            }
        }

        private void Window_SizeChanged_1(object sender, SizeChangedEventArgs e)
        {
            //Si se produce el evento de cambio de tamaño de la ventana, compruebo que no baje de un determinado tamaño, si baja no le dejo cambiarlo
            if (e.NewSize.Width < 525)
            {
                VentanaPrincipal.Width = 525;
            }
            if (e.NewSize.Height < 350)
            {
                VentanaPrincipal.Height = 350;
            }
        }
    }
}
