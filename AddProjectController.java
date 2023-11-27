package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddProjectController implements Initializable {

	@FXML 
	private TextField tfDate;
	
    @FXML
    private TextField tfMatiere;

    @FXML
    private TextField tfSujet;

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tfDate.setPromptText("JJ/MM/AAAA");
	}
	
	private void submitAProject() {

		String nomMatiere = tfMatiere.getText();
		String sujet = tfSujet.getText();
		String dateRemisePrevue = tfDate.getText();
		
		insertProjet(nomMatiere, sujet, dateRemisePrevue);

	}
}

