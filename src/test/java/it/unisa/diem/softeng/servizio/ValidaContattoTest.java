package it.unisa.diem.softeng.servizio;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import it.unisa.diem.softeng.modello.Contatto;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author raffaele
 */
public class ValidaContattoTest {
    
    private InterfacciaValidaContatto validatore;
    
    @BeforeEach
    void setUp() {
        validatore = new ValidaContatto();
    }
    
    /**
     * Test del metodo valida con nome presente e cognome vuoto.
     */
    @Test
    void testNomePresenteCognomeVuoto() {
        Contatto c1 = new Contatto("Mario", "", "", "", "", "", "", "");
        assertTrue(validatore.valida(c1));
    }
    
    /**
     * Test del metodo valida con cognome presente e nome vuoto.
     */
    @Test
    void testCognomePresenteNomeVuoto() {
        Contatto c1 = new Contatto("", "Rossi", "", "", "", "", "", "");
        assertTrue(validatore.valida(c1));
    }
    
    /**
     * Test del metodo valida con nome e cognome entrambi presenti.
     */
    @Test
    void testEntrambiPresenti() {
        Contatto c1 = new Contatto("Mario", "Rossi", "", "", "", "", "", "");
        assertTrue(validatore.valida(c1));
    }
    
    /**
     * Test del metodo valida con nome e cognome entrambi vuoti.
     */
    @Test
    void testNomeECognomeVuoti() {
        Contatto c1 = new Contatto("", "", "", "", "", "", "", "");
        assertFalse(validatore.valida(c1));
    }
    
}
