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
    
}
