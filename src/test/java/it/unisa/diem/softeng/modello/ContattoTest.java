/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.softeng.modello;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mashalem
 */
public class ContattoTest {
    
    public ContattoTest() {
    }

    @Test
    public void testGetNumeriTelefono() {
        System.out.println("getNumeriTelefono");
        Contatto instance = null;
        List<String> expResult = null;
        List<String> result = instance.getNumeriTelefono();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Contatto instance = null;
        List<String> expResult = null;
        List<String> result = instance.getEmail();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Contatto instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
