/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco.Core.Domain;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author ENOR ACOSTA
 */
public class Fecha {
    private int dia;
    private int mes;
    int anio;
    private Calendar fecha;
    
    public Fecha() {
        fecha = new GregorianCalendar();
//        anio = fecha.get(Calendar.YEAR);
//        mes = fecha.get(Calendar.MONTH)+1;
//        dia = fecha.get(Calendar.DAY_OF_MONTH);
    }

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.fecha = new GregorianCalendar();
    }


    public void setAnio(int anio) {
        this.anio = anio;
    }
    public int getDiaActual(){
        
        return fecha.get(Calendar.DAY_OF_MONTH);
    }
        public int getAnioActual(){
        return fecha.get(Calendar.YEAR);
    }
            public int getMesActual(){
        return fecha.get(Calendar.MONTH)+1;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }
    public String getFechaActual(){
        return fecha.toString();
    }

    @Override
    public String toString() {
        return "Fecha{" + "dia=" + dia + ", mes=" + mes + ", anio=" + anio + '}';
    }
    
}
