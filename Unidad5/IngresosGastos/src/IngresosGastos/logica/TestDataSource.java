/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IngresosGastos.logica;

import IngresosGastos.dto.IngresoGasto;
import java.util.List;

/**
 *
 * @author Eduardo
 */
//Ahora creamosa clase que va a devolver la lista para el modo “Preview”. la clase que va a devolver la lista para el modo “Preview”.
public class TestDataSource {

    public static List<IngresoGasto> listIngresosGastos() {
        return LogicaNegocio.getListaIngresosgastos();
    }

}
