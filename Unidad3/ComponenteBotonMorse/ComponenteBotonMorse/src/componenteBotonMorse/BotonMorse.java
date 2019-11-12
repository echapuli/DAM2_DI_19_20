/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componenteBotonMorse;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.Date;
import javax.swing.JButton;

/**
 *
 * @author Eduardo
 */
public class BotonMorse extends JButton implements Serializable{
    private DuracionPulsaciones duracionpulsaciones;
    private Date momentopulsa;
    private Date momentosuelta;
    /**
     * Listener de nuestro componente
     */
    private BotonMorseListener botonMorseListener;
    //El siguiente vector guardará las pulsaciones true -larga, false - corta (tendra dos valores
    private boolean[] pulsaciones = new boolean[2];
    private int indice=0;
    //declaro los patrones a identificar
    private boolean[] letraA = {false,true};
    private boolean[] letraN = {true,false};
    private boolean[] letraI = {false,false};
    private boolean[] letraM = {true,true};
    public BotonMorse() {
        super();
        super.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseReleased(MouseEvent me) {
                //si se levanta el botón del ratón
                momentosuelta=new Date();  //momento en el que suelta el botón del ratón
                int duracion = (int) (momentosuelta.getTime()-momentopulsa.getTime()); //diferencia entre el tiempo en que se suelta y el tiempo en que se presionó
                if(duracion<=duracionpulsaciones.getDuracionPulsacionCorta()){
                    //es una pulsación corta
                                            System.out.println("entra Corta");
                    pulsaciones[indice]=false;
                    indice++;
                    if (indice==2) identificarCaracter();
                } else if (duracion<=duracionpulsaciones.getDuracionPulsacionLarga()){
                    //es una duracion larga
                    pulsaciones[indice]=true;
                    indice++;                    
                    if (indice==2) identificarCaracter();
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {
                //si se pulsa el botón del ratón
                momentopulsa=new Date(); //Momento en el que pulsa el botón del raton
            }
            
        });
   
    }

    public DuracionPulsaciones getDuracionpulsaciones() {
        return duracionpulsaciones;
    }

    public void setDuracionpulsaciones(DuracionPulsaciones duracionpulsaciones) {
        this.duracionpulsaciones = duracionpulsaciones;
    }
  
    private void identificarCaracter() {
        boolean mirarA = true;
        boolean mirarN = true;
        boolean mirarI = true;        
        boolean mirarM = true;
        char i=0; //lo utilizo para recorrer los veztores 
        System.out.println("entra ");
        while (i<2){
            if ((pulsaciones[i]!=letraA[i]) && mirarA) mirarA=false;
            if ((pulsaciones[i]!=letraN[i]) && mirarN) mirarN=false;
            if ((pulsaciones[i]!=letraI[i]) && mirarI) mirarI=false;
            if ((pulsaciones[i]!=letraM[i]) && mirarM) mirarM=false;   
            i++;
        }
        if (mirarA){
            setText("A");
            botonMorseListener.letraA();
        }else if (mirarN){
            setText("N");
            botonMorseListener.letraN();
        }else if (mirarI){
            setText("I");
            botonMorseListener.letraI();
        }else if (mirarM){
            setText("M");
            botonMorseListener.letraM();
        }else { //no corresponde a ninguna de las letras
            setText("");
        }
        indice=0; //reiniciamos el indice para recoger otro código morse
    }    
    
    public void addBotonMorseListener(BotonMorseListener botonMorseListener)
    {
        this.botonMorseListener = botonMorseListener;
    }
}
