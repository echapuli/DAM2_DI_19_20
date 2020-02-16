using IngresosGastos.dto;
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
using System.Windows.Shapes;

namespace IngresosGastos.gui
{
    /// <summary>
    /// Lógica de interacción para VentanaDialogo.xaml
    /// </summary>
    public partial class VentanaDialogo : Window
    {
        private LogicaNegocio logicaNegocio;
        public IngresoGasto ingresoGasto;
        private int posicion;

        public VentanaDialogo(LogicaNegocio logicaNegocio)
        {
            InitializeComponent();
            this.logicaNegocio = logicaNegocio;
            ingresoGasto = new IngresoGasto();
            this.DataContext = ingresoGasto;
            BInsertar.Content = "Insertar";

        }

        public VentanaDialogo(LogicaNegocio logicaNegocio, IngresoGasto ingresoGasto, int posicion)
        {
            InitializeComponent();
            this.logicaNegocio = logicaNegocio;
            this.ingresoGasto = ingresoGasto;
            this.DataContext = ingresoGasto;
            this.posicion = posicion;
            if (ingresoGasto.Ingreso != 0)
                TBImporte.Text = Convert.ToString(ingresoGasto.Ingreso);
            else
                TBImporte.Text = Convert.ToString(ingresoGasto.Gasto);
            BInsertar.Content = "Modificar";

        }
        private void BInsertar_Click(object sender, RoutedEventArgs e)
        {
            //en caso de que el botón sea de modificación o de Inserción
            if (Convert.ToDouble(TBImporte.Text) < 0) ingresoGasto.Gasto = Convert.ToDouble(TBImporte.Text);
            else ingresoGasto.Ingreso = Convert.ToDouble(TBImporte.Text);

            if ((String)(BInsertar.Content) == "Insertar")
            {
                logicaNegocio.aniadirIngresoGasto(ingresoGasto);
            }
            else
            {
                logicaNegocio.modificarIngresoGasto(ingresoGasto, posicion);
            }
            this.Close();
        }


        private void BCancelar_Click(object sender, RoutedEventArgs e)
        {
            //se cancela - Cierra la ventana
            this.Close();
        }


    }
}
