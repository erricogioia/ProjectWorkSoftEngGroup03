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
        
        // Ricerca di un contatto inesistente
        risultatiRicerca = rubrica.cercaContatto("Pippo");
        assertTrue(risultatiRicerca.isEmpty());

        // Modifica di un contatto esistente
        Contatto contattoModificato = new Contatto("Mario", "Rossi", "1111111111", "", "", "mario.rossi@newmail.com", "", "");
        assertTrue(rubrica.modificaContatto(contattoModificato, (Persona)contatto1));

        // Controllo della modifica
        risultatiRicerca = rubrica.cercaContatto("Mario");
        assertEquals(1, risultatiRicerca.size());
        Contatto contattoMod = risultatiRicerca.get((Persona)contattoModificato);
        assertNotNull(contattoMod);
        assertEquals("1111111111", contattoMod.getNumeriTelefono().get(0));

        // Rimozione di un contatto
        rubrica.rimuoviContatto(contatto2);
        risultatiRicerca = rubrica.cercaContatto("Luigi");
        assertTrue(risultatiRicerca.isEmpty());

        // Verifica sulla rubrica finale 
        Map<Persona, Contatto> contattiFinali = rubrica.getContatti();
        assertEquals(1, contattiFinali.size());
    }
}