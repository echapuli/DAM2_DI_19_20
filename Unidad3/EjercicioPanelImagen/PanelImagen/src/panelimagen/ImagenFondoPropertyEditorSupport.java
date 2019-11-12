/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panelimagen;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author Eduardo
 */
public class ImagenFondoPropertyEditorSupport extends PropertyEditorSupport{  //debe extender de PropertyEditorSupport
    private ImagenFondoPanel imagenFondoPanel = new ImagenFondoPanel();
    @Override
    public boolean supportsCustomEditor() {
        //este método lo llama netbeans para saber si hay un editor de propiedades personalizado nosotros devolvemos siempre true
        return true;
    }

    @Override
    public Component getCustomEditor() {
        //nos da el panel a insertar
        return imagenFondoPanel;
    }

    @Override
    public String getJavaInitializationString() {
        ImagenFondo imagenFondo=imagenFondoPanel.GetValoresSeleccionados();
        //tenemos que tener en cuenta que en una cadena el caracter \ se utiliza para los caracteres de escape si quisieramos escribir la \ de la ruta tendriamos que poner en la cadena \\ 
        //por eso reemplazamos en la ruta de la imagen \ por \\  "\\" --> \   "\\\\" --> "\\" 
        return "new panelimagen.ImagenFondo(new java.io.File(\""+imagenFondo.getRutaImagen().getAbsolutePath().replace("\\","\\\\")+"\"),"+imagenFondo.getOpacidad()+"f)";
    }

    @Override
    public Object getValue() {
        //devuelve el valor recogido del panel (hicimos un método en el panel (imagenFondoPanel))
        return imagenFondoPanel.GetValoresSeleccionados();
    }
    //debenmos redefinir estos 4 métodos
    
    
}
