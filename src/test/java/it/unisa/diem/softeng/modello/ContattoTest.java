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
    
}
