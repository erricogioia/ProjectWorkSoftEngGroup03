package it.unisa.diem.softeng.modello;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 *
 * @author mashalem
 */
public class ContattoTest {
    
    /**
     * Test del metodo di creazione con input validi.
     */
    @Test
    void testCreazioneValida1() {
        Contatto c1 = new Contatto("Mario", "Rossi", "123", "456", "789", "a@example.com", "b@example.com", "c@example.com");
        assertEquals("Mario", c1.getNome());
        assertEquals("Rossi", c1.getCognome());
        assertEquals(Arrays.asList("123", "456", "789"), c1.getNumeriTelefono());
        assertEquals(Arrays.asList("a@example.com", "b@example.com", "c@example.com"), c1.getEmail());
    }
    
    /**
     * Test del metodo di creazione con input validi.
     */
    @Test
    void testCreazioneValida2() {
        Contatto c1 = new Contatto("Mario", "Rossi", "123", "456", "", "a@example.com", "", "c@example.com");
        assertEquals("Mario", c1.getNome());
        assertEquals("Rossi", c1.getCognome());
        assertEquals(Arrays.asList("123", "456", ""), c1.getNumeriTelefono());
        assertEquals(Arrays.asList("a@example.com", "", "c@example.com"), c1.getEmail());
    }
    
    /**
     * Test del metodo di creazione con input validi.
     */
    @Test
    void testCreazioneValida3() {
        Contatto c1 = new Contatto("Mario", "Rossi", "", "", "789", "", "b@example.com", "");
        assertEquals("Mario", c1.getNome());
        assertEquals("Rossi", c1.getCognome());
        assertEquals(Arrays.asList("", "", "789"), c1.getNumeriTelefono());
        assertEquals(Arrays.asList("", "b@example.com", ""), c1.getEmail());
    }
    
    /**
     * Test del metodo di creazione con stringhe vuote come input.
     */
    @Test
    void testCreazioneConStringheVuote() {
        Contatto c1 = new Contatto("Mario", "Rossi", "", "", "", "", "", "");
        assertEquals("Mario", c1.getNome());
        assertEquals("Rossi", c1.getCognome());
        assertEquals(Arrays.asList("", "", ""), c1.getNumeriTelefono());
        assertEquals(Arrays.asList("", "", ""), c1.getEmail());
    }
    
    /**
     * Test del metodo di creazione con valori null.
     */
    @Test
    void testCreazioneInvalidaConNull() {
        assertThrows(IllegalArgumentException.class, () -> { new Contatto("Mario", "Rossi", "123", null, "789", "a@example.com", "b@example.com", "c@example.com"); });
        assertThrows(IllegalArgumentException.class, () -> { new Contatto("Mario", "Rossi", "123", "456", "789", "a@example.com", null, "c@example.com"); });
    }
    
    /**
     * Test del metodo equals per oggetti uguali.
     */
    @Test
    void testEqualsOggettiUguali() {
        Contatto c1 = new Contatto("Mario", "Rossi", "123", "456", "789", "a@example.com", "b@example.com", "c@example.com");
        Contatto c2 = new Contatto("Mario", "Rossi", "123", "456", "789", "a@example.com", "b@example.com", "c@example.com");
        assertEquals(c1, c2);
    }
    
    /**
     * Test del metodo equals per oggetti diversi.
     */
    @Test
    void testEqualsOggettiDiversi() {
        Contatto c1 = new Contatto("Mario", "Rossi", "123", "456", "789", "a@example.com", "b@example.com", "c@example.com");
        Contatto c2 = new Contatto("Luigi", "Bianchi", "321", "654", "987", "x@example.com", "y@example.com", "z@example.com");
        assertNotEquals(c1, c2);
    }
    
    /**
     * Test dei limiti per numeri di telefono.
     */
    @Test
    void testBoundaryNumeriTelefono() {
        StringBuilder lungoTelefono = new StringBuilder();
        for (int i = 0; i < 1000; i++) 
            lungoTelefono.append("1");

        Contatto c1 = new Contatto("Mario", "Rossi", lungoTelefono.toString(), "456", "789", "a@example.com", "b@example.com", "c@example.com");
        assertTrue(c1.getNumeriTelefono().contains(lungoTelefono.toString()));
    }
    
    /**
     * Test dei limiti per email.
     */
    @Test
    void testBoundaryEmail() {
        StringBuilder lungaEmail = new StringBuilder();
        for (int i = 0; i < 1000; i++) 
            lungaEmail.append("a");
        
        lungaEmail.append("@example.com");

        Contatto c1 = new Contatto("Mario", "Rossi", "123", "456", "789", lungaEmail.toString(), "b@example.com", "c@example.com");
        assertTrue(c1.getEmail().contains(lungaEmail.toString()));
    }
    
    /**
     * Test per valori minimi accettabili.
     */
    @Test
    void testBoundaryMinimi() {
        Contatto c1 = new Contatto("Mario", "Rossi", "1", "2", "3", "a@a", "b@b", "c@c");
        assertEquals(Arrays.asList("1", "2", "3"), c1.getNumeriTelefono());
        assertEquals(Arrays.asList("a@a", "b@b", "c@c"), c1.getEmail());
    }
    
}
