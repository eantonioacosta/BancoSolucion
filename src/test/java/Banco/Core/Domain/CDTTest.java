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
public class CDTTest {
    
    public CDTTest() {
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
     * Test of Consignar method, of class CDT.
     */
    @Test
    public void testConsignar() {
        System.out.println("Consignar");
        double valorConsignacion = 0.0;
        String ciudad = "";
        CDT instance = new CDT();
        String expResult = "";
        String result = instance.Consignar(valorConsignacion, ciudad, new Date(2020, 11, 1));
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retirar method, of class CDT.
     */
    @Test
    public void testRetirar() {
        System.out.println("retirar");
        double valorRetirar = 0.0;
        String ciudad = "";
        CDT instance = new CDT();
        String expResult = "";
        String result = instance.retirar(valorRetirar, ciudad, new Date(2020, 11, 1));
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumero method, of class CDT.
     */
    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        CDT instance = new CDT();
        String expResult = "";
        String result = instance.getNumero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumero method, of class CDT.
     */
    @Test
    public void testSetNumero() {
        System.out.println("setNumero");
        String numero = "";
        CDT instance = new CDT();
        instance.setNumero(numero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValorCDT method, of class CDT.
     */
    @Test
    public void testGetValorCDT() {
        System.out.println("getValorCDT");
        CDT instance = new CDT();
        double expResult = 0.0;
        double result = instance.getValorCDT();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValorCDT method, of class CDT.
     */
    @Test
    public void testSetValorCDT() {
        System.out.println("setValorCDT");
        double valorCDT = 0.0;
        CDT instance = new CDT();
        instance.setValorCDT(valorCDT);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSaldo method, of class CDT.
     */
    @Test
    public void testGetSaldo() {
        System.out.println("getSaldo");
        CDT instance = new CDT();
        double expResult = 0.0;
        double result = instance.getSaldo();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSaldo method, of class CDT.
     */
    @Test
    public void testSetSaldo() {
        System.out.println("setSaldo");
        double Saldo = 0.0;
        CDT instance = new CDT();
        instance.setSaldo(Saldo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTermino method, of class CDT.
     */
    @Test
    public void testGetTermino() {
        System.out.println("getTermino");
        CDT instance = new CDT();
        int expResult = 0;
        int result = instance.getTermino();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTermino method, of class CDT.
     */
    @Test
    public void testSetTermino() {
        System.out.println("setTermino");
        int termino = 0;
        CDT instance = new CDT();
        instance.setTermino(termino);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFecha method, of class CDT.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        CDT instance = new CDT();
        Fecha expResult = null;
        Fecha result = instance.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFecha method, of class CDT.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        Fecha fecha = null;
        CDT instance = new CDT();
        instance.setFecha(fecha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
