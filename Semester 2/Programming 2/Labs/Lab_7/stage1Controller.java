package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;

/**
 * This class is the controller for stage1.fxml. It would take in the users input and move to the next stage.
 *
 */
public class stage1Controller {
	@FXML
	private TextField tText1;
	@FXML
	private TextField tText2;

	/**
	 * This method opens an information dialog box that explains the purpose of the application.
	 * @param event
	 */
	@FXML
	public void btnHelpClicked(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText("Welcome to the application!");
		alert.setContentText("This app is meant to test different types of dialogs. You can put in your user info and then proceed to the next stage."
				+ " There will be a total of 6 options to choose from. Enjoy exploring!");
		
		alert.showAndWait();
	}

	/**
	 * This method moves to stage2 of the application
	 * @param event
	 */
	@FXML
	public void btnNextClicked(ActionEvent event) {
	    
		String text1;
		String text2;
		
	    Stage primaryStage2=new Stage();
    	Parent p1;
		try {
			p1 = FXMLLoader.load(getClass().getResource("stage2.fxml"));
	    	Scene s1=new Scene(p1);
	        primaryStage2.setScene(s1);
	        primaryStage2.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		text1 = tText1.getText();
		text2 = tText2.getText();
		
		System.out.println("Username: " + text1 + "\nPassword: " + text2);
	}
}

