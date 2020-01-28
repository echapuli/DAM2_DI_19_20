using AplicacionVideo2.dto;
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

namespace AplicacionVideo2
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            List<Persona> listaPersonas = new List<Persona>();
            listaPersonas.Add(new Persona("Pablo","González"));
            listaPersonas.Add(new Persona("Pedro","Fernández"));
            
            foreach (Persona persona in listaPersonas)
            {
                ComboBoxItem cbi = new ComboBoxItem();
                cbi.Content = persona;
                comboBoxPersonas.Items.Add(cbi);
            }

        }
    }
}
