package project.linkedIn.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public  class Verifcation {
	
	
	public static   boolean verif_mail(String mot) {
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
		Matcher matcher = pattern.matcher(mot);
		return matcher.matches();
    	
		
	}
	public static   boolean verif_varchar(String mot) {
		Pattern pattern = Pattern.compile("^[a-zA-Z'\\s]+$");
		Matcher matcher = pattern.matcher(mot);
		return matcher.matches();
   	
		
	}
	public static   boolean verif_pass(String mot) {
		Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");
		Matcher matcher = pattern.matcher(mot);
		return matcher.matches();
   	
		
	}
	
	
	 public static boolean verif_phone(String mot) {
	        
	        

	       
	        return Pattern.matches("\\d{8}", mot);
	    }
	
	public static void color_change_red(TextField o) {
		o.setStyle("-fx-border-color: red;-fx-border-width: 2px;");
		
		
	}
	
	
	public static void color_change_green(TextField o) {
		o.setStyle("-fx-border-color: green;-fx-border-width: 2px;");
		
		
	}
	public static void color_change_red(Text o) {
		o.setStyle("-fx-border-color: red;-fx-border-width: 2px;");
		
		
	}
	
	
	public static void color_change_green(Text o) {
		o.setStyle("-fx-border-color: green;-fx-border-width: 2px;");
		
		
	}

}
