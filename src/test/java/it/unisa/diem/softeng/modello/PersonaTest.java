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
    
    /**
     * Test per nome e cognome non vuoti.
     */
    @Test
    public void testCreazioneOggettoConNomeECognome() {
        Persona p1 = new Persona("Mario", "Rossi");
        assertEquals("Mario", p1.getNome());
        assertEquals("Rossi", p1.getCognome());
    }
    
    /**
     * Test per nome vuoto. BoundaryTest1.
     */
    @Test
    public void testCreazioneOggettoConNomeVuoto() {
        Persona p1 = new Persona("", "Rossi");
        assertEquals("", p1.getNome());
        assertEquals("Rossi", p1.getCognome());
    }
    
    /**
     * Test per cognome vuoto. BoundaryTest2.
     */
    @Test
    public void testCreazioneOggettoConCognomeVuoto() {
        Persona p1 = new Persona("Mario", "");
        assertEquals("Mario", p1.getNome());
        assertEquals("", p1.getCognome());
    }
    
}
