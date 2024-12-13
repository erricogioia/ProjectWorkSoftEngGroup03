package it.unisa.diem.softeng.controllo;

import it.unisa.diem.softeng.servizio.InterfacciaRubrica;
import it.unisa.diem.softeng.persistenza.InterfacciaGestoreFile;
import it.unisa.diem.softeng.modello.Contatto;
import it.unisa.diem.softeng.modello.Persona;
import it.unisa.diem.softeng.persistenza.GestoreFile;
import it.unisa.diem.softeng.servizio.Rubrica;
import it.unisa.diem.softeng.servizio.ValidaContatto;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

/**
 * @brief Coordina l'interazione tra la vista principale e i dati della rubrica, oltre a delegare operazioni di file a InterfacciaGestoreFile.
 * @invariant La rubrica associata non deve essere mai null dopo l'inizializzazione del controllore.
 * @see it.unisa.diem.softeng.servizio::InterfacciaRubrica
 * @see it.unisa.diem.softeng.persistenza::InterfacciaGestoreFile
 */
public class ControlloreVistaPrincipale {
    
    private InterfacciaRubrica rubrica;
    private InterfacciaGestoreFile gestoreFile;
    private ObservableList<Contatto> contatti;
    
    @FXML
    private TableView<Contatto> tabellaContatti;
    @FXML
    private MenuItem apriItem;
    @FXML
    private MenuItem salvaComeItem;
    @FXML
    private Button creaButton;
    @FXML
    private Button rimuoviButton;
    @FXML
    private TableColumn<Contatto, String> nomeCln;
    @FXML
    private TableColumn<Contatto, String> cognomeCln;
    @FXML
    private TableColumn<Contatto, String> telefono1Cln;
    @FXML
    private TableColumn<Contatto, String> telefono2Cln;
    @FXML
    private TableColumn<Contatto, String> telefono3Cln;
    @FXML
    private TableColumn<Contatto, String> email1Cln;
    @FXML
    private TableColumn<Contatto, String> email2Cln;
    @FXML
    private TableColumn<Contatto, String> email3Cln;
    @FXML
    private TextField cercaField;
    
    /**
     * @brief Aggiunge un contatto alla rubrica.
     * 
     * L'aggiunta di un contatto viene realizzata richiamando il metodo crea() di ControllorePopUp.
     * 
     * @post Il contatto viene aggiunto alla rubrica, se valido.
     * @post Il contatto non viene aggiunto alla rubrica, se non valido.
     * @see ControllorePopUp#crea()
    */
    @FXML
    public void clickCrea() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("VistaPopUp.fxml"));
        Parent root = loader.load();

        ControllorePopUp popupController = loader.getController();
        popupController.setContatti(contatti, rubrica);
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        
        stage.setScene(scene);
        stage.show(); 
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
    public void clickEsporta() throws IOException {
        gestoreFile.esporta(rubrica);
    }
    
    /**
     * @brief Gestisce il click sul pulsante "Importa".
     * 
     * L'importazione viene realizzata richiamando il metodo importa() di GestoreFile.
     * 
     * @post La rubrica viene aggiornata per includere i contatti importati.
     * @see it.unisa.diem.softeng.persistenza::InterfacciaGestoreFile
     */
    public void clickImporta() throws IOException {
        rubrica = gestoreFile.importa();
        aggiornaTabella();
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
    
    private void aggiornaTabella(){
        contatti.setAll(rubrica.getContatti().values());
        tabellaContatti.setItems(contatti);
    }
    
}
