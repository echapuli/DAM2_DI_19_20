/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionClientes.tablemodels;

import GestionClientes.dto.Cliente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author eduar
 */
public class ClientesTableModel extends AbstractTableModel {
    private List<Cliente> listaClientes;
    private String[] cabeceras={"Nombre","Apellidos","Fecha","Provincia"};
    public ClientesTableModel(List<Cliente> listaclientes) {
        this.listaClientes = listaclientes;
    }
    
    @Override
    public int getRowCount() {
        return listaClientes.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return listaClientes.get(rowIndex).getNombre();
            case 1:
                return listaClientes.get(rowIndex).getApellidos();
            case 2:
                return listaClientes.get(rowIndex).getFecha();
            case 3:
                return listaClientes.get(rowIndex).getProvincia();                
        }
        return null;
    }

    @Override
    public String getColumnName(int i) {
        return cabeceras[i];
    }
    
}
