
package Banco.Core.Domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class CuentaBancaria implements IServicioFinanciero{

    private String numero;
    private String nombre;
    private String ciudad;
    private double saldo;
    public List<MovimientosBancarios> _movimientos;
    
    abstract public double costoRetiro(double retiro, Date fecha);
    
    public CuentaBancaria() {
        this._movimientos  = new ArrayList<>();
    }

    public CuentaBancaria(String numero, String nombre, String ciudad) {
        this.numero = numero;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this._movimientos  = new ArrayList<>();
    }





    public boolean NoTieneConsignacion() {
        if (!_movimientos.stream().noneMatch((_movimiento) -> (_movimiento.getTipo().equals("CONSIGNACION")))) {
            return false;
        }
      return true;
    }
    

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<MovimientosBancarios> getMovimientos() {
        return _movimientos;
    }

    public void setMovimientos(List<MovimientosBancarios> _movimientos) {
        this._movimientos = _movimientos;
    }
    public int retirosMes(Date fecha) {
        int numRetiros = 0;
        for (MovimientosBancarios _movimiento : _movimientos) {
            if (_movimiento.getTipo().equals("RETIRO")) {
                if (_movimiento.getFecha().getMonth() == fecha.getMonth()) {
                    numRetiros += 1;
                }
            }

        }
        return numRetiros;
    }



    
}
