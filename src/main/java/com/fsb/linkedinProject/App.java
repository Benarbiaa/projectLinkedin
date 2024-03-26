package com.fsb.linkedinProject;

import com.fsb.linkedinProject.Controllers.ChatController;
import com.fsb.linkedinProject.DAO.ConversationDAO;
import com.fsb.linkedinProject.Models.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import com.fsb.linkedinProject.DAO.UserDAO;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("maininterface"));
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }



    public static void main(String[] args) throws SQLException, IOException {
        launch();
        /*FileInputStream fis = null;
    	Company c = new Company(1, "emir", LocalDate.of(2003, 12, 14), "company" , 93432312, "zone urbain", null, "actif", null, "info", "very good company",null);
    	Account acc1 = new Account("facebook@gmail.com","deudeded",c);
    	UserDAO.addAccount(acc1);
    	File imageFile = new File("src/main/resources/com/fsb/linkedinProject/image.jpg");
        try {
			fis = new FileInputStream(imageFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	Experience exp1 = new Experience(3, "description","ingenieur" ,"php");
    	Experience exp2 = new Experience(5, "description","technicien" ,"java");
    	Employee emp = new Employee(1, "emir",
                LocalDate.of(2003, 12, 14),
                "employee", 97349546 ,
                "riadh andalous",
                fis,"actif",
                "benarbia", List.of(exp1,exp2), null, "male",null,c);
    	Account acc = new Account("benarbia@gmail.com", "emiremir", emp);
        UserDAO.addAccount(acc);
        System.out.println(UserDAO.getEmails());
        FileInputStream fis = null;
        File imageFile = new File("src/main/resources/com/fsb/linkedinProject/image.jpg");
        try {
            fis = new FileInputStream(imageFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Message msg1 = new Message((User)c,(User)emp,"msg1", LocalDateTime.now());
        Message msg2 = new Message((User)c,(User)emp,"msg2", LocalDateTime.now().plusSeconds(30));
        Message msg3 = new Message((User)emp,(User)c,"msg3", LocalDateTime.now().plusMinutes(1));
        Message msg4 = new Message((User)emp,(User)c,"msg4", LocalDateTime.now().plusMinutes(2));
        Message msg5 = new Message((User)c,(User)emp,"msg5", LocalDateTime.now().plusMinutes(3));
        ConversationDAO.sendMessage(msg1);
        ConversationDAO.sendMessage(msg2);
        ConversationDAO.sendMessage(msg3);
        System.out.println("sent");
        ConversationDAO.sendMessage(msg4);
        ConversationDAO.sendMessage(msg5);
        Company c = new Company(1, "emir", LocalDate.of(2003, 12, 14), "company" , 93432312, "zone urbain", null, "actif", null, "info", "very good company",null);
        Employee emp = new Employee(2, "emir",
                LocalDate.of(2003, 12, 14),
                "employee", 97349546 ,
                "riadh andalous",
                null,"actif",
                "benarbia", null, null, "male",null,c);
        Set<Message> allMessages = new TreeSet<Message>(Comparator.comparing(Message::getDate));
        allMessages.addAll(ConversationDAO.getMessages(emp,c));
        allMessages.addAll(ConversationDAO.getMessages(c,emp));
        System.out.println(allMessages);*/
        UserDAO.addRelation(UserDAO.getUser(1),UserDAO.getUser(2));





        
    }


}