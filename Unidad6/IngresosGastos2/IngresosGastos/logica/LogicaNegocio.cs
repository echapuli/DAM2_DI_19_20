using IngresosGastos.dto;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IngresosGastos.logica
{
    public class LogicaNegocio
    {
        public ObservableCollection<IngresoGasto> ListaIngresosGastos { get; set; }

        public LogicaNegocio()
        {
            ListaIngresosGastos = new ObservableCollection<IngresoGasto>();
        }

        public void aniadirIngresoGasto(IngresoGasto ingresoGasto)
        {
            ListaIngresosGastos.Add(ingresoGasto);
        }

        public void modificarIngresoGasto(IngresoGasto ingresoGasto, int posicion)
        {
            ListaIngresosGastos[posicion] = ingresoGasto;
        }
    }
}
