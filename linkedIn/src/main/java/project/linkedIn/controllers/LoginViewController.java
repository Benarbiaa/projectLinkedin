package project.linkedIn.controllers;

import java.io.IOException;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.paint.Color;

import project.linkedIn.App;
import project.linkedIn.models.Account;
import project.linkedIn.utility.Verifcation;

public class LoginViewController {
	@FXML
	private TextField username;
	@FXML
	private TextField pass;
	@FXML
	private Button loginButton;
	
	@FXML
	private Label registerText;
    
	@FXML
	public void initialize() {
		loginButton.setDisable(true);
		username.textProperty().addListener((observe,oldValue,newValue)->{
			if(!Verifcation.verif_mail(username.getText())) {
	    		username.setStyle("-fx-border-color: red; ");
	    		
	    		loginButton.setDisable(true);
	    	}
	    	else {
	    		username.setStyle("-fx-border-color: green; ");
	    		loginButton.setDisable(pass.getStyle().contains("red")|| pass.getText()=="");
	    	}
			
		});
		pass.textProperty().addListener((observe,oldValue,newValue)->{
			if(!Verifcation.verif_pass(pass.getText())) {
	    		pass.setStyle("-fx-border-color: red;");
	    		
	    		loginButton.setDisable(true);
	    	}
	    	else {
	    		pass.setStyle("-fx-border-color: green;");
	    		loginButton.setDisable(username.getText()==""|| username.getStyle().contains("red"));
	    	}
			
		});
		
		registerText.setOnMouseEntered(event -> {
			registerText.setUnderline(true);
			registerText.setTextFill(Color.BLUE);
			});
		 registerText.setOnMouseExited(event -> {
			 registerText.setUnderline(false);
		 registerText.setTextFill(Color.BLACK);
			 
		 });
	}
	
	
	
	
	
	
	
	
	
	@FXML
   
    private void switch_login_choice() throws IOException {
		App.setRoot("int_login_choice");
    	
    	
    	
        
    }
	
/*	@FXML
	private void login() {
		Account account=login_dao.getAccount(username.getText());
		if (account==null) {
			registerText.setText("Non existing account");
		}
		else {
			if(account.getPassword()!=pass.getText()) {
				registerText.setText("Non existing account");
			}
			else {
				
			}
		}
		
		
	}
	*/

}
