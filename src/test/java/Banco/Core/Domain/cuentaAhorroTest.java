/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco.Core.Domain;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ENOR ACOSTA
 */
public class cuentaAhorroTest {
    
    public cuentaAhorroTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    //Escenario: Valor de consignación negativo o cero 
    //H1: Como Usuario quiero realizar consignaciones a una cuenta de ahorro para salvaguardar el dinero.
    //Criterio de Aceptación:
    //1.2 El valor a abono no puede ser menor o igual a 0
    //Ejemplo
    //Dado El cliente tiene una cuenta de ahorro                                       //A =>Arrange /Preparación
    //Número 10001, Nombre “Cuenta ejemplo”, Saldo de 0 , ciudad Valledupar                               
    //Cuando Va a consignar un valor menor o igual a cero  (0)                            //A =>Act = Acción
    //Entonces El sistema presentará el mensaje. “El valor a consignar es incorrecto”  //A => Assert => Validación
    @Test
    public void NoPuedeConsignacionValorNegativoCuentaAhorroTest() {
        System.out.println("NO CONSIGNAR");
        CuentaAhorro cuentaAhorro = new CuentaAhorro("10001", "Cuenta Ejemplo", "Valledupar");
        String expResult = "El valor a consignar es incorrecto";
        Date fecha = new Date(2020, 11, 1);
        String resultado = cuentaAhorro.Consignar(0, "Valledupar",fecha);

        assertEquals(expResult, resultado);
        // TODO review the generated test code and remove the default call to fail.
        if (!resultado.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    //Escenario: Consignación Inicial Correcta
    //HU: Como Usuario quiero realizar consignaciones a una cuenta de ahorro para salvaguardar el dinero.
    //Criterio de Aceptación:
    //1.1 La consignación inicial debe ser mayor o igual a 50 mil pesos
    //1.3 El valor de la consignación se le adicionará al valor del saldo aumentará
    //Dado El cliente tiene una cuenta de ahorro
    //Número 10001, Nombre “Cuenta ejemplo”, Saldo de 0
    //Cuando Va a consignar el valor inicial de 50 mil pesos
    //Entonces El sistema registrará la consignación
    //AND presentará el mensaje. “Su Nuevo Saldo es de $50.000,00 pesos m/c”.
    @Test
    public void PuedeConsignacionInicialCorrectaCuentaAhorroTest() {
        //Preparar
        CuentaAhorro cuentaAhorro = new CuentaAhorro("10001", "Cuenta Ejemplo", "Valledupar");
        //Acción
        String expResult = "Su Nuevo Saldo es de 50000.0 pesos";
        Date fecha = new Date(2020, 11, 1);
        String resultado = cuentaAhorro.Consignar(50000, "Valledupar", fecha);
        //Verificación
        assertEquals(expResult, resultado);
        // TODO review the generated test code and remove the default call to fail.
        if (!resultado.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }
    //Escenario: Consignación Inicial Incorrecta
    //HU: Como Usuario quiero realizar consignaciones a una cuenta de ahorro para salvaguardar el dinero.
    //Criterio de Aceptación:
    //1.1 La consignación inicial debe ser mayor o igual a 50 mil pesos
    //Dado El cliente tiene una cuenta de ahorro con
    //Número 10001, Nombre “Cuenta ejemplo”, Saldo de 0
    //Cuando Va a consignar el valor inicial de $49.999 pesos
    //Entonces El sistema no registrará la consignación
    //AND presentará el mensaje. “El valor mínimo de la primera consignación debe ser de $50.000 mil pesos. Su nuevo saldo es $0 pesos”. 

    @Test
    public void NoPuedeConsignarMenosDeCincuentaMilPesosTest() {
        //Preparar
        var cuentaAhorro = new CuentaAhorro("10001", "Cuenta Ejemplo", "Valledupar");
        String expResult = "El valor mínimo de la primera consignación debe ser de $50.000 mil pesos. Su nuevo saldo es $0 pesos";
        //Acción
        Date fecha = new Date(2020, 11, 1);
        var resultado = cuentaAhorro.Consignar(49000, "Valledupar", fecha);
        //Verificación
        assertEquals(expResult, resultado);
        
        if (!resultado.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void consignacionNacionalOtraCiudad() {
        //Preparar
        var cuentaAhorro = new CuentaAhorro("10001", "Cuenta Ejemplo", "Valledupar");
        String expResult = "Su Nuevo Saldo es de 50000.0 pesos";
        //Acción
        Date fecha = new Date(2020, 11, 1);
        var resultado = cuentaAhorro.Consignar(60000, "Monteria", fecha);
        //Verificación
        assertEquals(expResult, resultado);
        
        if (!resultado.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }
    
    //2.1 El valor a retirar se debe descontar del saldo de la cuenta.
    @Test
    public void retiroDelSaldo() {
        //Preparar
        var cuentaAhorro = new CuentaAhorro("10001", "CUENTA_AHORRO", "MONTERIA");
        Date fecha = new Date(2020, 11, 1);
        
        cuentaAhorro.Consignar(80000, "MONTERIA", fecha);
        
        String expResult = "Retiro exitoso, Su Nuevo Saldo es de 50000.0 pesos";
        //Acción

        var resultado = cuentaAhorro.retirar(30000, "MONTERIA", fecha);
        //Verificación
        assertEquals(expResult, resultado);
        
        if (!resultado.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }
    
    //2.2 El saldo mínimo de la cuenta deberá ser de 20 mil pesos.
    @Test
    public void retiroSaldoMinimoValorVeinteMilPesos() {
        //Preparar
        var cuentaAhorro = new CuentaAhorro("10001", "CUENTA_AHORRO", "MONTERIA");
        Date fecha = new Date(2020, 11, 1);
        cuentaAhorro.Consignar(80000, "MONTERIA", fecha);
        
        String expResult = "El nimimo valor de la cuenta es de $20000.0 / No tiene saldo suficiente!";
        //Acción
        
        var resultado = cuentaAhorro.retirar(70000, "MONTERIA",fecha);
        //Verificación
        assertEquals(expResult, resultado);
        
        if (!resultado.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }
//        2.3 Los primeros 3 retiros del mes no tendrán costo.
//    2.4 Del cuarto retiro en adelante del mes tendrán un valor de 5 mil pesos.
    @Test
    public void retiroSaldoDespuesDeTresMes() {
        //Preparar
        var cuentaAhorro = new CuentaAhorro("10001", "CUENTA_AHORRO", "MONTERIA");
        Date fecha = new Date(2020, 11, 1);
        //Date fecha2 = new Date(2020, 1, 1);
        cuentaAhorro.Consignar(80000, "MONTERIA", fecha);
        String expResult1 = "Retiro exitoso, Su Nuevo Saldo es de 70000.0 pesos";
        String expResult2 = "Retiro exitoso, Su Nuevo Saldo es de 50000.0 pesos";
        String expResult3 = "Retiro exitoso, Su Nuevo Saldo es de 30000.0 pesos";
        String expResult4 = "Retiro exitoso, Su Nuevo Saldo es de 21000.0 pesos";
        //Acción
        String resultado1 = cuentaAhorro.retirar(10000, "MONTERIA", fecha); //restan 70k
        String resultado2 = cuentaAhorro.retirar(20000, "MONTERIA", fecha); //restan 50k
        String resultado3 = cuentaAhorro.retirar(20000, "MONTERIA", fecha); //restan 30k
        String resultado4 = cuentaAhorro.retirar(4000, "MONTERIA", fecha); // seria 30k-4k-5k por el 4to mes;
        //Verificación
        assertEquals(expResult1, resultado1);
        assertEquals(expResult2, resultado2);
        assertEquals(expResult3, resultado3);
        assertEquals(expResult4, resultado4);
        
        if (!resultado1.equals(expResult1)) {
            fail("The test case is a prototype.");
        }
    }
}
