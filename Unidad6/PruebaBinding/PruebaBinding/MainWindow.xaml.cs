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

namespace PruebaBinding
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            //hay dos ejemplos de Binding:
            //ejemplo de binding, mirar código .xaml se mete un binding en los label (alto y ancho) para mostrar el tamaño de la ventana cuando se redimensiona
            //tambien se metio un label que muestra lo que se va escribiendo en el textbox
            InitializeComponent();
        }
    }
}
