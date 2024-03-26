package project.linkedIn.utility;

import java.io.File;
import java.net.MalformedURLException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.FileChooser;

public class Utilities {
	public static Image image_chooser(Object img) {
		 Image image =null;
	    FileChooser fileChooser = new FileChooser();
	    fileChooser.setInitialDirectory(new File("."));
	    fileChooser.getExtensionFilters().addAll(
	            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.bmp", "*.jpeg")
	    );

	    try {
	        File selectedFile = fileChooser.showOpenDialog(null);
	        if (selectedFile != null) {
	            String imagePath = selectedFile.toURI().toURL().toString();
	             image = new Image(imagePath);
	            if (img instanceof Circle) {
	                ((Circle) img).setFill(new ImagePattern(image));
	            } else if (img instanceof Rectangle) {
	                ((Rectangle) img).setFill(new ImagePattern(image));
	            } else if (img instanceof ImageView) {
	                ((ImageView) img).setImage(image);
	            }
	        }
	    } catch (MalformedURLException e) {
	        System.err.println("Error: Malformed URL for selected image file.");
	        e.printStackTrace();
	    }
	    return image;
	}
	

}
