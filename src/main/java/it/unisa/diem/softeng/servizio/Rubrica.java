package it.unisa.diem.softeng.servizio;

import it.unisa.diem.softeng.modello.Contatto;
import it.unisa.diem.softeng.modello.Persona;
import java.util.Map;
import java.util.TreeMap;

/**
 * @brief  La classe Rubrica offre una gestione completa di una Map osservabile di contatti.
 * 
 * Permette di aggiungere, modificare, rimuovere e cercare contatti, garantendo sempre la validità dei dati tramite l'uso di un validatore.
 * 
 * @see it.unisa.diem.softeng.modello::Contatto
 * @see InterfacciaValidaContatto
 * @invariant La rubrica non deve contenere duplicati di contatti o contatti null.
 * @invariant Il validatore non deve essere null.
 */
public class Rubrica implements InterfacciaRubrica{
    private Map<Persona, Contatto> contatti;
    private InterfacciaValidaContatto valida;

    /**
     * @brief Costruttore per inizializzare la rubrica.
     * 
     * La rubrica viene inizializzata vuota e pronta all'uso, con un validatore per i contatti.
     * 
     * @param[in] valida L'istanza del validatore da utilizzare per validare i contatti.
     * @post La rubrica è inizializzata ed è vuota.
     */
    public Rubrica(InterfacciaValidaContatto valida) {
        this.contatti = new TreeMap<>();
        
        if(valida == null)
            throw new IllegalArgumentException("Validatore Contatto uguale a 'null'");
        
        this.valida = valida;
    }

    /**
     * @copydoc InterfacciaRubrica::getContatti
    */
    public Map<Persona, Contatto> getContatti() {
        return this.contatti;
    }
    
    /**
     * @copydoc InterfacciaRubrica::creaContatto
    */
    @Override
    public boolean creaContatto(Contatto contatto) {
       boolean contattoValido = this.controlloContatto(contatto);
                
        if(contattoValido){
            Contatto c = this.contatti.putIfAbsent((Persona)contatto, contatto);
            if(c != null)
                return false;
        }
         
        return contattoValido;
    }
    
    /**
     * @copydoc InterfacciaRubrica::rimuoviContatto
    */
    @Override
    public void rimuoviContatto(Contatto contatto) {
        if(contatto == null)
            throw new IllegalArgumentException("Contatto uguale a 'null'");
        
        this.contatti.remove((Persona)contatto);
    }
   
    /**
     * @copydoc InterfacciaRubrica::modificaContatto
    */
    @Override
    public boolean modificaContatto(Contatto contatto, Persona key) {
        boolean contattoValido = this.controlloContatto(contatto);
        
        if(this.contatti.containsKey((Persona)contatto) && this.contatti.containsValue(contatto))
            return false;                  
        
        if(contattoValido && this.contatti.containsKey(key)) {
            this.contatti.remove(key);
            this.contatti.put((Persona)contatto, contatto);
        } else 
            return false;
        
        return contattoValido;
    }
    
    /**
      * @copydoc InterfacciaRubrica::cercaContatto
    */
    @Override
    public Map<Persona,Contatto> cercaContatto(String str) {
        return null;
    }
    
    private boolean controlloContatto(Contatto contatto) {
        if(contatto == null)
            throw new IllegalArgumentException("Contatto uguale a 'null'");
        
        return this.valida.valida(contatto);
    }
    
}
