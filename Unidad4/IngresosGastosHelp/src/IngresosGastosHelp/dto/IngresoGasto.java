/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IngresosGastosHelp.dto;

import java.text.DecimalFormat;
import java.util.Date;

/**
 *
 * @author Eduardo
 */
public class IngresoGasto {
    private Date Fecha;
    private String Concepto;
    private double Ingreso;
    private double Gasto;

    public IngresoGasto(Date Fecha, String Concepto, double Importe) {
        this.Fecha = Fecha;
        this.Concepto = Concepto;
        if (Importe<0){
            this.Gasto=Importe;
        } else {
            this.Ingreso=Importe;
        }
    }

    public Date getFecha() {
        return this.Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getConcepto() {
        return this.Concepto;
    }

    public void setConcepto(String Concepto) {
        this.Concepto = Concepto;
    }

    public double getIngreso() {
        return this.Ingreso;
    }

    public void setIngreso(double Ingreso) {
        this.Ingreso = Ingreso;
    }
    
    public double getGasto() {
        return this.Gasto;
    }

    public void setGasto(double gasto) {
        this.Gasto = Gasto;
    }
    
}
