using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AplicacionVideo7.dto
{
    public class Libro : INotifyPropertyChanged, ICloneable,IDataErrorInfo
    {
        private String titulo;
        public String Titulo
        {
            get
            {
                return titulo;
            }
            set
            {
                titulo = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("Titulo"));
            }
        }

        private String autor;
        public String Autor
        {
            get
            {
                return autor;
            }
            set
            {
                autor = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("Autor"));
            }
        }

        private DateTime fechaEntrada;
        public DateTime FechaEntrada
        {
            get
            {
                return fechaEntrada;
            }
            set
            {
                fechaEntrada = value;
                this.PropertyChanged(this, new PropertyChangedEventArgs("FechaEntrada"));
            }
        }

        public Libro()
        {
            this.fechaEntrada = DateTime.Now;
        }

        public Libro(String titulo, String autor, DateTime fechaEntrada)
        {
            this.titulo = titulo;
            this.autor = autor;
            this.fechaEntrada = fechaEntrada;
        }

        public event PropertyChangedEventHandler PropertyChanged;

        public object Clone()
        {
            return this.MemberwiseClone();
        }

        public string Error
        {
            get { return ""; }
        }

        public string this[string columnName]
        {
            get 
            {
                string result = "";
                if (columnName == "Titulo")
                {
                    if (string.IsNullOrEmpty(titulo))
                        result = "Debe introducir el título";
                }
                if (columnName == "Autor")
                {
                    if (string.IsNullOrEmpty(autor))
                        result = "Debe introducir el autor";
                }
                return result;
            }
        }
    }
}

