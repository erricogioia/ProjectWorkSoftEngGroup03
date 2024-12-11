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
    
    /**
     * Test per nome null.
     */
    @Test
    public void testCreazioneOggettoConNomeNull() {
        assertThrows(IllegalArgumentException.class, () -> new Persona(null, "Rossi"));
    }
    
    /**
     * Test per cognome null.
     */
    @Test
    public void testCreazioneOggettoConCognomeNull() {
        assertThrows(IllegalArgumentException.class, () -> new Persona("Mario", null));
    }
    
    /**
     * Test per entrambi null.
     */
    @Test
    public void testCreazioneOggettoConEntrambiNull() {
        assertThrows(IllegalArgumentException.class, () -> new Persona(null, null));
    }
    
    /**
     * Test per entrambi vuoti.
     */
    @Test
    public void testCreazioneOggettoConEntrambiVuoti() {
        Persona p1 = new Persona("", "");
        assertEquals("", p1.getNome());
        assertEquals("", p1.getCognome());
    }
    
    /**
     * Test del metodo equals per oggetti uguali.
     */
    @Test
    public void testEqualsOggettiUguali() {
        Persona p1 = new Persona("Mario", "Rossi");
        Persona p2 = new Persona("Mario", "Rossi");
        assertTrue(p1.equals(p2));
    }
}
