package it.unisa.diem.softeng.integrazione;

import static org.junit.jupiter.api.Assertions.*;
import it.unisa.diem.softeng.modello.*;
import it.unisa.diem.softeng.servizio.*;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * Classe di test integrato per la gestione della Rubrica.
 */
public class IntegrazioneTest {

    @Test
    public void integrazioneTest() {
        // Creazione del validatore
        ValidaContatto valida = new ValidaContatto();

        // Creazione della rubrica
        Rubrica rubrica = new Rubrica(valida);

        // Creazione dei contatti validi
        Contatto contatto1 = new Contatto("Mario", "Rossi", "1234567890", "", "", "mario.rossi@example.com", "", "");
        Contatto contatto2 = new Contatto("Luigi", "Verdi", "0987654321", "", "", "luigi.verdi@example.com", "", "");

        // Creazione di un contatto non valido
        Contatto contattoNonValido = new Contatto("", "", "12345", "", "", "emailerrata", "", "");

        // Test validazione contatti
        assertTrue(valida.valida(contatto1));
        assertTrue(valida.valida(contatto2));
        assertFalse(valida.valida(contattoNonValido));

        // Aggiunta dei contatti
        assertTrue(rubrica.creaContatto(contatto1));
        assertTrue(rubrica.creaContatto(contatto2));

        // Tentativo di aggiungere un contatto duplicato
        assertFalse(rubrica.creaContatto(contatto1));

        // Tentativo di aggiungere un contatto non valido
        assertFalse(rubrica.creaContatto(contattoNonValido));

        // Ricerca di contatti esistenti
        Map<Persona, Contatto> risultatiRicerca = rubrica.cercaContatto("Mario");
        assertEquals(1, risultatiRicerca.size());
        assertTrue(risultatiRicerca.containsKey((Persona)contatto1));
    }
}