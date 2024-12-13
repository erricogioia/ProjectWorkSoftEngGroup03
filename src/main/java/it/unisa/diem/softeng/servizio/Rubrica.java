package it.unisa.diem.softeng.servizio;

import it.unisa.diem.softeng.modello.Contatto;
import it.unisa.diem.softeng.modello.Persona;
import java.util.Map;

/**
 * @brief  La classe Rubrica offre una gestione completa di una Map osservabile di contatti.
 * 
 * Permette di aggiungere, modificare, rimuovere e cercare contatti, garantendo sempre la validità dei dati tramite l'uso di un validatore.
 * 
 * @see it.unisa.diem.softeng.modello::Contatto
 * @see InterfacciaValidaContatto
 * @invariant La rubrica non deve contenere duplicati di contatti o contatti null.
 */
public class Rubrica implements InterfacciaRubrica{
    private Map<String, Contatto> contatti;
    private InterfacciaValidaContatto valida;

    /**
     * @brief Costruttore per inizializzare la rubrica.
     * 
     * La rubrica viene inizializzata vuota e pronta all'uso, con un validatore per i contatti.
     * 
     * @param[in] valida L'istanza del validatore da utilizzare per validare i contatti.
     * @pre valida non è null.
     * @post La rubrica è inizializzata ed è vuota.
     */
    public Rubrica(InterfacciaValidaContatto valida) {
        
    }

    /**
     * @brief Restituisce i contatti nella rubrica.
     * @post Nessuna modifica viene apportata alla rubrica.
     * @return Una Map dei contatti.
    */
    public Map<Persona, Contatto> getContatti() {
        return null;
    }
    
    /**
     * @copydoc InterfacciaRubrica::creaContatto
    */
    @Override
    public boolean creaContatto(Contatto contatto) {
       return true;
    }
    
    /**
     * @copydoc InterfacciaRubrica::rimuoviContatto
    */
    @Override
    public void rimuoviContatto(Contatto contatto) {
        
    }
   
    /**
     * @copydoc InterfacciaRubrica::modificaContatto
    */
    @Override
    public boolean modificaContatto(Contatto contatto, Persona key) {
        return true;
    }
    
    /**
      * @copydoc InterfacciaRubrica::cercaContatto
    */
    @Override
    public Map<Persona,Contatto> cercaContatto(String str) {
        return null;
    }
    
}
