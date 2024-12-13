/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.servizio;

import it.unisa.diem.softeng.modello.Contatto;
import javafx.collections.ObservableMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author erricogioia
 */
public class RubricaTest {
    
    public RubricaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getContatti method, of class Rubrica.
     */
    @Test
    public void testGetContatti() {
        System.out.println("getContatti");
        Rubrica instance = null;
        ObservableMap<String, Contatto> expResult = null;
        ObservableMap<String, Contatto> result = instance.getContatti();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creaContatto method, of class Rubrica.
     */
    @Test
    public void testCreaContatto() {
        System.out.println("creaContatto");
        Contatto contatto = null;
        Rubrica instance = null;
        boolean expResult = false;
        boolean result = instance.creaContatto(contatto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rimuoviContatto method, of class Rubrica.
     */
    @Test
    public void testRimuoviContatto() {
        System.out.println("rimuoviContatto");
        Contatto contatto = null;
        Rubrica instance = null;
        instance.rimuoviContatto(contatto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificaContatto method, of class Rubrica.
     */
    @Test
    public void testModificaContatto() {
        System.out.println("modificaContatto");
        Contatto contatto = null;
        Rubrica instance = null;
        boolean expResult = false;
        boolean result = instance.modificaContatto(contatto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cercaContatto method, of class Rubrica.
     */
    @Test
    public void testCercaContatto() {
        System.out.println("cercaContatto");
        String str = "";
        Rubrica instance = null;
        ObservableMap<String, Contatto> expResult = null;
        ObservableMap<String, Contatto> result = instance.cercaContatto(str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
