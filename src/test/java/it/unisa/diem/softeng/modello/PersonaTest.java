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
    
}
