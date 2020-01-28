using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AplicacionVideo3.dto
{
    class Persona
    {
        public String Nombre { get; set; }
        private String apellidos;
        public String Apellidos
        {
            get 
            { 
                return apellidos; 
            }
            set
            {
                apellidos = value;
            }
        }

        public Persona(String nombre, String apellidos)
        {
            this.Nombre = nombre;
            this.Apellidos = apellidos;
        }

        public override string ToString()
        {
            return Nombre + " " + Apellidos;
        }
    }
}
