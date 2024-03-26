package com.fsb.linkedinProject.Controllers;

import com.fsb.linkedinProject.App;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;

public class MainController {
    @FXML
    private Label Activities_link;

    @FXML
    private ImageView Chat_link;

    @FXML
    private ImageView Home_link;

    @FXML
    private ImageView Jobs_link;

    @FXML
    private Label Learnmore_link;

    @FXML
    private Label Profile_link;

    @FXML
    private Label Relationships_link;

    @FXML
    private Label Saved_link;

    @FXML
    private Label Settings_link;

    @FXML
    private void displayChats() throws IOException {
        App.setRoot("chat_interface");
    }




}
