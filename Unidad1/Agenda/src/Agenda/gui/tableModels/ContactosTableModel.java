/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda.gui.tableModels;

import Agenda.dto.Contacto;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author alumnop
 */
public class ContactosTableModel extends AbstractTableModel{
    private List<Contacto> listaContactos;
    private String[] cabeceras={"Nombre","Apelliodos","Fecha","Provincia"};   

    //creamos el construcctor de la clase
    public ContactosTableModel(List<Contacto> listaContactos) {    //cuando creemos el objeto le pasaremos al constructor la lista de contactos de la clase logicaNegocio
        this.listaContactos = listaContactos;
    }

    //estos métodos son metodos abstractos de AbstractTableModel que tenemos que implementar
    @Override
    public int getRowCount() {
        //método que devuelve el número de filas de la tabla
        return listaContactos.size();
    }

    @Override
    public int getColumnCount() {
        //método que devuelve el número de columnas de la tabla (las columnas las tenemos declaradas en un array de Strin 'cabeceras'
        return cabeceras.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //método que devuelve el número de filas de la tabla
        switch (columnIndex){
            case 0: return listaContactos.get(rowIndex).getNombre();
            case 1: return listaContactos.get(rowIndex).getApellidos();
            case 2: return listaContactos.get(rowIndex).getDireccion();
            case 3: return listaContactos.get(rowIndex).getTelefono();
        }
        return null;
    }
    
    //reescribimos el método para que saque el nombre de las columnas en base a nuestro array 'cabeceras'
    @Override
    public String getColumnName(int i) {
        return cabeceras[i]; 
    }
    
  
    //creamos este método que borra una entrada en la tabla
   public void deleteRow(int row) {
      if (!(listaContactos.size()==0)) {
         listaContactos.remove(row);         //borra la fila
         //fireTableRowsDeleted(row, row);    //Notifica a todos los listeners que las filas dentro del rango [firstRow, lastRow], inclusive, han sido eliminadas
         fireTableDataChanged();  //Notifica a todos los listeners que el valor de la tabla ha cambiado (con esto saltan las acciones necesarias como repintar la tabla
      }
   }    
   
    public void refrescar() {
      fireTableDataChanged();  //Notifica a todos los listeners que el valor de la tabla ha cambiado (con esto saltan las acciones necesarias como repintar la tabla
    }
}
