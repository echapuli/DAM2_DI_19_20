using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IngresosGastos.dto
{
    public class IngresoGasto : INotifyPropertyChanged, ICloneable
    {
        private DateTime fecha;
        private String concepto;
        private double ingreso;
        private double gasto;
        public event PropertyChangedEventHandler PropertyChanged;

        public IngresoGasto()
        {
            this.fecha = DateTime.Now;
        }

        public IngresoGasto(DateTime Fecha, String Concepto, double Importe)
        {
            this.fecha = Fecha;
            this.concepto = Concepto;
            if (Importe < 0)
            {
                this.gasto = Importe;
            }
            else
            {
                this.ingreso = Importe;
            }
        }

        public DateTime Fecha
        {
            get
            {
                return fecha;
            }
            set
            {
                this.fecha = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("Fecha"));
            }
        }

        public string Concepto
        {
            get
            {
                return concepto;
            }
            set
            {
                this.concepto = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("Concepto"));
            }
        }

        public double Ingreso
        {
            get
            {
                return ingreso;
            }
            set
            {
                this.ingreso = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("Ingreso"));
            }
        }

        public double Gasto
        {
            get
            {
                return gasto;
            }
            set
            {
                this.gasto = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("Gasto"));
            }
        }

        public object Clone()
        {
            return this.MemberwiseClone();
        }
    }
}
