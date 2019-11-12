/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtextfieldcolorvalor;

import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author Eduardo
 * Clase propiedades componente
 */
public class ValoresChequeo implements Serializable{
    private Color colorSuperior=Color.GREEN;  //color que va a tener el textField si el valor es mayor o igual que el valor de la propiedad valor
    private Color colorInferior=Color.RED;  //color que va a tener el textField si el valor es menor que el valor de la propiedad valor
    private Float valor=0f; //valor por debajo del cual cambia el color

    public ValoresChequeo(int colorSuperior, int colorInferior, Float valor) {
        this.colorSuperior = new Color(colorSuperior);
        this.colorInferior = new Color(colorInferior);
        this.valor = valor;
    }

    public Color getColorSuperior() {
        return colorSuperior;
    }

    public void setColor(Color colorSuperior) {
        this.colorSuperior = colorSuperior;
    }

    public Color getColorInferior() {
        return colorInferior;
    }

    public void setColorInferior(Color colorInferior) {
        this.colorInferior = colorInferior;
    }    

    public Float getValor() {
        System.out.println(String.valueOf(valor));
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
    
}
