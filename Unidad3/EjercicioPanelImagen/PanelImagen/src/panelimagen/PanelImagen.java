/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panelimagen;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Eduardo
 */
public class PanelImagen extends JPanel implements Serializable{  //en este caso en componente que creamos extiende de JPanel 
//esta clase tiene que ser un JavaBean y para poder ser tiene que implementar serializable y ademas tiene que tener un constructor sin parámetros
    //Ua de las propiedades del componente es la ruta de la imagen
    private ImagenFondo propiedadesImagen;

    
    public PanelImagen() {
        
    }

    //getter y setter de las propiedades

    public ImagenFondo getPropiedadesImagen() {
        return propiedadesImagen;
    }

    public void setPropiedadesImagen(ImagenFondo propiedadesImagen) {
        this.propiedadesImagen = propiedadesImagen;
    }


    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs); //To change body of generated methods, choose Tools | Templates.
        //antes de que se entre en el editor de propiedades propiedadesImagen es null debemos tenerlo en cuenta y no pintar la imagen
        if (propiedadesImagen !=null){
            if ((propiedadesImagen.getRutaImagen()!=null) && (propiedadesImagen.getRutaImagen().exists())){
               ImageIcon imagen = new ImageIcon(propiedadesImagen.getRutaImagen().getAbsolutePath());
               //debeis buscar por internet como cambiar la opacidad de una imagen
               Graphics2D g = (Graphics2D)grphcs;
               g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, propiedadesImagen.getOpacidad()));
               grphcs.drawImage(imagen.getImage(), 0, 0, this.getWidth(), this.getHeight(), null); //ajusta la imagen al tamaño del panel
           }           
        }

    }
    
    
    
}
