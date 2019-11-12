/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda.dto;

/**
 *
 * @author Eduardo
 */
public class Contacto {
    private String Nombre;
    private String Apellidos;
    private String Direccion;
    private String Telefono;

    public Contacto(String Nombre, String Apellidos, String Direccion, String Telefono) {
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    
    public String[] contactoArray(){
        String[] contacto=new String[4];
        contacto[0]=Nombre;
        contacto[1]=Apellidos;
        contacto[2]=Direccion;
        contacto[3]=Telefono;
        return contacto;
    }
}
