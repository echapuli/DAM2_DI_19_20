/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentetextfield;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author alumnop
 */
public class DatosTextFieldPropertyEditorSupport extends PropertyEditorSupport{
    
    private DatosTextFieldPanel datosTextFieldPanel=new DatosTextFieldPanel();
    
    @Override
    public boolean supportsCustomEditor() {
        return true;
    }

    @Override
    public Component getCustomEditor() {
        return datosTextFieldPanel;
    }

    @Override
    public String getJavaInitializationString() {
        return "new componentetextfield.DatosTextField("+ datosTextFieldPanel.getValores().getLongitud() + ","+ datosTextFieldPanel.getValores().isNumerico() +","+ datosTextFieldPanel.getValores().isTexto()+")";
    }

    @Override
    public Object getValue() {
        return datosTextFieldPanel.getValores();
    }
    
}
