package it.unisa.diem.softeng.modello;

/**
 * @brief Rappresenta una persona con nome e cognome. 
 * 
 * Questa classe viene utilizzata come chiave per la Map di Rubrica per evitare contatti duplicati secondo equals.
 * 
 * @see Contatto
 * @invariant La persona deve avere almeno un nome o un cognome valido.
 */
public class Persona implements Comparable<Persona> {
    
    private String nome;
    private String cognome;

    
    /**
     * @brief Costruttore della classe Persona.
     * 
     * Qualora venisse inserito solo uno dei due parametri, l'altro conterrà una stringa vuota.
     * 
     * @param[in] nome Il nome della Persona.
     * @param[in] cognome Il cognome della Persona.
     */
    public Persona(String nome, String cognome) {

    }

    /**
     * @brief Ottiene il nome della persona.
     * @return Il nome della persona.
     */
    public String getNome() {
        return null;
    }
    
    /**
     * @brief Ottiene il cognome della persona.
     * @return Il cognome della persona.
    */
    public String getCognome() {
        return null;
    }

    /**
     * @brief Imposta un nuovo nome per la persona.
     * @param[in] nome Il nuovo nome della persona.
     * @post Il campo nome è aggiornato con il nuovo valore.
     */
    public void setNome(String nome) {
        
    }

    /**
     * @brief Imposta un nuovo cognome per la persona.
     * @param[in] cognome Il nuovo cognome della persona.
     * @post Il campo cognome è aggiornato con il nuovo valore.
     */
    public void setCognome(String cognome) {
        
    }

    /**
     * @brief Confronta questa persona con un altro oggetto.
     * 
     * Il confronto avviene contemporaneamente secondo il nome e il cognome.
     *
     * @param[in] obj L'oggetto con cui effettuare il confronto.
     * @return true se gli oggetti sono uguali, altrimenti false.
    */
    @Override
    public boolean equals(Object obj) {
        return true;
    }

    /**
     * @brief Compara questa persona con un'altra.
     * 
     * Il confronto avviene, in ordine alfabetico, primariamente secondo il cognome e successivamente tramite il nome, rimanendo coerenti con equals.
     * 
     * @see equals()
     * 
     * @param[in] other La persona con cui effettuare il confronto.
     * @return Un valore negativo, zero o positivo se questa persona è rispettivamente minore, uguale o maggiore, secondo il criterio summenzionato.
    */
    @Override
    public int compareTo(Persona other) {
        return 0;
    }
    
    /**
     * @brief Rappresentazione testuale della persona.
     * @return La rappresentazione testuale.
    */
    @Override
    public String toString() {
        return null;  
    }
    
}

