/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentetemporizador;

import java.awt.Color;
import java.io.File;
import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

/**
 *
 * @author Eduardo
 */
public class ComponenteTemporizador extends JLabel implements Serializable
{
    //propiedades del componente
    private int numSegundos;  //Número de milisegundos para la cuenta atrás
    private String textoFin;  //Texto que mostrará al finalizar
    private Color colorFin;   //color que mostrará al finalizar
    private boolean mostrarDecimales;  //Nos indicará si mostramos o no decimales
    private File imagen;      //Imagen que mostrará al finalizar
    private int contador;

    public ComponenteTemporizador() {

    }

    public String getTextoFin() {
        return textoFin;
    }

    public void setTextoFin(String textoFin) {
        this.textoFin = textoFin;
    }

    public Color getColorFin() {
        return colorFin;
    }

    public void setColorFin(Color colorFin) {
        this.colorFin = colorFin;
    }

    public boolean getMostrarDecimales() {
        return mostrarDecimales;
    }

    public void setMostrarDecimales(boolean mostrarDecimales) {
        this.mostrarDecimales = mostrarDecimales;
    }

    public File getImagen() {
        return imagen;
    }

    public void setImagen(File imagen) {
        this.imagen = imagen;
    }

    public int getNumSegundos() {
        return numSegundos;
    }

    public void setNumSegundos(int numSegundos)
    {
        this.numSegundos = numSegundos;
        setText(Integer.toString(numSegundos));
        cuentaAtras();
    } 
   
    private void cuentaAtras()
    {
        contador = numSegundos;
        Timer timer = new Timer();
        TimerTask task = new TimerTask() { //en principio tenemos que crear un objeto TimerTask que defina la tarea que vamos a ejecutar dentro de su método run() (el cuál tenemos que implementar (con @Override)
            int tic = 0;

            @Override
            public void run()
            {
                if (contador>=0)
                {
                    setText(Integer.toString(contador--));
                }
                else
                {
                    setText(textoFin);
                }
            }
        };
        // Empezamos dentro de 0ms y luego lanzamos la tarea cada 1000ms = 1seg
        timer.schedule(task, 10, 1000);     
    }
    
}
