package com.fsb.linkedinProject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import com.fsb.linkedinProject.DAO.UserDAO;
import com.fsb.linkedinProject.Models.Account;
import com.fsb.linkedinProject.Models.Company;
import com.fsb.linkedinProject.Models.Employee;
import com.fsb.linkedinProject.Models.Experience;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
    	FileInputStream fis = null;
    	Company c = new Company(1, "emir", LocalDate.of(2003, 12, 14), "company" , 93432312, "zone urbain", null, "actif", null, "info", "very good company",null);
    	Account acc1 = new Account("facebook@gmail.com","deudeded",c);
    	UserDAO.addAccount(acc1);
    	File imageFile = new File("C:/Users/benar/Desktop/image.jpg");
        try {
			fis = new FileInputStream(imageFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	Experience exp1 = new Experience(3, "description","technicien" ,null);
    	Experience exp2 = new Experience(5, "description","technicien" ,null);
    	Employee emp = new Employee(1, "emir", LocalDate.of(2003, 12, 14), "employee", 97349546 ,"riadh andalous",fis,"actif", "benarbia", null, null, "male",null,c);
    	Account acc = new Account("benarbia@gmail.com", "emiremir", emp);
        UserDAO.addAccount(acc);
        System.out.println(UserDAO.getEmails());
        System.out.println("changes");
        
    }

}