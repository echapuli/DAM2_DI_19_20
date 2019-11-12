/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componenteBotonMorse;

import java.io.Serializable;

/**
 *
 * @author Eduardo
 */
public class DuracionPulsaciones implements Serializable{
    private  int duracionPulsacionCorta;
    private  int duracionPulsacionLarga;

    public DuracionPulsaciones(int duracionPulsacionCorta, int duracionPulsacionLarga) {
        this.duracionPulsacionCorta = duracionPulsacionCorta;
        this.duracionPulsacionLarga = duracionPulsacionLarga;
    }

    public int getDuracionPulsacionCorta() {
        return duracionPulsacionCorta;
    }

    public void setDuracionPulsacionCorta(int duracionPulsacionCorta) {
        this.duracionPulsacionCorta = duracionPulsacionCorta;
    }

    public int getDuracionPulsacionLarga() {
        return duracionPulsacionLarga;
    }

    public void setDuracionPulsacionLarga(int duracionPulsacionLarga) {
        this.duracionPulsacionLarga = duracionPulsacionLarga;
    }
    
    
}
