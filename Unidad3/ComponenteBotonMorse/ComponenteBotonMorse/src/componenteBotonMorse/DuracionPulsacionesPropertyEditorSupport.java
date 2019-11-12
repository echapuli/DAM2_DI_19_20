/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componenteBotonMorse;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author Eduardo
 */
public class DuracionPulsacionesPropertyEditorSupport extends PropertyEditorSupport{
    //tendrá como editor de propiedades DuracionPulsacionesPanel
    private DuracionPulsacionesPanel duracionPulsacionesPanel = new DuracionPulsacionesPanel();
    
    //debenmos redefinir estos 4 métodos
    @Override
    public boolean supportsCustomEditor() {
        //este método lo llama netbeans para saber si hay un editor de propiedades personalizado nosotros devolvemos siempre true     
        return true;
    }

    @Override
    public Component getCustomEditor() {
        //nos da el panel a insertar
        return duracionPulsacionesPanel;
    }

    @Override
    public String getJavaInitializationString() {
        DuracionPulsaciones propiedad = duracionPulsacionesPanel.getValoresSeleccionados();
        return "new componenteBotonMorse.DuracionPulsaciones("+
                Integer.toString(propiedad.getDuracionPulsacionCorta())+
                ","+
                Integer.toString(propiedad.getDuracionPulsacionLarga())+")";
    }

    @Override
    public Object getValue() {
        //devuelve el valor recogido del panel (hicimos un método en el panel ())
        return duracionPulsacionesPanel.getValoresSeleccionados();
    }
    
}
