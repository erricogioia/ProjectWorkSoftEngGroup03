package it.unisa.diem.softeng.controllo;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    /**
    * @brief Avvia l'applicazione JavaFX.
    * 
    * Questo metodo carica l'interfaccia grafica definita nel file "VistaPrincipale.fxml", imposta la scena principale sullo stage e la visualizza.
    *
    * @param[in] stage Lo stage principale dell'applicazione.
    */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("VistaPrincipale.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
