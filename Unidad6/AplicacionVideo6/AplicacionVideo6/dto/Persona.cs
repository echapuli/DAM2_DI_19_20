using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AplicacionVideo6.dto
{
    public class Persona : INotifyPropertyChanged
    {
        private String nombre;
        public String Nombre {
            get { return nombre; } 
            set 
            {
                this.nombre = value;
                this.PropertyChanged(this,new PropertyChangedEventArgs("Nombre"));
            } 
        }
        public String Apellidos { get; set; }

        public Persona(String nombre, String apellidos)
        {
            this.nombre = nombre;
            this.Apellidos = apellidos;
        }

        public override string ToString()
        {
            return Nombre + " " + Apellidos;
        }

        public event PropertyChangedEventHandler PropertyChanged;
    }
}
