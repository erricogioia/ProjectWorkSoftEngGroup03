package it.unisa.diem.softeng.controllo;

import it.unisa.diem.softeng.servizio.InterfacciaRubrica;
import it.unisa.diem.softeng.persistenza.InterfacciaGestoreFile;
import it.unisa.diem.softeng.modello.Contatto;
import java.io.*;
import javafx.collections.*;
import javafx.scene.control.TableView;

/**
 * @brief Coordina l'interazione tra la vista principale e i dati della rubrica, oltre a delegare operazioni di file a InterfacciaGestoreFile.
 * @invariant La rubrica associata non deve essere mai null dopo l'inizializzazione del controllore.
 * @see it.unisa.diem.softeng.servizio::InterfacciaRubrica
 * @see it.unisa.diem.softeng.persistenza::InterfacciaGestoreFile
 */
public class ControlloreVistaPrincipale {
    private InterfacciaRubrica rubrica;
    private TableView<Contatto> tabellaContatti;
    private InterfacciaGestoreFile gestoreFile;
    
    /**
     * @brief Aggiunge un contatto alla rubrica.
     * 
     * L'aggiunta di un contatto viene realizzata richiamando il metodo crea() di ControllorePopUp.
     * 
     * @post Il contatto viene aggiunto alla rubrica, se valido.
     * @post Il contatto non viene aggiunto alla rubrica, se non valido.
     * @see ControllorePopUp#crea()
    */
    public void clickCrea() {
    }
    
    /**
     * @brief Gestisce il click sul pulsante "Esporta".
     *
     * L'esportazione viene realizzata richiamando il metodo esporta() di GestoreFile.
     * 
     * @pre La rubrica deve essere inizializzata.
     * @post I contatti della rubrica sono salvati su file.
     * @see it.unisa.diem.softeng.persistenza::InterfacciaGestoreFile
     */
    public void clickEsporta() {
        
    }
    
    /**
     * @brief Gestisce il click sul pulsante "Importa".
     * 
     * L'importazione viene realizzata richiamando il metodo importa() di GestoreFile.
     * 
     * @post La rubrica viene aggiornata per includere i contatti importati.
     * @see it.unisa.diem.softeng.persistenza::InterfacciaGestoreFile
     */
    public void clickImporta() {
        
    }

     /**
     * @brief Modifica un contatto dalla rubrica.
     * 
     * Modifica i dettagli del contatto selezionato, se le modifiche risultano valide.
     * 
     * @pre La rubrica non è null.
     * @pre Un contatto deve essere selezionato.
     * @post Il contatto selezionato viene aggiornato nella rubrica, se le modifiche risultano valide.
     * @post Il contatto selezionato non viene aggiornato, se le modifiche non risultano valide.
     * @post La rubrica viene aggiornata per riflettere gli eventuali cambiamenti.
     */
    public void modifica() {
        
    }

    /**
     * @brief Rimuove un contatto dalla rubrica.
     * 
     * Rimuove il contatto selezionato dalla rubrica.
     * 
     * @pre rubrica non è null.
     * @pre Un contatto deve essere selezionato.
     * @post Il contatto selezionato viene rimosso dalla rubrica.
     * @post La rubrica non mostra più il contatto rimosso.
     */
    public void rimuovi() {
        
    }

    /**
     * @brief Ricerca un contatto nella rubrica.
     * 
     * Filtra i contatti nella rubrica in base a una sottostringa passatogli.
     * 
     * @pre rubrica non è null.
     * @post La rubrica mostra solo i contatti che corrispondono al criterio di ricerca.
     */
    public void ricerca() {
        
    }

    private void mostraPopUpErrore(){
        
    }
    
}
