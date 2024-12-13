package it.unisa.diem.softeng.persistenza;

import it.unisa.diem.softeng.modello.Contatto;
import it.unisa.diem.softeng.servizio.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javafx.stage.FileChooser;

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
        if(rubrica == null)
            throw new IllegalArgumentException("Rubrica uguale a 'null'");
        
        FileChooser fc = new FileChooser();
        File f = fc.showSaveDialog(null);
        
        if(f == null)
            return;
        
        scriviFile(rubrica, f);
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
