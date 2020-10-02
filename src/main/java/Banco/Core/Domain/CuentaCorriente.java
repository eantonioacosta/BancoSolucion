
package Banco.Core.Domain;

import java.util.Date;


public class CuentaCorriente extends CuentaBancaria{
    private double sobregiro;

    public CuentaCorriente() {
    }


    public CuentaCorriente(double sobregiro, String numero, String nombre, String ciudad) {
        super(numero, nombre, ciudad);
        this.sobregiro = sobregiro;
    }
   
    
    public CuentaCorriente(String numero, String nombre, String ciudad) {
        super(numero, nombre, ciudad);
    }

    @Override
    public String Consignar(double valorConsignacion,String ciudad, Date fecha) {
        if (valorConsignacion <= 0) {
            return "El valor a consignar es incorrecto";
        }

        if (valorConsignacion < 100000 && NoTieneConsignacion()) {
            return "El valor mínimo de la primera consignación debe ser de $100.000 mil pesos. Su nuevo saldo es $0 pesos";
        }

        double saldoAnterior = getSaldo();
        setSaldo(getSaldo()+valorConsignacion);

        _movimientos.add(new MovimientosBancarios(saldoAnterior, valorConsignacion, 0, ciudad, "CONSIGNACION", fecha));
        return "Su Nuevo Saldo es de " + getSaldo() + " pesos";
    }

    @Override
    public String retirar(double valorRetirar,  String ciudad, Date fecha) {
        if (valorRetirar <= 0) {
            return "El valor a retirar es incorrecto";
        }
        double valorRetiroReal = valorRetirar+costoRetiro(valorRetirar, fecha);
        double valorRestante = getSaldo()-valorRetiroReal;
        
        if(valorRestante<=sobregiro ){
            return "El nimimo valor de la cuenta es de "+getSobregiro()+" / No tiene saldo suficiente!";
        }

        double saldoAnterior = getSaldo();

        setSaldo(valorRestante);
        
        _movimientos.add(new MovimientosBancarios(saldoAnterior, valorRetirar, 0, ciudad, "RETIRO", fecha));
        return "Retiro exitoso, Su Nuevo Saldo es de " + getSaldo() + " pesos";
    }

    
    
    
    public double getSobregiro() {
        return sobregiro;
    }
    public void recargarSobreGiro(double recargo){
        sobregiro+=recargo;
    }

    public void setSobregiro(double sobregiro) {
        this.sobregiro = sobregiro;
    }

    @Override
    public double costoRetiro(double retiro,Date fecha ) {
        return (retiro*4)/1000;
 
    }
    
}
