/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IngresosGastos.logica;

import IngresosGastos.dto.IngresoGasto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo
 */
public class LogicaNegocio {
    private static List<IngresoGasto> listaIngresosGastos=new ArrayList<>();
    public static void anadirIngresoGasto(IngresoGasto ingresoGasto){
        listaIngresosGastos.add(ingresoGasto);
    }

    public static List<IngresoGasto> getListaIngresosgastos() {
        return listaIngresosGastos;
    }   
        
    public static Double getBalance(){ //método que nos da el balance
        double total=0;
        for (IngresoGasto ingresoGasto:listaIngresosGastos){

            total=total+ingresoGasto.getGasto()+ingresoGasto.getIngreso();
            
        }
        return (total);
    }
    
}
