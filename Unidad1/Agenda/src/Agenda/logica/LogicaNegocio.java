/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda.logica;

import Agenda.dto.Contacto;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Eduardo
 */
public class LogicaNegocio {
    private static List<Contacto> listaContactos=new ArrayList<>();

    public static void anadirContacto(Contacto contacto){
        listaContactos.add(contacto);
    }

    public static List<Contacto> getListaContactos() {
        return listaContactos;
    }

}
