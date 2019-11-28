/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentetextfield;

import java.io.Serializable;

/**
 *
 * @author alumnop
 */
public class DatosTextField implements Serializable{
    private int longitud;
    private boolean numerico;
    private boolean texto;

    public DatosTextField(int longitud, boolean numerico, boolean texto) {
        this.longitud = longitud;
        this.numerico = numerico;
        this.texto = texto;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public boolean isNumerico() {
        return numerico;
    }

    public void setNumerico(boolean numerico) {
        this.numerico = numerico;
    }

    public boolean isTexto() {
        return texto;
    }

    public void setTexto(boolean texto) {
        this.texto = texto;
    }
    
}
