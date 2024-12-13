package it.unisa.diem.softeng.servizio;


import it.unisa.diem.softeng.modello.Contatto;

/**
 * @brief Interfaccia per la validazione di un contatto.
 * @see it.unisa.diem.softeng.modello::Contatto
 */
public interface InterfacciaValidaContatto {
    /**
     * @brief Valida un contatto.
     * 
     * I contatti devono avere almeno uno tra nome e cognome non vuoti.
     * I numeri di telefono, qualora esistano, devono avere dieci cifre.
     * Le email, qualora esistano, devono rispettare il seguente formato: [String]@[String].[String]
     * 
     * @param[in] contatto Rappresenta il contatto da validare.
     * @pre Il contatto non deve essere null.
     * @return true se il contatto è valido, false altrimenti.
    */
    boolean valida(Contatto contatto);
}
