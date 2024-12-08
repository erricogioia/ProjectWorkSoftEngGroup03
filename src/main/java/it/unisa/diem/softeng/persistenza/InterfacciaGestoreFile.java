package it.unisa.diem.softeng.persistenza;

import it.unisa.diem.softeng.servizio.*;
import java.io.IOException;

/**
 * @brief Interfaccia per la gestione dei file della rubrica.
 */

public interface InterfacciaGestoreFile {
    /**
     * @brief Salva i dati della rubrica su un file.
     * @param[in] rubrica La rubrica da salvare.
     * @pre La rubrica non è null.
     * @post I dati della rubrica sono salvati sul file specificato tramite il FileChooser.
    */
    void esporta(InterfacciaRubrica rubrica) throws IOException;

    /**
     * @brief Carica i dati di una rubrica da un file.
     * @post La rubrica viene popolata con i dati del file specificato tramite il FileChooser.
     * @return Un'istanza di Rubrica contenente i dati caricati.
     */
    InterfacciaRubrica importa() throws IOException;
    
}