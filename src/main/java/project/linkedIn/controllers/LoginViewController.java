package project.linkedIn.controllers;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.paint.Color;

import project.linkedIn.App;
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
		Set<Object> list=new HashSet<>();
		
		loginButton.setDisable(list.size()!=2);
		username.textProperty().addListener((observe,oldValue,newValue)->{
			if(!Verifcation.verif_mail(username.getText())){
				Verifcation.color_change_red(username);
				list.remove(username);
				loginButton.setDisable(list.size()!=2);
				
			}
			else {
				
					Verifcation.color_change_green(username);
					list.add(username);
					loginButton.setDisable(list.size()!=2);
					}
			
		});
		pass.textProperty().addListener((observe,oldValue,newValue)->{
			if(!Verifcation.verif_pass(pass.getText())){
				
				Verifcation.color_change_red(pass);
				list.remove(pass);
				loginButton.setDisable(list.size()!=2);
			
			}
			else {
			
				list.add(pass);
				loginButton.setDisable(list.size()!=2);
				Verifcation.color_change_green(pass);
				
				
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
}