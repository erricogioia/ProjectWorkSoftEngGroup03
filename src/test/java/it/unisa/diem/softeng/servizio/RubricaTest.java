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
    
}
