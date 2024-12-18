package it.unisa.diem.softeng.modello;

import java.util.ArrayList;
import java.util.List;

/**
 * @brief Rappresenta un contatto nella rubrica.
 * 
 * Questa classe, estendendo Persona, viene usata per caratterizzare completamente un Contatto all'interno di Rubrica.
 * 
 * @invariant Il contatto deve avere, qualora esistano, numeri di telefono ed email non null.
 * @see Persona
 */
public class Contatto extends Persona{
    
    private List<String> numeriTelefono;
    private List<String> email;

    /**
     * @brief Costruttore della classe Contatto.
     * 
     * Qualora venisse inserito un sottoinsieme dei parametri relativi ai numeri di telefono o alle email, la rimanente parte conterrà stringhe vuote.
     * 
     * @param[in] nome Il nome della Persona.
     * @param[in] cognome Il cognome della Persona.
     * @param[in] numeroTelefono1 Il primo numero di telefono di Contatto.
     * @param[in] numeroTelefono2 Il secondo numero di telefono di Contatto.
     * @param[in] numeroTelefono3 Il terzo numero di telefono di Contatto.
     * @param[in] email1 La prima email di Contatto.
     * @param[in] email2 La seconda email di Contatto.
     * @param[in] email3 La terza email di Contatto.
     */
    public Contatto(String nome, String cognome, String numeroTelefono1, String numeroTelefono2, String numeroTelefono3, String email1, String email2, String email3) {
        super(nome, cognome);
        
        if (numeroTelefono1 == null || numeroTelefono2 == null || numeroTelefono3 == null || email1 == null || email2 == null || email3 == null)
            throw new IllegalArgumentException("Almeno uno tra i campi 'Numero di Telefono' o 'E-mail' è null");
        
        this.numeriTelefono = new ArrayList<>();
        this.numeriTelefono.add(numeroTelefono1);
        this.numeriTelefono.add(numeroTelefono2);
        this.numeriTelefono.add(numeroTelefono3);
        
        this.email = new ArrayList<>();
        this.email.add(email1);
        this.email.add(email2);
        this.email.add(email3);
    }

    /**
     * @brief Ottiene i numeri di telefono del contatto.
     * @return Una lista di numeri di telefono.
     */
    public List<String> getNumeriTelefono() {
        return this.numeriTelefono;
    }

    /**
     * @brief Ottiene gli indirizzi email del contatto.
     * @return Una lista di email.
     */
    public List<String> getEmail() {
        return this.email; 
    }
    
    /**
     * @brief Confronta questo contatto con un altro oggetto.
     * 
     * Il confronto avviene contemporaneamente secondo il nome, il cognome, i numeri di telefono e le e-mail.
     *
     * @param[in] obj L'oggetto con cui effettuare il confronto.
     * @return true se gli oggetti sono uguali, altrimenti false.
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        
        if (obj == null)
            return false;
        
        if (getClass() != obj.getClass())
            return false;
        
        Contatto c = (Contatto) obj;
        
        return super.equals(c) && this.numeriTelefono.equals(c.numeriTelefono) && this.email.equals(c.email);
    }  
}

