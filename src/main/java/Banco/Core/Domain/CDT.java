
package Banco.Core.Domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class CDT implements IServicioFinanciero{
    private String numero;
    private double valorCDT;
    private double Saldo; //ValorCDT + intereses
    private int termino;   // 1=TRIMESTRAL; 2= SEMESTRAL; 3= ANUAL
    boolean consignado;
    private Date fecha;
    private List<MovimientosBancarios> _movimientos;
    
    public CDT() {
        _movimientos = new ArrayList<>();
        consignado=false;
    }

    public CDT(String numero, double valorCDT, int termino, Date fecha) {
        this.numero = numero;
        this.valorCDT = valorCDT;
        this.termino = termino;
        this.fecha = fecha;
        _movimientos = new ArrayList<>();
        consignado=false;
    }

    @Override
    public String Consignar(double valorConsignacion, String ciudad, Date fecha) {
        if (valorConsignacion <= 0) {
            return "El valor a consignar es incorrecto";
        }
        if(consignado){
            return "Solo se puede realizar una consignacion";
        }

        if (valorConsignacion < 1000000) {
            return "El valor de consignación inicial debe ser de mínimo 1 millón de pesos.";
        }

        setValorCDT(valorConsignacion);
        consignado=true;

        _movimientos.add(new MovimientosBancarios(0, valorConsignacion, 0, ciudad, "CDT-CONSIGNACION", fecha));
        return "Su Nuevo Saldo es de " + getSaldo() + " pesos";
    }

    @Override
    public String retirar(double valorRetirar, String ciudad, Date fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getValorCDT() {
        return valorCDT;
    }

    public void setValorCDT(double valorCDT) {
        this.valorCDT = valorCDT;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }

    public int getTermino() {
        return termino;
    }

    public void setTermino(int termino) {
        this.termino = termino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
