package it.unisa.diem.softeng.servizio;

import static org.junit.jupiter.api.Assertions.*;
import it.unisa.diem.softeng.modello.Contatto;
import it.unisa.diem.softeng.modello.Persona;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Map;

/**
 *
 * @author erricogioia
 */
public class RubricaTest {
    
    private InterfacciaValidaContatto validatore;
    private InterfacciaRubrica rubrica;

    @BeforeEach
    void setUp() {
        validatore = new ValidaContatto();
        rubrica = new Rubrica(validatore);
    }
    
    /**
     * Test del costruttore con validatore valido.
     */
    @Test
    void testCostruttoreValido() {
        assertNotNull(rubrica);
        assertTrue(rubrica.getContatti().isEmpty());
    }
    
    /**
     * Test del costruttore con validatore nullo.
     */
    @Test
    void testCostruttoreConValidatoreNull() {
        assertThrows(IllegalArgumentException.class, () -> { new Rubrica(null); });
    }
    
    /**
     * Test del metodo creaContatto con input valido.
     */
    @Test
    void testCreaContattoValido() {
        Contatto c1 = new Contatto("Mario", "Rossi", "1234567890", "", "", "a@example.com", "", "");
        assertTrue(rubrica.creaContatto(c1));
        assertEquals(1, rubrica.getContatti().size());
        assertTrue(rubrica.getContatti().containsValue(c1));
    }
    
    /**
     * Test del metodo creaContatto con input invalido.
     */
    @Test
    void testCreaContattoInvalido() {
        Contatto c1 = new Contatto("Mario", "Rossi", "1", "", "", "a", "", "");
        assertFalse(rubrica.creaContatto(c1));
        assertEquals(0, rubrica.getContatti().size());
        assertFalse(rubrica.getContatti().containsValue(c1));
    }
    
    /**
     * Test del metodo creaContatto con c1 null.
     */
    @Test
    void testCreaContattoNull() {
        assertThrows(IllegalArgumentException.class, () -> { rubrica.creaContatto(null); });
    }
    
    /**
     * Test del metodo rimuoviContatto con c1 esistente.
     */
    @Test
    void testRimuoviContattoEsistente() {
        Contatto c1 = new Contatto("Mario", "Rossi", "", "1234567890", "1234567890", "", "b@example.com", "c@example.com");
        rubrica.creaContatto(c1);
        rubrica.rimuoviContatto(c1);
        assertFalse(rubrica.getContatti().containsValue(c1));
        assertTrue(rubrica.getContatti().isEmpty());
    }
    
    /**
     * Test del metodo rimuoviContatto con c1 non esistente.
     */
    @Test
    void testRimuoviContattoNonEsistente() {
        Contatto c1 = new Contatto("Mario", "Rossi", "1234567890", "1234567890", "1234567890", "a@example.com", "b@example.com", "c@example.com");
        rubrica.rimuoviContatto(c1);
        assertFalse(rubrica.getContatti().containsValue(c1));
    }
    
    /**
     * Test del metodo modificaContatto con c1 esistente. Modifica del campo email/numeroTelefono.
     */
    @Test
    void testModificaContattoEsistente1() {
        Contatto c1 = new Contatto("Mario", "Rossi", "1234567890", "1234567890", "1234567890", "a@example.com", "b@example.com", "c@example.com");
        Persona k1 = (Persona) c1;
        rubrica.creaContatto(c1);
        Contatto c1Modificato = new Contatto("Mario", "Rossi", "1234567890", "1234567890", "1234567890", "x@example.com", "y@example.com", "z@example.com");
        assertTrue(rubrica.modificaContatto(c1Modificato, k1));
        assertTrue(rubrica.getContatti().containsValue(c1Modificato));
        assertFalse(rubrica.getContatti().containsValue(c1));
    }
    
}
