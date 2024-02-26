package project.linkedIn.controllers;

import java.io.IOException;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import project.linkedIn.App;

public class Choice_Login_Controller {
	
	
	@FXML
	private Button btnSignInCompany;
	@FXML
	private Button btnSingInEmploye;
	
	
	@FXML
	public void initialize() {
		
		
		// animation des bouttons 
		btnSignInCompany.setOnMouseEntered(event -> {
			btnSignInCompany.setFont(Font.font("System", FontWeight.BOLD,34));
			});
		btnSignInCompany.setOnMouseExited(event -> {
			btnSignInCompany.setFont(Font.font("System", FontWeight.NORMAL,30));
			 
		 });
		
		
		btnSingInEmploye.setOnMouseEntered(event -> {
			
			btnSingInEmploye.setFont(Font.font("System", FontWeight.BOLD,34));
			});
		btnSingInEmploye.setOnMouseExited(event -> {
			btnSingInEmploye.setFont(Font.font("System", FontWeight.NORMAL,30));
			 
		 });
	}
	

	@FXML
	public void switch_fill_user() throws IOException {
		App.setRoot("iheb_orange");
	}

	@FXML
	public void switch_fill_company() throws IOException {
		App.setRoot("fill_campany");
	}
	
	
	
	

}
