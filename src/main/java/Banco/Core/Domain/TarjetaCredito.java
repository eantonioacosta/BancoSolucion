
package Banco.Core.Domain;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TarjetaCredito implements IServicioFinanciero{
    private String numeroTarjeta;
    private String fechaVencimiento;
    private String cvv;
    private double cupoDisponible; 
    private double cupo; //El cupo inicial
    private double saldoDeuda; //el dinero que debe
    private List<MovimientosBancarios> _movimientos;
    
    public TarjetaCredito() {
        cupoDisponible = 0;
        saldoDeuda = 0;
        _movimientos = new ArrayList<>();
    }

    public TarjetaCredito(String numeroTarjeta, String fechaVencimiento, String cvv, double cupo) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.cvv = cvv;
        this.cupo = cupo;
        cupoDisponible = 0;
        saldoDeuda = 0;
        _movimientos = new ArrayList<>();
    }

    
    
    @Override
    public String Consignar(double abono, String ciudad, Date fecha) {//ABONOO
        if (abono <= 0) {
            return "El valor del abono es incorrecto";
        }

        if (abono > getSaldoDeuda()) {
            return "Su abono supera el saldo";
        }
        
        double saldoAnterior = getSaldoDeuda();
        double cupoDisponibleAnterior = getCupoDisponible();
        setCupoDisponible(getCupoDisponible()+abono);
        setSaldoDeuda(getSaldoDeuda()-abono);

        _movimientos.add(new MovimientosBancarios(saldoAnterior, abono, cupoDisponibleAnterior, ciudad, "ABONO", fecha));
        return "Su Nuevo cupo Disponible es de $" + getCupoDisponible()+ " pesos, Saldo = "+getSaldoDeuda();
    }

    @Override
    public String retirar(double avance, String ciudad, Date fecha) {//AVENCE
        if (avance <= 0) {
            return "El valor del Avance es incorrecto";
        }
        if (avance > getCupoDisponible()) {
            return "No tiene suficiente Cupo Disponible";
        }

        double saldoAnterior = getSaldoDeuda();
        double cupoDisponibleAnterior = getCupoDisponible();
        setCupoDisponible(getCupoDisponible()-avance);
        setSaldoDeuda(getSaldoDeuda()+avance);

        _movimientos.add(new MovimientosBancarios(saldoAnterior, avance, cupoDisponibleAnterior, ciudad, "ABONO", fecha));
        return "Avance exitoso, Su Cupo disponible es de $" + getCupoDisponible()+ " pesos / deuda = "+getSaldoDeuda();
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public double getCupoDisponible() {
        return cupoDisponible;
    }

    public void setCupoDisponible(double cupoDisponible) {
        this.cupoDisponible = cupoDisponible;
    }

    public double getCupo() {
        return cupo;
    }

    public void setCupo(double cupo) {
        this.cupo = cupo;
    }

    public double getSaldoDeuda() {
        return saldoDeuda;
    }

    public void setSaldoDeuda(double saldoDeuda) {
        this.saldoDeuda = saldoDeuda;
    }

    public List<MovimientosBancarios> getMovimientos() {
        return _movimientos;
    }

    public void setMovimientos(List<MovimientosBancarios> _movimientos) {
        this._movimientos = _movimientos;
    }
    
    
}
