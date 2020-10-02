
package Banco.Core.Domain;

import java.util.Date;

public class MovimientosBancarios {
    private double saldoAnterior;
    private double valorCredito;
    private double valorDebito;
    private String ciudad;
    private String tipo;
    private Date fecha;

    public MovimientosBancarios() {
        
    }

    public MovimientosBancarios(double saldoAnterior, double valorCredito, double valorDebito, String ciudad, String tipo, Date fecha) {
        this.saldoAnterior = saldoAnterior;
        this.valorCredito = valorCredito;
        this.valorDebito = valorDebito;
        this.ciudad = ciudad;
        this.tipo = tipo;
        this.fecha = fecha;
    }




    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(double saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public double getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(double valorCredito) {
        this.valorCredito = valorCredito;
    }

    public double getValorDebito() {
        return valorDebito;
    }

    public void setValorDebito(double valorDebito) {
        this.valorDebito = valorDebito;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }



    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    
}
