
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
using SeleccionaPersonasDireccion.dto;
using System.Collections.ObjectModel;

namespace SeleccionaPersonasDireccion
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>

    public partial class MainWindow : Window
    {
        public ObservableCollection<Direcciones> ListaDirecciones { get; set; }
        public List<Personas> ListaPersonas { get; set; }
        private List<Direcciones> listaDirecciones = new List<Direcciones>();
        private ObservableCollection<Direcciones> listaSeleccionados = new ObservableCollection<Direcciones>();
        public MainWindow()
        {
            InitializeComponent();
            //relleno lista de personas
            List<Personas> listaPersonas = new List<Personas>();
            listaPersonas.Add(new Personas("12345678E", "Eduardo", "Chápuli González"));
            listaPersonas.Add(new Personas("13579123E", "Sonia", "García Méndez"));
            listaPersonas.Add(new Personas("87654321E", "Iván", "Fernández Díaz"));
            listaPersonas.Add(new Personas("11223344E", "Alba", "García González"));
            ListaPersonas = listaPersonas;
            //relleno lista de direcciones

            listaDirecciones.Add(new Direcciones("12345678E", "Pola de Siero", "Asturias", "C/Boladro nº5E"));
            listaDirecciones.Add(new Direcciones("12345678E", "Las Rozas", "Madrid", "C/Mª Tubau nº19 portal c 1º izq"));
            listaDirecciones.Add(new Direcciones("13579123E", "Puerto de Vega", "Asturias", "C/Parroco Fernández Nº31 1º E"));
            listaDirecciones.Add(new Direcciones("13579123E", "Oviedo", "Asturias", "C/Luis González Nº97 5º Izq"));
            listaDirecciones.Add(new Direcciones("87654321E", "Gijón", "Asturias", "C/Las Armas Nº5 bajo"));
            listaDirecciones.Add(new Direcciones("87654321E", "Avilés", "Asturias", "C/Martinez de la Rosa Nº7 2º Izq"));
            listaDirecciones.Add(new Direcciones("11223344E", "Benidorm", "Alicante", "Plaza el Torreon nº3 3 D"));

            ListaDirecciones = listaSeleccionados;

            this.DataContext = this;


        }

        private void comboBoxPersonas_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            //borramos los items de la ListBoxDirecciones

            Personas persona = (Personas)comboBoxPersonas.SelectedItem;
            listaSeleccionados.Clear();
            //cargamos la Listbox durecciones
            foreach (Direcciones d in listaDirecciones)
            {

                if (d.DNI == persona.DNI)
                {
                    listaSeleccionados.Add(d);
                }
            }

        }


    }
}
