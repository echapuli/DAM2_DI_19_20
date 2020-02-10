using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SeleccionaPersonasDireccion.dto
{
    class Personas
    {
        public String DNI {get;set;}
        public String Nombre { get; set; }
        public String Apellidos { get; set; }
        public Personas(String dni, String nombre, String apellidos)
        {
            DNI = dni;
            Nombre = nombre;
            Apellidos = apellidos;
        }
        public override string ToString()
        {
            return Nombre + " " + Apellidos;
        }
    }
}
