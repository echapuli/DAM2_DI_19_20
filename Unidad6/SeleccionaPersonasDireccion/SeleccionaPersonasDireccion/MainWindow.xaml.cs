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
        private List<Direcciones> listaDirecciones = new List<Direcciones>();
        public MainWindow()
        {
            //Aplicación que selecciona una persona de la lista de arriba y muestra sus direcciones en la de abajo
            InitializeComponent();
            //relleno lista de personas
            List<Personas> listaPersonas = new List<Personas>();
            listaPersonas.Add(new Personas("12345678E", "Eduardo", "Chápuli González"));
            listaPersonas.Add(new Personas("13579123E", "Sonia", "García Méndez"));
            listaPersonas.Add(new Personas("87654321E", "Iván", "Fernández Díaz"));
            listaPersonas.Add(new Personas("11223344E", "Alba", "García González"));
            //relleno lista de direcciones

            listaDirecciones.Add(new Direcciones("12345678E", "Pola de Siero", "Asturias", "C/Boladro nº5E"));
            listaDirecciones.Add(new Direcciones("12345678E", "Las Rozas", "Madrid", "C/Mª Tubau nº19 portal c 1º izq"));
            listaDirecciones.Add(new Direcciones("13579123E", "Puerto de Vega", "Asturias", "C/Parroco Fernández Nº31 1º E"));
            listaDirecciones.Add(new Direcciones("13579123E", "Oviedo", "Asturias", "C/Luis González Nº97 5º Izq"));
            listaDirecciones.Add(new Direcciones("87654321E", "Gijón", "Asturias", "C/Las Armas Nº5 bajo"));
            listaDirecciones.Add(new Direcciones("87654321E", "Avilés", "Asturias", "C/Martinez de la Rosa Nº7 2º Izq"));
            listaDirecciones.Add(new Direcciones("11223344E", "Benidorm", "Alicante", "Plaza el Torreon nº3 3 D"));

            //cargamos la combobox personas
            foreach (Personas p in listaPersonas){
                ComboBoxItem cbi=new ComboBoxItem();
                cbi.Content=p;
                comboBoxPersonas.Items.Add(cbi);
            }


        }

        private void comboBoxPersonas_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            //borramos los items de la ListBoxDirecciones
            ListBoxDirecciones.Items.Clear();

            //cargamos la Listbox durecciones
            foreach (Direcciones d in listaDirecciones)
            {
                ComboBoxItem cbi=(ComboBoxItem)comboBoxPersonas.SelectedItem;
                Personas persona=(Personas)cbi.Content;
                if (d.DNI == persona.DNI)
                {
                    ListBoxItem lbi = new ListBoxItem();
                    lbi.Content = d;
                    ListBoxDirecciones.Items.Add(lbi);
                }
            }
        }

        private void Window_SizeChanged_1(object sender, SizeChangedEventArgs e)
        {
            //Si se produce el evento de cambio de tamaño de la ventana, compruebo que no baje de un determinado tamaño, si baja no le dejo cambiarlo
            //esto se podría hacer poniendo los atributos de Minwidth y MinHeight (pero lo hice para manejar los eventos)
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
