package it.unisa.diem.softeng.modello;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author antoniopiodamico
 */

/**
 * @brief Le classi di equivalenza per i metodi di test verranno raggruppate secondo i seguenti criteri.
 *
 * Costruttore Persona(String nome, String cognome)
 * Nome:
 * - CE1: Nome non vuoto (stringa non vuota)
 * - CE2: Nome vuoto (stringa vuota "")
 * Dati non validi: Nome nullo (null)
 * Cognome:
 * - CE3: Cognome non vuoto (stringa non vuota)
 * - CE4: Cognome vuoto (stringa vuota "")
 * Dati non validi: Cognome nullo (null)
 *
 * Metodo equals
 * - CE5: obj uguale all'istanza corrente di Persona.
 * - CE6: obj diverso dall'istanza corrente di Persona.
 *
 * Metodo compareTo
 * - CE7: other minore dell'istanza corrente di Persona
 * - CE8: other maggiore dell'istanza corrente di Persona
 * - CE9: other uguale all'istanza corrente di Persona
 * Dati non validi: other nullo (null)
 *
 * Boundary Conditions:
 * - CE10: Nome con un solo carattere
 * - CE11: Cognome con un solo carattere
 */
public class PersonaTest {

    /**
     * Test per nome e cognome non vuoti. CE1 e CE3.
     */
    @Test
    public void testCreazioneOggettoConNomeECognome() {
        Persona p1 = new Persona("Mario", "Rossi");
        assertEquals("Mario", p1.getNome());
        assertEquals("Rossi", p1.getCognome());
    }

    /**
     * Test per nome vuoto. CE2 e CE3.
     */
    @Test
    public void testCreazioneOggettoConNomeVuoto() {
        Persona p1 = new Persona("", "Rossi");
        assertEquals("", p1.getNome());
        assertEquals("Rossi", p1.getCognome());
    }

    /**
     * Test per cognome vuoto. CE1 e CE4.
     */
    @Test
    public void testCreazioneOggettoConCognomeVuoto() {
        Persona p1 = new Persona("Mario", "");
        assertEquals("Mario", p1.getNome());
        assertEquals("", p1.getCognome());
    }

    /**
     * Test per nome null. Dato non valido.
     */
    @Test
    public void testCreazioneOggettoConNomeNull() {
        assertThrows(IllegalArgumentException.class, () -> new Persona(null, "Rossi"));
    }

    /**
     * Test per cognome null. Dato non valido.
     */
    @Test
    public void testCreazioneOggettoConCognomeNull() {
        assertThrows(IllegalArgumentException.class, () -> new Persona("Mario", null));
    }

    /**
     * Test per entrambi null. Dato non valido.
     */
    @Test
    public void testCreazioneOggettoConEntrambiNull() {
        assertThrows(IllegalArgumentException.class, () -> new Persona(null, null));
    }

    /**
     * Test per entrambi vuoti. CE2 e CE4.
     */
    @Test
    public void testCreazioneOggettoConEntrambiVuoti() {
        Persona p1 = new Persona("", "");
        assertEquals("", p1.getNome());
        assertEquals("", p1.getCognome());
    }

    /**
     * Test del metodo equals per oggetti uguali. CE5.
     */
    @Test
    public void testEqualsOggettiUguali() {
        Persona p1 = new Persona("Mario", "Rossi");
        Persona p2 = new Persona("Mario", "Rossi");
        assertTrue(p1.equals(p2));
    }

    /**
     * Test del metodo equals per oggetti diversi. CE6.
     */
    @Test
    public void testEqualsOggettiDiversi() {
        Persona p1 = new Persona("Mario", "Rossi");
        Persona p2 = new Persona("Luigi", "Verdi");
        assertFalse(p1.equals(p2));
    }

    /**
     * Test del metodo compareTo per oggetti uguali. CE9.
     */
    @Test
    public void testCompareToOggettiUguali() {
        Persona p1 = new Persona("Mario", "Rossi");
        Persona p2 = new Persona("Mario", "Rossi");
        assertEquals(0, p1.compareTo(p2));
    }

    /**
     * Test del metodo compareTo per ordine alfabetico del cognome. CE8.
     */
    @Test
    public void testCompareToPerCognome() {
        Persona p1 = new Persona("Mario", "Rossi");
        Persona p2 = new Persona("Luigi", "Verdi");
        assertTrue(p1.compareTo(p2) < 0);
    }

    /**
     * Test del metodo compareTo per ordine alfabetico del nome. CE7.
     */
    @Test
    public void testCompareToPerNome() {
        Persona p1 = new Persona("Mario", "Rossi");
        Persona p2 = new Persona("Anna", "Rossi");
        assertTrue(p2.compareTo(p1) < 0);
    }
    
    /**
     * Test del metodo compareTo con parametro null. Dato non valido.
     */
    @Test
    public void testCompareToNull() {
        Persona p1 = new Persona("Mario", "Rossi");
        assertThrows(NullPointerException.class, () -> p1.compareTo(null));
    }
    
    /**
     * Test per nome di un carattere e cognome normale. CE10.
     */
    @Test
    public void testBoundaryNomeUnCarattereCognomeNormale() {
        Persona p1 = new Persona("M", "Rossi");
        assertEquals("M", p1.getNome());
        assertEquals("Rossi", p1.getCognome());
    }

    /**
     * Test per nome normale e cognome di un carattere. CE11.
     */
    @Test
    public void testBoundaryNomeNormaleCognomeUnCarattere() {
        Persona p1 = new Persona("Mario", "R");
        assertEquals("Mario", p1.getNome());
        assertEquals("R", p1.getCognome());
    }
    
    /**
     * Test per nome e cognome di un carattere. CE10 e CE11.
     */
    @Test
    public void testBoundaryNomeCognomeUnCarattere() {
        Persona p1 = new Persona("M", "R");
        assertEquals("M", p1.getNome());
        assertEquals("R", p1.getCognome());
    }

    /**
     * Test per nome lungo e cognome normale. CE1 e CE3.
     */
    @Test
    public void testBoundaryNomeLungoCognomeNormale() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 1000; i++) 
            sb.append("A");

        String longName = sb.toString();
        Persona p1 = new Persona(longName, "Rossi");
        assertEquals(longName, p1.getNome());
        assertEquals("Rossi", p1.getCognome());
    }

    /**
     * Test per nome normale e cognome lungo. CE1 e CE3.
     */
    @Test
    public void testBoundaryNomeNormaleCognomeLungo() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 1000; i++) 
            sb.append("B");

        String longSurname = sb.toString();
        Persona p1 = new Persona("Mario", longSurname);
        assertEquals("Mario", p1.getNome());
        assertEquals(longSurname, p1.getCognome());
    }
    
}