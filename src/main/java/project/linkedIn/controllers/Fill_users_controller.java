package project.linkedIn.controllers;
import project.linkedIn.App;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import project.linkedIn.models.*;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import project.linkedIn.utility.Verifcation;

public class Fill_users_controller {
	@FXML
	private TextField mail_text;
	@FXML
	private Label pass_fail;
	@FXML
	private TextField firstname_text;
	@FXML
	private TextField pass1_text;
	@FXML
	private TextField pass2_text;
	@FXML
	private TextField lastname_text;
	@FXML
	private DatePicker date_text;
	@FXML
	private Button btn_confirm;
	@FXML
	private Text gender_fail;
	
	@FXML
	private TextField adresse_text;
	@FXML
	private TextField phone_text;
	
	@FXML
	private ImageView img_text;
	
	
	
	
	
	 @FXML
	  private ToggleGroup gender;

	  @FXML
	  private RadioButton gender_male_text;
	  @FXML
	  private RadioButton gender_female_text;

	   




	
	@FXML
	public void initialize() {
		Set<Object> list=new HashSet<>();
		gender_male_text.setSelected(true);
		btn_confirm.setDisable(list.size()!=7);
		
		
		phone_text.textProperty().addListener((observe,oldValue,newValue)->{
			if(!Verifcation.verif_phone(phone_text.getText())){
				Verifcation.color_change_red(phone_text);
				list.remove(phone_text);
				btn_confirm.setDisable(list.size()!=7);
				
			}
			else {
				
					Verifcation.color_change_green(phone_text);
					list.add(phone_text);
					btn_confirm.setDisable(list.size()!=7);
					}
			});
		
		adresse_text.textProperty().addListener((observe,oldValue,newValue)->{
			if(adresse_text.getText()==""){
				Verifcation.color_change_red(adresse_text);
				list.remove(adresse_text);
				btn_confirm.setDisable(list.size()!=7);
				
			}
			else {
				
					Verifcation.color_change_green(adresse_text);
					list.add(adresse_text);
					btn_confirm.setDisable(list.size()!=7);
					}
			});
		
		
		
		
		mail_text.textProperty().addListener((observe,oldValue,newValue)->{
			if(!Verifcation.verif_mail(mail_text.getText())){
				Verifcation.color_change_red(mail_text);
				list.remove(mail_text);
				btn_confirm.setDisable(list.size()!=7);
				
			}
			else {
				
					Verifcation.color_change_green(mail_text);
					list.add(mail_text);
					btn_confirm.setDisable(list.size()!=7);
					}
			});
		
		pass2_text.textProperty().addListener((observe,oldValue,newValue)->{
			if(!Verifcation.verif_pass(pass2_text.getText())){
				
				Verifcation.color_change_red(pass2_text);
				list.remove(pass2_text);
				btn_confirm.setDisable(list.size()!=7);
			
			}
			else {
				
				list.add(pass2_text);
				btn_confirm.setDisable(list.size()!=7);
				Verifcation.color_change_green(pass2_text);
				verif_equals(list);
				
			}
				
					
			
		});
		pass1_text.textProperty().addListener((observe,oldValue,newValue)->{
	if(!Verifcation.verif_pass(pass1_text.getText())){
				
				Verifcation.color_change_red(pass1_text);
				list.remove(pass1_text);
				btn_confirm.setDisable(list.size()!=7);
			
			}
			else {
				list.add(pass1_text);
				verif_equals(list);
				Verifcation.color_change_green(pass1_text);
				btn_confirm.setDisable(list.size()!=7);
			}
			
		});
		
		firstname_text.textProperty().addListener((observe,oldValue,newValue)->{
			if(!Verifcation.verif_varchar(firstname_text.getText())){
				Verifcation.color_change_red(firstname_text);
				list.remove(firstname_text);
				btn_confirm.setDisable(list.size()!=7);
				
			}
			else {
			
					Verifcation.color_change_green(firstname_text);
					list.add(firstname_text);
					btn_confirm.setDisable(list.size()!=7);
					}
			
		});
		lastname_text.textProperty().addListener((observe,oldValue,newValue)->{
			if(!Verifcation.verif_varchar(lastname_text.getText())){
				Verifcation.color_change_red(lastname_text);
				list.remove(lastname_text);
				btn_confirm.setDisable(list.size()!=7);
				
			}
			else {
			
					Verifcation.color_change_green(lastname_text);
					list.add(lastname_text);
					btn_confirm.setDisable(list.size()!=7);
					}
			
		});
		
		
		
	
	}
	
	
	
	public void verif_equals(Set<Object> list) {
		if(pass2_text.getText().compareTo(pass1_text.getText())!=0)
		{
			pass_fail.setText("passwords must be identical");
			btn_confirm.setDisable(true);
			list.remove(pass2_text);
			
			
		}
		else {
			pass_fail.setText("");
		
		}
	}
	
	
	
	public void confirmer() throws IOException {
		/*if((get_mails).contains(mail_text.getText())) {
			//mail_fail.SetText("Adress already used");
		}
		else {
			App.setRoot("LoginView");
		}
		*/
		Employee us=new Employee(0,firstname_text.getText(), date_text.getValue(), "Employe",29337633,
				null, null, lastname_text.getText(), null,null,((RadioButton) gender.getSelectedToggle()).getText() ,
				null,null);
		Account acc=new Account(mail_text.getText(), pass1_text.getText(), us);
		System.out.println(acc);
		App.setRoot("LoginView");
		
	}
	
	
	public void addImage() throws MalformedURLException {

        
        FileChooser fileChooser = new FileChooser();

        // Set the initial directory (optional)
        fileChooser.setInitialDirectory(new java.io.File("."));

        // Configure the FileChooser
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Image files", "*.JPEG", "*.jpg", "*.PNG", "*.png", "*.GIF", "*.gif")
          
        );

            java.io.File selectedFile = fileChooser.showOpenDialog(null);

	            if (selectedFile != null) {
	            	String imagePath = selectedFile.toURI().toURL().toString();
	            	Image image = new Image(imagePath);
	            	img_text.setImage(image);
	            	
	                 
	               
	            }
       
	}
	
	
	
	
	
	}

	
	


