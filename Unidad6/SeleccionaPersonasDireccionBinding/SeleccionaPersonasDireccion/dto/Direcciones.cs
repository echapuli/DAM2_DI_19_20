using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SeleccionaPersonasDireccion.dto
{
    public class Direcciones
    {
        public String DNI {get;set;}
        public String Localidad { get; set; }
        public String Provincia { get; set; }
        public String Calle {get; set;}
        public Direcciones(String dni, String localidad, String provincia, String calle)
        {
            DNI = dni;
            Localidad = localidad;
            Provincia = provincia;
            Calle = calle;
        }
        public override string ToString()
        {
            return Calle + " " + Localidad + " " + Provincia;
        }
    }
}
