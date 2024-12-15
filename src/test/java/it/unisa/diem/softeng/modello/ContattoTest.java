package it.unisa.diem.softeng.modello;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 *
 * @author mashalem
 */

/**
 * @brief Le classi di equivalenza per i metodi di test verranno raggruppate secondo i seguenti criteri.
 *
 * Costruttore Contatto(String nome, String cognome, String numeroTelefono1, String numeroTelefono2, String numeroTelefono3, String email1, String email2, String email3)
 * 
 * Per quanto concerne i parametri del costruttore 'nome' e 'cognome', la suddivisione in classi di equivalenza non viene effettuata poichè risulterebbe ridondante rispetto alla classe PersonaTest.
 *
 * NumeroTelefono1:
 * - CE1: NumeroTelefono1 non vuoto (stringa non vuota)
 * - CE2: NumeroTelefono1 vuoto (stringa vuota "")
 * Dati non validi: NumeroTelefono1 nullo (null)
 *
 * NumeroTelefono2:
 * - CE3: NumeroTelefono2 non vuoto (stringa non vuota)
 * - CE4: NumeroTelefono2 vuoto (stringa vuota "")
 * Dati non validi: NumeroTelefono2 nullo (null)
 *
 * NumeroTelefono3:
 * - CE5: NumeroTelefono3 non vuoto (stringa non vuota)
 * - CE6: NumeroTelefono3 vuoto (stringa vuota "")
 * Dati non validi: NumeroTelefono3 nullo (null)
 *
 * Email1:
 * - CE7: Email1 non vuoto (stringa non vuota)
 * - CE8: Email1 vuoto (stringa vuota "")
 * Dati non validi: Email1 nullo (null)
 *
 * Email2:
 * - CE9: Email2 non vuoto (stringa non vuota)
 * - CE10: Email2 vuoto (stringa vuota "")
 * Dati non validi: Email2 nullo (null)
 *
 * Email3:
 * - CE11: Email3 non vuoto (stringa non vuota)
 * - CE12: Email3 vuoto (stringa vuota "")
 * Dati non validi: Email3 nullo (null)
 *
 * Metodo equals
 * - CE13: obj uguale all'istanza corrente di Contatto.
 * - CE14: obj diverso dall'istanza corrente di Contatto.
 *
 * Boundary Conditions:
 * - BC1: Almeno un NumeroTelefono con una sola cifra
 * - BC2: Almeno una Email con un solo carattere
 */
public class ContattoTest {

    /**
     * Test del metodo di creazione con input validi. CE1, CE3, CE5, CE7, CE9, CE11.
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
     * Test del metodo di creazione con input validi. CE1, CE3, CE6, CE7, CE10, CE11.
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
     * Test del metodo di creazione con input validi. CE2, CE4, CE5, CE8, CE9, CE12.
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
     * Test del metodo di creazione con stringhe vuote come input. CE2, CE4, CE6, CE8, CE10, CE12.
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
     * Test del metodo di creazione con valori null. Dati non validi.
     */
    @Test
    void testCreazioneInvalidaConNull() {
        assertThrows(IllegalArgumentException.class, () -> { new Contatto("Mario", "Rossi", "123", null, "789", "a@example.com", "b@example.com", "c@example.com"); });
        assertThrows(IllegalArgumentException.class, () -> { new Contatto("Mario", "Rossi", "123", "456", "789", "a@example.com", null, "c@example.com"); });
    }

    /**
     * Test del metodo equals per oggetti uguali. CE13.
     */
    @Test
    void testEqualsOggettiUguali() {
        Contatto c1 = new Contatto("Mario", "Rossi", "123", "456", "789", "a@example.com", "b@example.com", "c@example.com");
        Contatto c2 = new Contatto("Mario", "Rossi", "123", "456", "789", "a@example.com", "b@example.com", "c@example.com");
        assertEquals(c1, c2);
    }

    /**
     * Test del metodo equals per oggetti diversi. CE14.
     */
    @Test
    void testEqualsOggettiDiversi() {
        Contatto c1 = new Contatto("Mario", "Rossi", "123", "456", "789", "a@example.com", "b@example.com", "c@example.com");
        Contatto c2 = new Contatto("Luigi", "Bianchi", "321", "654", "987", "x@example.com", "y@example.com", "z@example.com");
        assertNotEquals(c1, c2);
    }

    /**
     * Test dei limiti per numeri di telefono. CE1, CE3, CE5, CE7, CE9, CE11.
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
     * Test dei limiti per email. CE1, CE3, CE5, CE7, CE9, CE11.
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
     * Test per valori minimi accettabili. BC1, BC2.
     */
    @Test
    void testBoundaryMinimi() {
        Contatto c1 = new Contatto("Mario", "Rossi", "1", "2", "3", "@", "@", "@");
        assertEquals(Arrays.asList("1", "2", "3"), c1.getNumeriTelefono());
        assertEquals(Arrays.asList("@", "@", "@"), c1.getEmail());
    }

}