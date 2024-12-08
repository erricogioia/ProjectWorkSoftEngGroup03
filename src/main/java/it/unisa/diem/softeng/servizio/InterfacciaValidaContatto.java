package it.unisa.diem.softeng.servizio;


import it.unisa.diem.softeng.modello.Contatto;

/**
 * @brief Interfaccia per la validazione di un contatto.
 * @see it.unisa.diem.softeng.modello::Contatto
 */
public interface InterfacciaValidaContatto {
    /**
     * @brief Valida un contatto.
     * @param[in] contatto Il contatto da validare.
     * @return true se il contatto è valido, altrimenti false.
    */
    boolean valida(Contatto contatto);
}
