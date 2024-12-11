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
    
    /**
     * Test del metodo equals per oggetti diversi.
     */
    @Test
    public void testEqualsOggettiDiversi() {
        Persona p1 = new Persona("Mario", "Rossi");
        Persona p2 = new Persona("Luigi", "Verdi");
        assertFalse(p1.equals(p2));
    }
    
     /**
     * Test del metodo compareTo per oggetti uguali.
     */
    @Test
    public void testCompareToOggettiUguali() {
        Persona p1 = new Persona("Mario", "Rossi");
        Persona p2 = new Persona("Mario", "Rossi");
        assertEquals(0, p1.compareTo(p2));
    }
    
    /**
     * Test del metodo compareTo per ordine alfabetico del cognome.
     */
    @Test
    public void testCompareToPerCognome() {
        Persona p1 = new Persona("Mario", "Rossi");
        Persona p2 = new Persona("Luigi", "Verdi");
        assertTrue(p1.compareTo(p2) < 0);
    }
    
     /**
     * Test del metodo compareTo per ordine alfabetico del nome.
     */
    @Test
    public void testCompareToPerNome() {
        Persona p1 = new Persona("Mario", "Rossi");
        Persona p2 = new Persona("Anna", "Rossi");
        assertTrue(p2.compareTo(p1) < 0);
    }
    
    /**
     * Test per nome di un carattere e cognome normale.
     */
    @Test
    public void testBoundaryNomeUnCarattereCognomeNormale() {
        Persona p1 = new Persona("M", "Rossi");
        assertEquals("M", p1.getNome());
        assertEquals("Rossi", p1.getCognome());
    }
    
    /**
     * Test per nome normale e cognome di un carattere.
     */
    @Test
    public void testBoundaryNomeNormaleCognomeUnCarattere() {
        Persona p1 = new Persona("Mario", "R");
        assertEquals("Mario", p1.getNome());
        assertEquals("R", p1.getCognome());
    }
    
    /**
     * Test per nome lungo e cognome normale.
     */
    @Test
    public void testBoundaryNomeLungoCognomeNormale() {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < 1000; i++) 
            sb.append("A");
        
        String longName = sb.toString();
        Persona p1 = new Persona(longName, "Rossi");
        assertEquals(longName, p1.getNome());
        assertEquals("Rossi", p1.getCognome());
    }
    
    /**
     * Test per nome normale e cognome lungo.
     */
    @Test
    public void testBoundaryNomeNormaleCognomeLungo() {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < 1000; i++) 
            sb.append("B");
        
        String longSurname = sb.toString();
        Persona p1 = new Persona("Mario", longSurname);
        assertEquals("Mario", p1.getNome());
        assertEquals(longSurname, p1.getCognome());
    }

}
