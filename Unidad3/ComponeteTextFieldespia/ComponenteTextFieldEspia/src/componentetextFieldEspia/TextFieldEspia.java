/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentetextFieldEspia;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JTextField;

/**
 *
 * @author Eduardo
 */
public class TextFieldEspia extends JTextField implements Serializable{
    private String ficheroLog;
    // A la siguiente propiedad no le meto get ni Set ya que va a ser manipuloada por un método publico
    private List<String> palabras = new ArrayList<String>();
    private char indice;
    public TextFieldEspia() {
        super();
        indice=0;
        super.addKeyListener(new KeyAdapter(){
            //voy a hacer que analice lo escrito cuando doy a Entre y salga de la aplicación cuando da a Esc
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    if (palabras!=null){
                        for (String palabra : palabras){
                            if (getText().contains(palabra)) { //si el textfield contiene la palabra la grabo en un fichero con la fecha y hora actual
                                FileWriter fichero = null;
                                PrintWriter pw = null;
                                try {
                                    fichero = new FileWriter(ficheroLog,true); //Si queremos añadir al final de un fichero ya existente, simplemente debemos poner un flag a true como segundo parámetro del constructor de FileWriter. 
                                    pw = new PrintWriter(fichero);
                                    Date dateActual = new Date();
                                    SimpleDateFormat formatFecha = new SimpleDateFormat("dd-MM-yyyy");
                                    SimpleDateFormat formatHora = new SimpleDateFormat("HH:mm:ss");
                                    pw.println(palabra + " " + formatFecha.format(dateActual)+ " " + formatHora.format(dateActual));

                                } catch (Exception ed) {
                                    ed.printStackTrace();
                                } finally {
                                    try {
                                        // Nuevamente aprovechamos el finally para 
                                        // asegurarnos que se cierra el fichero.
                                        if (null != fichero) {
                                            fichero.close();
                                        }
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            }
                        }                        
                    }

                }
                if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
                    System.exit(0);
                }
            }           
            
        });        
    }

    public String getFicheroLog() {
        return ficheroLog;
    }

    public void setFicheroLog(String ficheroLog) {
        this.ficheroLog = ficheroLog;
    }
    
    public void aniadirPalabra(String palabra){
        palabras.add(palabra);
    }
}
