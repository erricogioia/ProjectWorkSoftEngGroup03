/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.modello;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author antoniopiodamico
 */
public class PersonaTest {
    
    public PersonaTest() {
    }

    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Persona instance = null;
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCognome() {
        System.out.println("getCognome");
        Persona instance = null;
        String expResult = "";
        String result = instance.getCognome();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        Persona instance = null;
        instance.setNome(nome);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetCognome() {
        System.out.println("setCognome");
        String cognome = "";
        Persona instance = null;
        instance.setCognome(cognome);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Persona instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Persona other = null;
        Persona instance = null;
        int expResult = 0;
        int result = instance.compareTo(other);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Persona instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
