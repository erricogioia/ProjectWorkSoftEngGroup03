package it.unisa.diem.softeng.controllo;


import it.unisa.diem.softeng.modello.Contatto;
import it.unisa.diem.softeng.servizio.InterfacciaRubrica;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * @brief Classe ControllorePopUp gestisce la creazione delle voci della rubrica.
 * @invariant La rubrica associata non deve essere mai null dopo l'inizializzazione del controllore.
 * @see ControlloreVistaPrincipale
*/
public class ControllorePopUp implements Initializable {
    
    private InterfacciaRubrica rubrica;
    private ObservableList<Contatto> contatti;
    
    @FXML
    private TextField nomeField;
    @FXML
    private TextField cognomeField;
    @FXML
    private TextField telefono1Field;
    @FXML
    private TextField telefono2Field;
    @FXML
    private TextField telefono3Field;
    @FXML
    private TextField email1Field;
    @FXML
    private TextField email2Field;
    @FXML
    private TextField email3Field;
    @FXML
    private Button confermaButton;
    @FXML
    private Button annullaButton;
    
    /**
     * @brief Metodo per la creazione di un nuovo contatto nella rubrica.
     * @post Il contatto viene aggiunto alla rubrica, se valido.
     * @post Il contatto non viene aggiunto alla rubrica, se non valido.
     * @see it.unisa.diem.softeng.servizio::InterfacciaRubrica#creaContatto(Contatto)
    */
    @FXML
    public void crea() {
        boolean contattoValido = rubrica.creaContatto(new Contatto(nomeField.getText(), cognomeField.getText(), 
                telefono1Field.getText(), telefono2Field.getText(), telefono3Field.getText(), 
                email1Field.getText(), email2Field.getText(), email3Field.getText()));
        
        if(!contattoValido)
            mostraPopUpErrore();
        else
            aggiornaTabella();
        
        this.chiudiPopUp();
    }
    
    /**
     * @brief Metodo per annullare l'operazione corrente.
     * 
     * Ripristina lo stato precedente senza salvare modifiche nella rubrica.
     * 
     * @pre Le diverse operazioni devono essere in corso.
     * @post L'operazione corrente viene annullata e i dati non vengono salvati.
    */
    @FXML
    public void annulla() {
        this.chiudiPopUp();
    }

    private void mostraPopUpErrore(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore");
        alert.setHeaderText(null);
        alert.setContentText("Errore. Dati non validi.");
        alert.showAndWait();
    }
    
    public void setContatti(ObservableList<Contatto> contatti, InterfacciaRubrica rubrica) {
        this.contatti = contatti;
        this.rubrica = rubrica;
    }
    
    private void aggiornaTabella() {
        contatti.setAll(rubrica.getContatti().values());
    }
    
    private void chiudiPopUp() {
        Stage s = (Stage) nomeField.getParent().getScene().getWindow();
        s.close();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        confermaButton.disableProperty().bind(Bindings.and(nomeField.textProperty().isEmpty(), cognomeField.textProperty().isEmpty()));
    }
}
