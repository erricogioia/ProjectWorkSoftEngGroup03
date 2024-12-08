package it.unisa.diem.softeng.modello;

import java.util.List;

/**
 * @brief Rappresenta un contatto nella rubrica.
 * 
 * Questa classe, estendendo Persona, viene usata per caratterizzare completamente un Contatto all'interno di Rubrica.
 * 
 * @invariant Il contatto deve avere, qualora esistano, numeri di telefono ed email validi.
 * @invariant Il contatto deve avere massimo tre numeri di telefono.
 * @invariant Il contatto deve avere massimo tre email.
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
    }

    /**
     * @brief Ottiene i numeri di telefono del contatto.
     * @return Una lista di numeri di telefono.
     */
    public List<String> getNumeriTelefono() {
        return null;
    }

    /**
     * @brief Ottiene gli indirizzi email del contatto.
     * @return Una lista di email.
     */
    public List<String> getEmail() {
        return null; 
    }

    /**
     * @brief Rappresentazione testuale del contatto.
     * @return La rappresentazione testuale.
     */
    @Override
    public String toString() {
        return null;
    }
}

