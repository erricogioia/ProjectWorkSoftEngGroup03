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

/**
 * @brief Le classi di equivalenza per i metodi di test verranno raggruppate secondo i seguenti criteri.
 *
 * Costruttore Rubrica(InterfacciaValidaContatto valida)
 * - CE1: Valida non nullo (null).
 * Dati non validi: Valida nullo (null).
 *
 * Metodo creaContatto
 * - CE2: contatto valido.
 * - CE3: contatto non valido.
 * Dati non validi: contatto nullo (null).
 *
 * Metodo rimuoviContatto
 * - CE4: contatto esistente in rubrica.
 * - CE5: contatto non esistente in rubrica.
 * Dati non validi: contatto nullo (null)
 *
 * Metodo modificaContatto
 * Contatto:
 * - CE6: contatto valido.
 * - CE7: contatto non valido.
 * Dati non validi: contatto nullo (null).
 * 
 * Key:
 * - CE8: chiave di un contatto esistente.
 * - CE9: chiave di un contatto non esistente.
 * Dati non validi: chiave nulla (null).
 * 
 * Metodo cercaContatto
 * - CE10: stringa vuota.
 * - CE11: stringa non vuota.
 * Dati non validi: stringa nulla (null).
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
     * Test del costruttore con validatore valido. CE1.
     */
    @Test
    void testCostruttoreValido() {
        assertNotNull(rubrica);
        assertTrue(rubrica.getContatti().isEmpty());
    }
    
    /**
     * Test del costruttore con validatore nullo. Dati non validi.
     */
    @Test
    void testCostruttoreConValidatoreNull() {
        assertThrows(IllegalArgumentException.class, () -> { new Rubrica(null); });
    }
    
    /**
     * Test del metodo creaContatto con input valido. CE2.
     */
    @Test
    void testCreaContattoValido() {
        Contatto c1 = new Contatto("Mario", "Rossi", "1234567890", "", "", "a@example.com", "", "");
        assertTrue(rubrica.creaContatto(c1));
        assertEquals(1, rubrica.getContatti().size());
        assertTrue(rubrica.getContatti().containsValue(c1));
    }
    
    /**
     * Test del metodo creaContatto con input invalido. CE3.
     */
    @Test
    void testCreaContattoInvalido() {
        Contatto c1 = new Contatto("Mario", "Rossi", "1", "", "", "a", "", "");
        assertFalse(rubrica.creaContatto(c1));
        assertEquals(0, rubrica.getContatti().size());
        assertFalse(rubrica.getContatti().containsValue(c1));
    }
    
    /**
     * Test del metodo creaContatto con contatto nullo. Dati non validi.
     */
    @Test
    void testCreaContattoNull() {
        assertThrows(IllegalArgumentException.class, () -> { rubrica.creaContatto(null); });
    }
    
    /**
     * Test del metodo rimuoviContatto con contatto esistente. CE4.
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
     * Test del metodo rimuoviContatto con contatto non esistente. CE5.
     */
    @Test
    void testRimuoviContattoNonEsistente() {
        Contatto c1 = new Contatto("Mario", "Rossi", "1234567890", "1234567890", "1234567890", "a@example.com", "b@example.com", "c@example.com");
        rubrica.rimuoviContatto(c1);
        assertFalse(rubrica.getContatti().containsValue(c1));
    }

    /**
     * Test del metodo rimuoviContatto con contatto nullo. Dati non validi.
     */
    @Test
    void testRimuoviContattoNull() {
        assertThrows(IllegalArgumentException.class, () -> { rubrica.rimuoviContatto(null); });
    }
    
    /**
     * Test del metodo modificaContatto con contatto valido e chiave esistente. CE6 e CE8.
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

    /**
     * Test del metodo modificaContatto con contatto valido e chiave non esistente. CE6 e CE9.
     */
    @Test
    void testModificaContattoNonEsistente() {
        Contatto c1 = new Contatto("Mario", "Rossi", "1234567890", "", "", "a@example.com", "b@example.com", "c@example.com");
        Persona k1 = (Persona) c1;
        Contatto c1Modificato = new Contatto("Mario", "Rossi", "1234567890", "", "", "x@example.com", "y@example.com", "z@example.com");
        assertFalse(rubrica.modificaContatto(c1Modificato, k1));
        assertFalse(rubrica.getContatti().containsValue(c1Modificato));
    }
    
    /**
     * Test del metodo modificaContatto con contatto invalido e chiave esistente. CE7 e CE8.
     * Modifica invalida di numeroTelefono.
     */
    @Test
    void testModificaInvalidaContattoEsistente() {
        Contatto c1 = new Contatto("Mario", "Rossi", "1234567890", "1234567890", "1234567890", "a@example.com", "b@example.com", "c@example.com");
        Persona k1 = (Persona) c1;
        rubrica.creaContatto(c1);
        Contatto c1Modificato = new Contatto("Mario", "Rossi", "1", "2", "3", "a@example.com", "b@example.com", "c@example.com");
        assertFalse(rubrica.modificaContatto(c1Modificato, k1));
        assertFalse(rubrica.getContatti().containsValue(c1Modificato));
        assertTrue(rubrica.getContatti().containsValue(c1));
    }
    
    /**
     * Test del metodo modificaContatto con contatto invalido e chiave non esistente. CE7 e CE9.
     * Modifica invalida di e-mail.
     */
    @Test
    void testModificaInvalidaContattoNonEsistente() {
        Contatto c1 = new Contatto("Mario", "Rossi", "1234567890", "1234567890", "1234567890", "a@example.com", "b@example.com", "c@example.com");
        Persona k1 = (Persona) c1;
        Contatto c1Modificato = new Contatto("Mario", "Rossi", "1234567890", "1234567890", "1234567890", "a", "b", "c");
        assertFalse(rubrica.modificaContatto(c1Modificato, k1));
        assertFalse(rubrica.getContatti().containsValue(c1Modificato));
    }
    
    /**
     * Test del metodo modificaContatto con contatto nullo e chiave non nulla. Dati non validi.
     */
    @Test
    void testModificaContattoNull() {
        Persona k1 = new Persona("Mario", "Rossi");
        assertThrows(IllegalArgumentException.class, () -> { rubrica.modificaContatto(null, k1); });
    }
    
    /**
     * Test del metodo modificaContatto con contatto non nullo e chiave nulla. Dati non validi.
     */
    @Test
    void testModificaChiaveNull() {
        Contatto c1 = new Contatto("Mario", "Rossi", "1234567890", "1234567890", "1234567890", "a@example.com", "b@example.com", "c@example.com");
        assertThrows(IllegalArgumentException.class, () -> { rubrica.modificaContatto(c1, null); });
    }
    
    /**
     * Test del metodo modificaContatto con contatto nullo e chiave nulla. Dati non validi.
     */
    @Test
    void testModificaContattoeChiaveNull() {
        assertThrows(IllegalArgumentException.class, () -> { rubrica.modificaContatto(null, null); });
    }

    /**
     * Test del metodo cercaContatto con stringa vuota. CE10.
     */
    @Test
    void testCercaContattoVuota() {
        Contatto c1 = new Contatto("Mario", "Rossi", "1234567890", "1234567890", "1234567890", "a@example.com", "b@example.com", "c@example.com");
        Contatto c2 = new Contatto("Luigi", "Bianchi", "1234567890", "1234567890", "1234567890", "x@example.com", "y@example.com", "z@example.com");
        rubrica.creaContatto(c1);
        rubrica.creaContatto(c2);
        Map<Persona, Contatto> risultati = rubrica.cercaContatto("");
        assertEquals(2, risultati.size());
        assertTrue(risultati.containsValue(c1));
        assertTrue(risultati.containsValue(c2));
    }

    /**
     * Test del metodo cercaContatto con stringa non vuota. CE11.
     */
    @Test
    void testCercaContattoNonVuota() {
        Contatto c1 = new Contatto("Mario", "Rossi", "1234567890", "1234567890", "1234567890", "a@example.com", "b@example.com", "c@example.com");
        rubrica.creaContatto(c1);
        Map<Persona, Contatto> risultati = rubrica.cercaContatto("mar");
        assertEquals(1, risultati.size());
        assertTrue(risultati.containsValue(c1));
    }

    /**
     * Test del metodo cercaContatto con stringa nulla. Dati non validi.
     */
    @Test
    void testCercaContattoStringaNull() {
        assertThrows(IllegalArgumentException.class, () -> { rubrica.cercaContatto(null); });
    }
}
