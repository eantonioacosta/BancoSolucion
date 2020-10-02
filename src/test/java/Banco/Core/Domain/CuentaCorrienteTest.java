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
public class CuentaCorrienteTest {
    
    public CuentaCorrienteTest() {
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


     /**
     * Como Usuario quiero realizar consignaciones a una cuenta corriente para salvaguardar el dinero. Criterios de Aceptación 
     * 3.1 La consignaciónn inicial debe ser de mínimo 100 mil pesos. 
     * 3.2 El valor consignado debe ser adicionado al saldo de la cuenta.
     */
    @Test
    public void NoPuedeConsignarMenorDeCienMilPesosInicial() {
        System.out.println("Consignar");
        double valorConsignacion = 80000;
        String ciudad = "MONTERIA";
        CuentaCorriente instance = new CuentaCorriente(0, "10001", "CUENTA_CORRIENTE", ciudad);
        Date fecha = new Date(2020, 11, 1);
        String expResult = "El valor mínimo de la primera consignación debe ser de $100.000 mil pesos. Su nuevo saldo es $0 pesos";
        String result = instance.Consignar(valorConsignacion, ciudad, fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void consignacionSaldoCorrecto() {
        double valorConsignacion = 120000;
        String ciudad = "MONTERIA";
        CuentaCorriente instance = new CuentaCorriente(0, "10001", "CUENTA_CORRIENTE", ciudad);
        Date fecha = new Date(2020, 11, 1);
        var expResult = "Su Nuevo Saldo es de 120000.0 pesos";
        String result = instance.Consignar(valorConsignacion, ciudad, fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }
    /*Como Usuario quiero realizar retiros a una cuenta corriente para salvaguardar el dinero.
        Criterios de Aceptación
        4.1 El valor a retirar se debe descontar del saldo de la cuenta.
        4.3 El retiro tendrá un costo del 4×Mil
            Ejemplo: Se tienen una cuenta con $100.000.0 de saldo y se retiran $40.000.0:
            valor 4xmil= 40.000*4/1000 = $160
            valor retiro total = $40.160
            nuevo saldo = 100.000-40.160 = $59.840 pesos
     */

    @Test
    public void retiroCuatroPorMil() {
        double valorRetirar = 40000;
        String ciudad = "VALLEDUPAR";
        CuentaCorriente instance = new CuentaCorriente(0, "10001", "CUENTA_CORRIENTE", ciudad);
        Date fecha = new Date(2020, 11, 1);
        instance.Consignar(100000, ciudad, fecha);
        
        String expResult = "Retiro exitoso, Su Nuevo Saldo es de 59840.0 pesos";
        String result = instance.retirar(valorRetirar, ciudad, fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }
    /**
     * 4.2 El saldo mínimo deberá ser mayor o igual al cupo de sobregiro.
     * Ejemplo: Creo una cuenta con un sobregiro de 20.000 y le consigno $80.000 e intento retirar 70.000
     */


    @Test
    public void SaldoMinimoMayorIgualCupoSobregiro() {
        double valorRetirar = 70000;
        String ciudad = "VALLEDUPAR";
        CuentaCorriente instance = new CuentaCorriente(20000, "10001", "CUENTA_CORRIENTE", ciudad);
        Date fecha = new Date(2020, 11, 1);
        instance.Consignar(80000, ciudad, fecha);
        
        String expResult = "El nimimo valor de la cuenta es de 20000.0 / No tiene saldo suficiente!";
        String result = instance.retirar(valorRetirar, ciudad, fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }
    
}
