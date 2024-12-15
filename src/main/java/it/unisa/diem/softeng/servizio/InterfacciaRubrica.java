package it.unisa.diem.softeng.servizio;

import it.unisa.diem.softeng.modello.Contatto;
import it.unisa.diem.softeng.modello.Persona;
import java.util.Map;

/**
 * @brief Interfaccia per la gestione della rubrica.
 * 
 * Questa interfaccia definisce i metodi fondamentali per creare, modificare, rimuovere e cercare contatti in una rubrica.
 * 
 * @see it.unisa.diem.softeng.modello::Contatto
*/
public interface InterfacciaRubrica {
    
    /**
     * @brief Restituisce i contatti nella rubrica.
     * @post Nessuna modifica viene apportata alla rubrica.
     * @return Una Map dei contatti.
    */
    Map<Persona, Contatto> getContatti();

    /**
     * @brief Aggiunge alla rubrica il contatto passatogli, qualora esso risulti valido.
     * @param[in] contatto Il contatto da aggiungere.
     * @pre Il contatto non è null.
     * @post La rubrica contiene un nuovo contatto se il metodo restituisce true e la dimensione della rubrica viene incrementata di uno.
     * @post La rubrica rimane invariata se il metodo restituisce false.
     * @return true se l'aggiunta ha avuto successo, false altrimenti.
     * @see InterfacciaValidaContatto
    */
    boolean creaContatto(Contatto contatto);

    /**
     * @brief Rimuove dalla rubrica il contatto passatogli.
     * @param[in] contatto Il contatto da rimuovere.
     * @pre Il contatto non è null.
     * @post La rubrica non contiene più il contatto e la dimensione della rubrica viene decrementata di uno, se il contatto esiste in rubrica.
     * @post La rubrica rimane invariata se il cotatto non esiste in rubrica.
    */
    void rimuoviContatto(Contatto contatto);

    /**
     * @brief Modifica un contatto esistente nella rubrica, qualora la modifica risulti valida.
     * @param[in] contatto Il contatto già modificato da aggiungere in rubrica.
     * @param[in] key La chiave del contatto precedente da sostituire.
     * @pre Il contatto non è null.
     * @post Il contatto esistente nella rubrica viene sostituito dal contatto modificato se il metodo restituisce true. 
     * @post La rubrica rimane invariata se il metodo restituisce false. 
     * @return true se la modifica ha avuto successo, false altrimenti.
     * @see InterfacciaValidaContatto
    */
    boolean modificaContatto(Contatto contatto, Persona key);

    /**
     * @brief Cerca un contatto nella rubrica.
     * @param[in] str La sottostringa da ricercare nella rubrica.
     * @pre La stringa non è null.
     * @post La rubrica non viene modificata durante la ricerca.
     * @return Una Map di contatti che corrispondono al criterio di ricerca.
     */
    Map<Persona,Contatto> cercaContatto(String str);
    
}
