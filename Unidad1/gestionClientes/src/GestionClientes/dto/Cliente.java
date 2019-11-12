/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionClientes.dto;

import java.util.Date;

/**
 *
 * @author Eduardo
 */
public class Cliente {
    private String Nombre;
    private String Apellidos;
    private Date Fecha;
    private String Provincia;

    public Cliente(String Nombre, String Apellidos, Date Fecha, String Provincia) {
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Fecha = Fecha;
        this.Provincia = Provincia;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public Date getFecha() {
        return Fecha;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public void setProvincia(String Provincia) {
        this.Provincia = Provincia;
    }
    
    public String[] ClienteArray() {
        String[] Cliente=new String[4];
        Cliente[0]=Nombre;
        Cliente[1]=Apellidos;
        Cliente[2]=Fecha.toString();
        Cliente[3]=Provincia;
        return Cliente;
    }
        
}
