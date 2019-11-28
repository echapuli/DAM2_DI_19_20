/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentetextfield;

import java.io.Serializable;
import javax.swing.JTextField;

/**
 *
 * @author alumnop
 */
public class TextFieldConfigurable extends JTextField implements Serializable{

    private DatosTextField datosTextField;
    
    public TextFieldConfigurable() {
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char caracter = evt.getKeyChar();
                if (datosTextField!=null){
                    if (datosTextField.isNumerico()){

                        // Verificar si la tecla pulsada no es un digito
                        if ((caracter < '0') || (caracter > '9')) 
                        {
                           evt.consume();  // ignorar el evento de teclado
                        }                    
                    } else if (datosTextField.isTexto()){
                        
                             // Verificar si la tecla pulsada no es un digito
                            if (!((caracter >= 'a') && (caracter <= 'z')||(caracter >= 'A') && (caracter <= 'Z')||(caracter=='Ñ')||(caracter=='ñ'))) 
                            {
                               evt.consume();  // ignorar el evento de teclado
                            }                      
                    }
                    if (getText().length()+1 > datosTextField.getLongitud()){
                        evt.consume();  // ignorar el evento de teclado
                    }
                }
            }
        });
    }

    public DatosTextField getDatosTextField() {
        return datosTextField;
    }

    public void setDatosTextField(DatosTextField datosTextField) {
        this.datosTextField = datosTextField;
    }

       
    
}
