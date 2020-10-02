/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco.Core.Domain;

import java.util.Date;
import java.util.List;
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
public class TarjetaCreditoTest {
    
    public TarjetaCreditoTest() {
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
     * Como Usuario quiero realizar consignaciones (abonos) a una Tarjeta
     * Crédito para abonar al saldo del servicio. Criterios de Aceptación 
     * 5.1 El valor a abono no puede ser menor o igual a 0. 
     * 5.2 El abono podrá ser máximo el valor del saldo de la tarjeta de crédito. 
     * 5.3 Al realizar abono el cupo disponible aumentará con el mismo valor que el 
     * valor del abono y reducirá de manera equivalente el saldo.
     */
    @Test
    public void AbonoNoPuedeSerNegativo() {
        String ciudad = "VALLEDUPAR";
        TarjetaCredito instance = new TarjetaCredito("1009890909", "11/20", "538", 100000);
        Date fecha = new Date(2020, 11, 1);
        double abono = -200;
        String expResult = "El valor del abono es incorrecto";;
        String result = instance.Consignar(abono, ciudad , fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void AbonoMaximoElSaldoTarjeta() {
        String ciudad = "VALLEDUPAR";
        TarjetaCredito instance = new TarjetaCredito("1009890909", "11/20", "538", 100000);
        Date fecha = new Date(2020, 11, 1);
        instance.setCupoDisponible(30000);
        instance.setSaldoDeuda(70000);
        double abono = 80000;
        String expResult = "Su abono supera el saldo";
        String result = instance.Consignar(abono, ciudad, fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }
        @Test
    public void AbonoCupoDisponibleAumenta() {
        String ciudad = "VALLEDUPAR";
        TarjetaCredito instance = new TarjetaCredito("1009890909", "11/20", "538", 100000);
        Date fecha = new Date(2020, 11, 1);
        instance.setCupoDisponible(50000);
        instance.setSaldoDeuda(50000);
        double abono = 40000;
        String expResult = "Su Nuevo cupo Disponible es de $90000.0 pesos, Saldo = 10000.0";
        String result = instance.Consignar(abono, ciudad, fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }

    /**
     * Como Usuario quiero realizar retiros (avances) a una cuenta de crédito
     * para retirar dinero en forma de avances del servicio de crédito.
     * Criterios de Aceptación 
     * 6.1 El valor del avance debe ser mayor a 0. 
     * 6.2 Al realizar un avance se debe reducir el valor disponible del cupo con el valor del avance. 
     * 6.3 Un avance no podrá ser mayor al valor disponible del cupo.
     */
    @Test
    public void avanceValorNoPuedeSerNegativo() {
        String ciudad = "VALLEDUPAR";
        TarjetaCredito instance = new TarjetaCredito("1009890909", "11/20", "538", 100000);
        Date fecha = new Date(2020, 11, 1);
        
        double avance = -200;
        String expResult = "El valor del abono es incorrecto";
        String result = instance.Consignar(avance, ciudad, fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }
    
    @Test
    public void AvanceCupoDisponibleReduce() {
        String ciudad = "VALLEDUPAR";
        TarjetaCredito instance = new TarjetaCredito("1009890909", "11/20", "538", 100000);
        Date fecha = new Date(2020, 11, 1);
        instance.setCupoDisponible(50000);
        instance.setSaldoDeuda(50000);
        double avance = 40000;
        String expResult = "Avance exitoso, Su Cupo disponible es de $10000.0 pesos / deuda = 90000.0";
        String result = instance.retirar(avance, ciudad, fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }
    @Test
    public void AvanceMaxivoValorDeudaTarjeta() {
        String ciudad = "VALLEDUPAR";
        TarjetaCredito instance = new TarjetaCredito("1009890909", "11/20", "538", 100000);
        Date fecha = new Date(2020, 11, 1);
        instance.setCupoDisponible(40000);
        instance.setSaldoDeuda(60000);
        double avance = 45000;
        String expResult = "No tiene suficiente Cupo Disponible";
        String result = instance.retirar(avance, ciudad, fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (!result.equals(expResult)) {
            fail("The test case is a prototype.");
        }
    }
    
}
