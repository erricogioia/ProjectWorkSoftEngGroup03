package it.unisa.diem.softeng.modello;

/**
 * @brief Rappresenta una persona con nome e cognome. 
 * 
 * Questa classe viene utilizzata come chiave per la Map di Rubrica per evitare contatti duplicati secondo equals.
 * 
 * @see Contatto
 * @invariant La persona deve avere nome e cognome non null.
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
        
        if (nome == null || cognome == null)
            throw new IllegalArgumentException("Almeno uno tra i campi 'Nome' o 'Cognome' è null");
        
        this.nome = nome;
        this.cognome = cognome;
        
    }

    /**
     * @brief Ottiene il nome della persona.
     * @return Il nome della persona.
     */
    public String getNome() {
        return this.nome;
    }
    
    /**
     * @brief Ottiene il cognome della persona.
     * @return Il cognome della persona.
    */
    public String getCognome() {
        return this.cognome;
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
        if(obj == null) 
            return false;
        
        if(this == obj)
            return true;
        
        if(!(obj instanceof Persona))
            return false;
        
        Persona p = (Persona) obj;
        
        return p.nome.equals(this.nome) && p.cognome.equals(this.cognome);
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
        if(!(this.cognome.equals(other.cognome)))
            return this.cognome.compareTo(other.cognome);
        
        return this.nome.compareTo(other.nome);
    }
    
    /**
     * @brief Rappresentazione testuale della persona.
     * @return La rappresentazione testuale.
    */
    @Override
    public String toString() {
        return "Persona -> Nome: " + this.nome + " - Cognome: " + this.cognome;
    }
    
}

