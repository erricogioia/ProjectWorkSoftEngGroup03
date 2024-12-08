package it.unisa.diem.softeng.persistenza;

import it.unisa.diem.softeng.servizio.*;
import java.io.File;
import java.io.IOException;

/**
 * @brief Implementa l'interfaccia InterfacciaGestoreFile per il salvataggio e il caricamento della rubrica.
 * @see InterfacciaGestoreFile
 * @see it.unisa.diem.softeng.servizio::InterfacciaRubrica
 */

public class GestoreFile implements InterfacciaGestoreFile {

   /**
     * @copydoc InterfacciaGestoreFile::esporta
    */
    @Override
    public void esporta(InterfacciaRubrica rubrica) throws IOException {
    }
    
    /**
     * @copydoc InterfacciaGestoreFile::importa
    */
    @Override
    public InterfacciaRubrica importa() throws IOException {
        return null;
    }
    
    private void scriviFile(InterfacciaRubrica rubrica, File file) {

    }

    private static InterfacciaRubrica leggiFile(File file) {
        return null;
    }

}
