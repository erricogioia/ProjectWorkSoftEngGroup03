package it.unisa.diem.softeng.servizio;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import it.unisa.diem.softeng.modello.Contatto;
import org.junit.jupiter.api.BeforeEach;

/**
 * @brief Le classi di equivalenza per i metodi di test verranno raggruppate secondo i seguenti criteri.
 *
 * Metodo valida(Contatto contatto)
 * contatto:
 * - CE1: contatto valido: almeno uno tra nome e cognome non vuoto e numeroTelefono/e-mail che soddisfano i criteri di validità
 * - CE2: contatto non valido
 * Dati non validi: contatto nullo (null)
 *
 * Boundary Conditions:
 * - BC1: Numero di cifre del telefono superiore di uno rispetto al formato valido
 * - BC2: Numero di cifre del telefono inferiore di uno rispetto al formato valido
 * - BC3: E-mail che non rispetta per un parametro il pattern di validità
 */
public class ValidaContattoTest {

    private InterfacciaValidaContatto validatore;

    @BeforeEach
    void setUp() {
        validatore = new ValidaContatto();
    }

    /**
     * Test del metodo valida con nome presente e cognome vuoto. CE1.
     */
    @Test
    void testNomePresenteCognomeVuoto() {
        Contatto c1 = new Contatto("Mario", "", "", "", "", "", "", "");
        assertTrue(validatore.valida(c1));
    }

    /**
     * Test del metodo valida con cognome presente e nome vuoto. CE1.
     */
    @Test
    void testCognomePresenteNomeVuoto() {
        Contatto c1 = new Contatto("", "Rossi", "", "", "", "", "", "");
        assertTrue(validatore.valida(c1));
    }

    /**
     * Test del metodo valida con nome e cognome entrambi presenti. CE1.
     */
    @Test
    void testEntrambiPresenti() {
        Contatto c1 = new Contatto("Mario", "Rossi", "", "", "", "", "", "");
        assertTrue(validatore.valida(c1));
    }

    /**
     * Test del metodo valida con nome e cognome entrambi vuoti. CE2.
     */
    @Test
    void testNomeECognomeVuoti() {
        Contatto c1 = new Contatto("", "", "", "", "", "", "", "");
        assertFalse(validatore.valida(c1));
    }

    /**
     * Test del metodo valida con numero di telefono valido. CE1.
     */
    @Test
    void testNumeroTelefonoValido() {
        Contatto c1 = new Contatto("Mario", "Rossi", "1234567890", "", "", "a@example.com", "", "");
        assertTrue(validatore.valida(c1));
    }

    /**
     * Test del metodo valida con numero di telefono troppo corto. BC2.
     */
    @Test
    void testNumeroTelefonoTroppoCorto() {
        Contatto c1 = new Contatto("Mario", "Rossi", "123456789", "", "", "a@example.com", "", "");
        assertFalse(validatore.valida(c1));
    }

    /**
     * Test del metodo valida con numero di telefono troppo lungo. BC1.
     */
    @Test
    void testNumeroTelefonoTroppoLungo() {
        Contatto c1 = new Contatto("Mario", "Rossi", "12345678901", "", "", "a@example.com", "", "");
        assertFalse(validatore.valida(c1));
    }

    /**
     * Test del metodo valida con numero di telefono non numerico. CE2.
     */
    @Test
    void testNumeroTelefonoNonNumerico() {
        Contatto c1 = new Contatto("Mario", "Rossi", "12345abcd0", "", "", "a@example.com", "", "");
        assertFalse(validatore.valida(c1));
    }

    /**
     * Test del metodo valida con email assente. CE1.
     */
    @Test
    void testEmailAssente() {
        Contatto c1 = new Contatto("Mario", "Rossi", "1234567890", "", "", "", "", "");
        assertTrue(validatore.valida(c1));
    }

    /**
     * Test del metodo valida con email valida. CE1.
     */
    @Test
    void testEmailValida() {
        Contatto c1 = new Contatto("Mario", "Rossi", "", "", "", "a@example.com", "", "");
        assertTrue(validatore.valida(c1));
    }

    /**
     * Test del metodo valida con email in formato non valido (senza dominio completo). BC3.
     */
    @Test
    void testEmailFormatoNonValido1() {
        Contatto c1 = new Contatto("Mario", "Rossi", "1234567890", "", "", "a@example", "", "");
        assertFalse(validatore.valida(c1));
    }

    /**
     * Test del metodo valida con email in formato non valido (dominio incompleto). BC3.
     */
    @Test
    void testEmailFormatoNonValido2() {
        Contatto c1 = new Contatto("Mario", "Rossi", "1234567890", "", "", "a@.com", "", "");
        assertFalse(validatore.valida(c1));
    }

    /**
     * Test del metodo valida con email in formato non valido (manca il nome utente). BC3.
     */
    @Test
    void testEmailFormatoNonValido3() {
        Contatto c1 = new Contatto("Mario", "Rossi", "1234567890", "", "", "@example.com", "", "");
        assertFalse(validatore.valida(c1));
    }

    /**
     * Test del metodo valida con email in formato minimo valido. CE1.
     */
    @Test
    void testEmailFormatoMinimoValido() {
        Contatto c1 = new Contatto("Mario", "Rossi", "1234567890", "", "", "a@b.c", "", "");
        assertTrue(validatore.valida(c1));
    }

    /**
     * Test del metodo valida con numero di telefono e email entrambi non validi. CE2.
     */
    @Test
    void testNumeroTelefonoEEmailNonValidi() {
        Contatto c1 = new Contatto("Mario", "Rossi", "12345abcd0", "", "", "a@example", "", "");
        assertFalse(validatore.valida(c1));
    }
    
    /**
     * Test del metodo valida con contatto null. Dati non validi.
     */
    @Test
    void testContattoNull() {
        assertThrows(IllegalArgumentException.class, () -> { validatore.valida(null); });
    }
}
