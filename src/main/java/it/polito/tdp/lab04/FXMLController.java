package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model = new Model();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAutoCompletamento;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnCercaIscrittiCorso;

    @FXML
    private Button btnIscrivi;
    
    @FXML
    private Button btnIscrizioneCorso;

    @FXML
    private Button btnReset;

    @FXML
    private ChoiceBox<Corso> listaCorsi;

    @FXML
    private TextField txtCognome;

    @FXML
    private TextField txtMatricola;

    @FXML
    private TextField txtNome;

    @FXML
    private TextArea txtRisultato;

    @FXML
    void handleAutoCompletamento(ActionEvent event) {
    	
    	try {
    		int input = Integer.parseInt(this.txtMatricola.getText());
    		
    		if (this.model.getStudente(input) != null){
        		
    			txtNome.setText(this.model.getStudente(input).getNome());
        		txtCognome.setText(this.model.getStudente(input).getCognome());
 
    		}
    		else {
    			this.txtRisultato.appendText("Errore nell'autocompletamento. Non esiste alcuno studente avente tale matricola.\n");
    		}
    	}
    	catch (NumberFormatException nfe) {
    		
    		this.txtRisultato.appendText("Errore nell'autocompletamento. La matricola inserita contiene caratteri non permessi.\n");
    	
    	}
    	
    	
    }

    @FXML
    void handleCercaCorsi(ActionEvent event) {
    	
    	try {
    		
    		int matricola = Integer.parseInt(this.txtMatricola.getText());
    		
    		if (this.model.getStudente(matricola) != null){
    			
    			if (this.model.getCorsiStudente(matricola).size() == 0) {
    				
    				this.txtRisultato.appendText("Lo studente selezionato non è iscritto ad alcun corso.\n");
    			
    			}
    			else{
    				
    				for (Corso c : this.model.getCorsiStudente(matricola)) {
            			
        				this.txtRisultato.appendText(c.toStringFull() + "\n");
            		
        			}
    			}	
        	}
        	else {
        		
        		this.txtRisultato.appendText("Errore nella ricerca dei corsi. Non è stato trovato alcuno studente avente tale matricola.\n");
        	
        	}
    	
    	} catch (NumberFormatException nfe) {
    		
    		this.txtRisultato.appendText("Errore nella ricerca dei corsi. La matricola inserita contiene caratteri non permessi.\n");
    	
    	}
    	 	
    }

    @FXML
    void handleCercaIscrittiCorso(ActionEvent event) {
    	
    	Corso corso = this.listaCorsi.getValue();
    	
    	if (corso == null) {
    		
    		this.txtRisultato.appendText("Errore. Non è stato selezionato alcun corso.\n");
    	
    	}
    	else {
    		
    		if (this.model.getStudentiIscrittiCorso(corso).size() == 0) {
    			
    			this.txtRisultato.appendText("Il corso selezionato non presenta alcun iscritto.\n");
    		
    		}
    		else {
    			
    			for (Studente s : this.model.getStudentiIscrittiCorso(corso)) {
        			
    				this.txtRisultato.appendText(s.toString() + "\n");
        		
    			}
    		}
    	}	
    }

    @FXML
    void handleIscrivi(ActionEvent event) {

    }
    
    @FXML
    void handleIscrizioneCorso(ActionEvent event) {
    	
    	try {
    		
    		int matricola = Integer.parseInt(this.txtMatricola.getText());
    		Studente studente = this.model.getStudente(matricola);
    		
    		if (studente != null){
    			
    			Corso corso = this.listaCorsi.getValue();
    			
    			if (corso == null) {
    				
    				this.txtRisultato.appendText("Errore nella verifica di iscrizione al corso. Non è stato selezionato alcun corso.\n");
    			
    			}
    			else {
    				
    				if (this.model.verificaIscrizioneCorso(studente, corso) == true) {
        	    		
        				this.txtRisultato.appendText("Lo studente risulta iscritto al corso selezionato.\n");
        	    	
        			}
        	    	else {
        	    		
        	    		this.txtRisultato.appendText("Lo studente non risulta iscritto al corso selezionato.\n");
        	    	
        	    	}
    			}
    		}
    		else {
    			
    			this.txtRisultato.appendText("Errore nella verifica di iscrizione al corso. Non esiste alcuno studente avente tale matricola.\n");
    		
    		}
    	}
    	catch (NumberFormatException nfe) {
    		
    		this.txtRisultato.appendText("Errore nella verifica di iscrizione al corso. La matricola inserita contiene caratteri non permessi.\n");
    	
    	}
    	
    }

    @FXML
    void handleReset(ActionEvent event) {
    	this.txtCognome.clear();
    	this.txtNome.clear();
    	this.txtMatricola.clear();
    	this.txtRisultato.clear();
    }

    @FXML
    void initialize() {
        assert btnAutoCompletamento != null : "fx:id=\"btnAutoCompletamento\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscrizioneCorso != null : "fx:id=\"btnIscrizioneCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert listaCorsi != null : "fx:id=\"listaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        this.listaCorsi.getItems().addAll(this.model.getTuttiICorsi());
    }

}