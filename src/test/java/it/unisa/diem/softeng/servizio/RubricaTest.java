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
    
}
