package com.fsb.linkedinProject.Controllers;

import com.fsb.linkedinProject.App;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.ImagePattern;

import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.scene.text.TextFlow;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ChatController {


    @FXML
    ScrollPane massages;

    @FXML
    private GridPane gridPane;
    @FXML
    private HBox selectedItem;

    @FXML
    private ImageView Chat_link;

    @FXML
    private ListView<HBox> Chat_list;

    @FXML
    private ImageView Home_link;

    @FXML
    private ImageView Jobs_link;
    @FXML
    Image img =new Image(new FileInputStream("C:/Users/benar/OneDrive/Desktop/LinkedinProject/src/main/resources/com/fsb/linkedinProject/image.jpg"));

    @FXML
    private BorderPane borderPane;
    private Double h;
    private Double w;

    public ChatController() throws FileNotFoundException {
    }

    @FXML
    public void initialize(){


        ObservableList<HBox> items = FXCollections.observableArrayList();
        for (int i = 0; i < 15; i++) {
            HBox hBox = new HBox();
            hBox.getStyleClass().add("conversation");


            Circle c = new Circle();
            c.setFill(new ImagePattern(img));
            c.setCenterX(100);
            c.setCenterY(100);
            c.setRadius(30);

            Text titre = new Text("nom et prenom");
            titre.setStyle("-fx-font-size: 18px");

            Text message = new Text("this is a message " + i);

            VBox vbox = new VBox();
            vbox.getStyleClass().add("message");
            vbox.getChildren().addAll(titre , message);

            hBox.getChildren().addAll(c,vbox);
            items.add(hBox);
        }

        Chat_list.setItems(items);
        Chat_list.setCellFactory(param -> new ListCell<HBox>() {
            @Override
            protected void updateItem(HBox item, boolean empty) {
                super.updateItem(item, empty);

                // Set the height of each cell
                setPrefHeight(75); // Adjust the height as needed

                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setGraphic(item);
                    if (isSelected()) {
                        setStyle("-fx-background-color:  lightgrey;");
                        item.setStyle("-fx-background-color:  lightgrey;");
                    }
                    else {
                        setStyle("");
                        item.setStyle("");
                    }
                }
            }
        });

        Chat_list.setOnMouseClicked(event -> {
            try {
                DisplayConversation();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

    }
    public void DisplayConversation() throws FileNotFoundException {
        Circle c = new Circle();
        c.setFill(new ImagePattern(img));
        c.setCenterX(85);
        c.setCenterY(85);
        c.setRadius(30);
        c.setStyle("-fx-start-margin: 10; -fx-end-margin: 10");

        Label nomPrenom = new Label("barbarian emir");
        nomPrenom.setId("nomEtPrenom");
        HBox hbox = new HBox();
        hbox.setId("conversation_header");
        hbox.getChildren().addAll(c,nomPrenom);
        gridPane.setStyle("-fx-background-color: #F1FAEE");
        gridPane.add(hbox,0,0);

        HBox hbox2 = new HBox();
        Image image = new Image(new FileInputStream("C:/Users/benar/OneDrive/Desktop/LinkedinProject/src/main/resources/com/fsb/linkedinProject/icons/more_vert_FILL0_wght400_GRAD0_opsz24.png"));
        ImageView more = new ImageView(image);
        more.setStyle("-fx-padding: 10px");
        hbox2.getChildren().add(more);
        hbox2.setStyle("-fx-alignment: center-right");
        gridPane.add(hbox2,1,0);


        VBox content = new VBox();
        content.setFillWidth(true);
        massages.setFitToHeight(true);
        massages.setFitToWidth(true);
        content.setStyle("-fx-padding : 5;-fx-background-color: #F1FAEE;-fx-border-width: 3;-fx-spacing: 17");
        for(int i=0;i<10;i++){
            HBox h = new HBox();
            h.setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(h, Priority.ALWAYS);
            h.setFillHeight(true);

            TextFlow flow = new TextFlow();


            h.widthProperty().addListener((obs,oldVal,newVal)->{
                flow.setMaxWidth(h.getWidth()-(h.getWidth()/3));

            });

            flow.setStyle("-fx-background-color: lightblue;-fx-border-color: black;-fx-border-width: 3;-fx-border-radius: 5;-fx-padding: 15");
            flow.setMaxWidth(h.getWidth()-(h.getWidth()/3));
            flow.setPrefWidth(flow.getMinWidth());


            StackPane pane = new StackPane();

            Text message = getMessage();


            flow.getChildren().add(message);

            pane.getChildren().add(flow);


            h.getChildren().add(pane);



            if(i%2==0){
                h.setStyle("-fx-alignment: center-right");

            }
            else {
                h.setStyle("-fx-alignment: center-left");
            }


            content.getChildren().add(h);
        }
        massages.setVvalue(content.getHeight());
        massages.setContent(content);
        massages.setVvalue(1.0);

        HBox sendMessage = new HBox();
        sendMessage.setStyle("-fx-padding:15 ; -fx-spacing: 30 ;-fx-alignment: center ;  -fx-background-color: #F1FAEE ");

        HBox messageFieldHbox = new HBox();
        TextArea messageField = new TextArea();
        messageField.setPromptText("your message");
        messageField.setMaxHeight(40);
        messageField.setStyle("-fx-font-size: 15");
        messageFieldHbox.getChildren().add(messageField);
        messageFieldHbox.setStyle("-fx-padding: 0,50,0,50");


        Image sendImage = new Image(new FileInputStream("C:/Users/benar/OneDrive/Desktop/LinkedinProject/src/main/resources/com/fsb/linkedinProject/icons/send_FILL0_wght400_GRAD0_opsz24.png"));

        Circle sButton = new Circle();
        sButton.setFill(new ImagePattern(sendImage));
        sButton.setCenterX(100);
        sButton.setCenterY(100);
        sButton.setRadius(20);
        sButton.setStyle("-fx-cursor: hand ;");



        sendMessage.getChildren().addAll(messageFieldHbox,sButton);
        gridPane.add(sendMessage,0,2,2,1);

        sButton.setOnMouseClicked(event -> {
            String message = messageField.getText();
            if(!message.isEmpty()) {
                HBox h = addMessageToConversation(massages,message,content,messageField);
                massages.setVvalue(massages.getVvalue()+h.getHeight());
            }
        });

    }

    private static Text getMessage() {
        Text message;
        message = new Text("deddedededede");
        message.setStyle("-fx-alignment: center;-fx-font-size: 15px");
        message.setBoundsType(TextBoundsType.LOGICAL);
        return message;
    }

    private HBox addMessageToConversation(ScrollPane massages, String message, VBox content, TextArea messageField) {
        HBox h = new HBox();
        h.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(h, Priority.ALWAYS);
        h.setFillHeight(true);
        TextFlow flow = new TextFlow();


        h.widthProperty().addListener((obs,oldVal,newVal)->{
            flow.setMaxWidth(h.getWidth()-(h.getWidth()/3));

        });

        flow.setStyle("-fx-background-color: lightblue;-fx-border-color: black;-fx-border-width: 3;-fx-border-radius: 5;-fx-padding: 15");
        flow.setMaxWidth(h.getWidth()-(h.getWidth()/3));
        flow.setPrefWidth(flow.getMinWidth());


        StackPane pane = new StackPane();


        flow.getChildren().add(new Text(message));

        pane.getChildren().add(flow);


        h.getChildren().add(pane);



        h.setStyle("-fx-alignment: center-right");

        content.getChildren().add(h);
        messageField.clear();

        return h;



    }

    @FXML
    private void displayMain() throws IOException {
        App.setRoot("maininterface");
    }


}



