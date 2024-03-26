package project.linkedIn.controllers;
import project.linkedIn.App;
import project.linkedIn.models.Account;
import project.linkedIn.models.Employee;
import project.linkedIn.models.Experience;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import project.linkedIn.utility.*;

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
	private Button comp_confirmer;
	@FXML
	private Button exp_confirmer;
	@FXML
	private Text gender_fail;
	
	@FXML
	private TextField adresse_text;
	@FXML
	private TextField phone_text;
	
	@FXML
	private Circle img_text;
	
	

	
	
	
	
	 @FXML
	  private ToggleGroup gender;

	  @FXML
	  private RadioButton gender_male_text;
	  @FXML
	  private RadioButton gender_female_text;

	   

	//les champs de competence	
		@FXML
		private TextField comp_title;
		@FXML
		private TextField comp_tech;
		@FXML
		private TextArea comp_descritpion;
		
		
		
		//les champs de experience
		@FXML
		private TextField exp_period;
		@FXML
		private TextField exp_type;
		@FXML
		private TextArea exp_description;
		@FXML
		private TextField exp_tech;
		@FXML
		private ComboBox<String> exp_list;


	
	@FXML
	public void initialize() {
		Set<Object> list=new HashSet<>();
		Set<Object> list_exp=new HashSet<>();
		Set<Object> list_comp=new HashSet<>();
		
		btn_confirm.setDisable(list.size()!=7);
		comp_confirmer.setDisable(list_comp.size()!=4);
		exp_confirmer.setDisable(list_exp.size()!=4);
		
	// verification formulaire 	
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
		// verification competence
		comp_title.textProperty().addListener((observe,oldValue,newValue)->{
			if(comp_title.getText()==""){
				Verifcation.color_change_red(comp_title);
				list_comp.remove(comp_title);
				comp_confirmer.setDisable(list_comp.size()!=3);
				
			}
			else {
				
					Verifcation.color_change_green(comp_title);
					list_comp .add(comp_title);
					comp_confirmer.setDisable(list_comp.size()!=3);
					}
			});
		
		comp_tech.textProperty().addListener((observe,oldValue,newValue)->{
			if(comp_tech.getText()==""){
				Verifcation.color_change_red(comp_tech);
				list_comp.remove(comp_tech);
				comp_confirmer.setDisable(list_comp.size()!=3);
				
			}
			else {
				
					Verifcation.color_change_green(comp_tech);
					list_comp.add(comp_tech);
					comp_confirmer.setDisable(list_comp.size()!=3);
					}
			});
		
		
		
		
		comp_descritpion.textProperty().addListener((observe,oldValue,newValue)->{
			if(comp_descritpion.getText()==""){
				Verifcation.color_change_red(comp_descritpion);
				list_comp.remove(comp_descritpion);
				comp_confirmer.setDisable(list_comp.size()!=3);
				
			}
			else {
				
					Verifcation.color_change_green(comp_descritpion);
					list_comp.add(comp_descritpion);
					comp_confirmer.setDisable(list_comp.size()!=3);
					}
			});
		
		
		// verification experience
				exp_period.textProperty().addListener((observe,oldValue,newValue)->{
					if(exp_period.getText()==""){
						Verifcation.color_change_red(exp_period);
						list_exp.remove(exp_period);
						exp_confirmer.setDisable(list_exp.size()!=4);
						
					}
					else {
						
							Verifcation.color_change_green(exp_period);
							list_exp .add(exp_period);
							exp_confirmer.setDisable(list_exp.size()!=4);
							}
					});
				
				exp_description.textProperty().addListener((observe,oldValue,newValue)->{
					if(exp_description.getText()==""){
						Verifcation.color_change_red(exp_description);
						list_exp.remove(exp_description);
						exp_confirmer.setDisable(list_exp.size()!=4);
						
					}
					else {
						
							Verifcation.color_change_green(exp_description);
							list_exp.add(exp_description);
							comp_confirmer.setDisable(list_exp.size()!=4);
							}
					});
				
				
				
				
				exp_tech.textProperty().addListener((observe,oldValue,newValue)->{
					if(exp_tech.getText()==""){
						Verifcation.color_change_red(exp_tech);
						list_exp.remove(exp_tech);
						exp_confirmer.setDisable(list_exp.size()!=4);
						
					}
					else {
						
							Verifcation.color_change_green(exp_tech);
							list_exp.add(exp_tech);
							exp_confirmer.setDisable(list_exp.size()!=4);
							}
					});
				
				exp_type.textProperty().addListener((observe,oldValue,newValue)->{
					if(exp_type.getText()==""){
						Verifcation.color_change_red(exp_type);
						list_exp.remove(exp_type);
						exp_confirmer.setDisable(list_exp.size()!=4);
						
					}
					else {
						
							Verifcation.color_change_green(exp_type);
							list_exp.add(exp_type);
							exp_confirmer.setDisable(list_exp.size()!=4);
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

       Utilities.image_chooser(img_text);
       
	}
	
	
	public void ajouter_exp() {
		Experience nv_exp=new Experience( Integer.parseInt(exp_period.getText()),exp_description.getText(),"ceo",exp_tech.getText());
		System.out.println(nv_exp);
		ObservableList<String> items = FXCollections.observableArrayList();
		items.add(exp_period.getText()+" | "+exp_tech.getText());
		exp_list.setItems(items);
	}
	
	
	
	
	}