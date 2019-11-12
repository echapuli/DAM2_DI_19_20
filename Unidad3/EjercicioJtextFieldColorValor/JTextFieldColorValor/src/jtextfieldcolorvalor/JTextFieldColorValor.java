/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtextfieldcolorvalor;

import java.awt.Color;
import java.io.Serializable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Eduardo
 */
public class JTextFieldColorValor extends JTextField implements Serializable{ //extiende de JTextField e implementa Serializable
    private ValoresChequeo valoreschequeo;  //atributo de clase Valoreschequeo
    public JTextFieldColorValor() {
        super();
        //Guardamos el color de fondo que tenía el componente por defecto
        setHorizontalAlignment(JTextField.RIGHT); //alineación derecha (para mostrar el importe
        //
        super.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent de) {
                analizaContenido();
            }

            @Override
            public void removeUpdate(DocumentEvent de) {

            }

            @Override
            public void changedUpdate(DocumentEvent de) {

            }
            private void analizaContenido(){
         
                if (valoreschequeo!=null && !valoreschequeo.getValor().equals(""))
                    if (Float.parseFloat(getText().replace(",", ".")) < valoreschequeo.getValor()) //hago el remplace porque el valor tiene que venir con . decimal en lugar de ,
                        setForeground(valoreschequeo.getColorInferior());
                    else
                        setForeground(valoreschequeo.getColorSuperior());
            }            
        });
    }

    public ValoresChequeo getValoreschequeo() {
        return valoreschequeo;
    }

    public void setValoreschequeo(ValoresChequeo valoreschequeo) {
        this.valoreschequeo = valoreschequeo;
    }

}
