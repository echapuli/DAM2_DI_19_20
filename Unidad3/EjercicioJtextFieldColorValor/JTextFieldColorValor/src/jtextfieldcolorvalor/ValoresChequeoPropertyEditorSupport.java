/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtextfieldcolorvalor;

import java.awt.Component;
import java.beans.PropertyEditorSupport;
import java.text.DecimalFormat;

/**
 *
 * @author Eduardo
 */
public class ValoresChequeoPropertyEditorSupport extends PropertyEditorSupport{
    //tendrá como atributo la clase ValoresChequeoPanel
    private ValoresChequeoPanel valoresChequeoPanel = new ValoresChequeoPanel();
    
    //debenmos redefinir estos 4 métodos

    @Override
    public boolean supportsCustomEditor() {
        //este método lo llama netbeans para saber si hay un editor de propiedades personalizado nosotros devolvemos siempre true
        return true;
    }

    @Override
    public Component getCustomEditor() {
        //nos da el panel a insertar
        return valoresChequeoPanel;
    }

    @Override
   public String getJavaInitializationString() {
        //. Cuando se arrastra un componente a un formulario, Netbeans genera un trozo de código dentro del método initComponents. Si únicamente arrastramos el componente y lo incluimos en un formulario, generaría una llamada al constructor del componente
        ValoresChequeo valoreschequeo=valoresChequeoPanel.getValoresSeleccionados();
        return "new jtextfieldcolorvalor.ValoresChequeo("+valoreschequeo.getColorSuperior().getRGB()+","+valoreschequeo.getColorInferior().getRGB()+","+ String.valueOf(valoreschequeo.getValor()) +"f)";

    }

    @Override
    public Object getValue() {
        //devuelve el valor recogido del panel (hicimos un método en el panel (imagenFondoPanel))
        return valoresChequeoPanel.getValoresSeleccionados();

    }
    
}
