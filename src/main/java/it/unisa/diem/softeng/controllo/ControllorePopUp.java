package it.unisa.diem.softeng.controllo;


import it.unisa.diem.softeng.servizio.InterfacciaRubrica;

/**
 * @brief Classe ControllorePopUp gestisce la creazione delle voci della rubrica.
 * @invariant La rubrica associata non deve essere mai null dopo l'inizializzazione del controllore.
 * @see ControlloreVistaPrincipale
*/

public class ControllorePopUp {
    
    private InterfacciaRubrica rubrica;
    
    /**
     * @brief Metodo per la creazione di un nuovo contatto nella rubrica.
     * @post Il contatto viene aggiunto alla rubrica, se valido.
     * @post Il contatto non viene aggiunto alla rubrica, se non valido.
     * @see it.unisa.diem.softeng.servizio::InterfacciaRubrica#creaContatto(Contatto)
    */
    public void crea() {
        
    }
    
    /**
     * @brief Metodo per annullare l'operazione corrente.
     * 
     * Ripristina lo stato precedente senza salvare modifiche nella rubrica.
     * 
     * @pre Le diverse operazioni devono essere in corso.
     * @post L'operazione corrente viene annullata e i dati non vengono salvati.
    */
    public void annulla() {
        
    }

    private void mostraPopUpErrore(){
        
    }
}
