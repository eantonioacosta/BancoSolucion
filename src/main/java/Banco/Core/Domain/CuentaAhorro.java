
package Banco.Core.Domain;

import java.util.Date;


public class CuentaAhorro extends CuentaBancaria{

    public CuentaAhorro(String numero, String nombre, String ciudad) {
        super(numero, nombre, ciudad);
    }

    @Override
    public String Consignar(double valorConsignacion, String ciudad, Date fecha) {
        if (valorConsignacion <= 0) {
            return "El valor a consignar es incorrecto";
        }

        if (valorConsignacion < 50000 && NoTieneConsignacion()) {
            return "El valor mínimo de la primera consignación debe ser de $50.000 mil pesos. Su nuevo saldo es $0 pesos";
        }
        if (!ciudad.equals(getCiudad())) {
            if (valorConsignacion <= 10000) {
                return "EL costo de la consignacion supera a la cosignacion";
            }
            valorConsignacion-=10000;
        }
        double saldoAnterior = getSaldo();
        setSaldo(getSaldo()+valorConsignacion);

        _movimientos.add(new MovimientosBancarios(saldoAnterior, valorConsignacion, 0, ciudad, "CONSIGNACION", fecha));
        return "Su Nuevo Saldo es de " + getSaldo() + " pesos";
    }

    @Override
    public String retirar(double valorRetirar, String ciudad, Date fecha) {
        if (valorRetirar <= 0) {
            return "El valor a retirar es incorrecto";
        }
        double valorRetiroReal = valorRetirar+costoRetiro(valorRetirar, fecha);
        double valorRestante = getSaldo()-valorRetiroReal;
        
        if(valorRestante<=20000 ){
            return "El nimimo valor de la cuenta es de $20000.0 / No tiene saldo suficiente!";
        }

        double saldoAnterior = getSaldo();

        setSaldo(valorRestante);
        
        _movimientos.add(new MovimientosBancarios(saldoAnterior, valorRetiroReal, 0, ciudad, "RETIRO",fecha));
        return "Retiro exitoso, Su Nuevo Saldo es de " + getSaldo() + " pesos";
    }

    @Override
    public double costoRetiro(double retiro, Date fecha){
        if(retirosMes(fecha)<3){
            return 0;
        }else{
            return 5000;
        }
    }
    

    
}
