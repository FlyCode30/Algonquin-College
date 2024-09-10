package application;


import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.util.Pair;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.application.Platform;
import javafx.event.ActionEvent;

public class stage2Controller {
	
	@FXML
	private Stage stage;
	@FXML
	private Button closeButton;
    @FXML
	private Button infoDialogButton;
    @FXML
	private Button confirmAction;
    @FXML
	private Button textInput;
    @FXML
	private Button customLogin;
    @FXML
	private Button choiceDialog;

	/** 
	 * This method closes the current stage.
	 * @param event
	 */
	@FXML
	public void btnCloseClicked(ActionEvent event) {
		Stage stage = (Stage) closeButton.getScene().getWindow();
        // Close the stage
        stage.close();
	}
	
	/**
	 * This method opens an information dialog.
	 * @param event
	 */
	@FXML
    private void infoDialog(ActionEvent event) throws IOException {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Information Dialog");
    	alert.setHeaderText("This app tests out the different types of dialogs!");
    	alert.setContentText("There are 6 options to choose from. Enjoy!");

    	alert.showAndWait();
    }
	
	/**
	 * This method opens a dialog that offers the user 3 different options of how to proceed.
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void confirmAction(ActionEvent event) throws IOException {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
		alert.setHeaderText("Look, a Confirmation Dialog");
		alert.setContentText("Are you ok with this?");
		
		// create the buttons
		ButtonType buttonTypeOne = new ButtonType("Continue");
		ButtonType buttonTypeTwo = new ButtonType("Return to home page");
		ButtonType buttonTypeThree = new ButtonType("Close the application");
		ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
		
		alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeCancel);
		
		// 4 different ways to handle the result
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeOne) {
		    System.out.println("Loads a new stage");
		} else  if (result.get() == buttonTypeTwo) {
			try {
				Stage currentStage = (Stage) confirmAction.getScene().getWindow();
				currentStage.close();

				Stage newStage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("stage1.fxml"));
				Parent root = loader.load();
				Scene scene = new Scene(root);

				newStage.setScene(scene);
				newStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
        } else if (result.get() == buttonTypeThree) {
            Platform.exit();
        } else {
            System.out.println("Cancel");
		}
	}
	
	/**
	 * This method opens a text input dialog.
	 */
	@FXML
	private void textInput(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog("walter");
		dialog.setTitle("Text Input Dialog");
		dialog.setHeaderText("Look, a Text Input Dialog");
		dialog.setContentText("Please enter your name:");

		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
//		if (result.isPresent()){
//		    System.out.println("Your name: " + result.get());
//		}

		// The Java 8 way to get the response value (with lambda expression).
		result.ifPresent(name -> System.out.println("Your name: " + name));
	}
	
	/**
	 * This method opens a custom login dialog and produces a key-value pair of the username and password.
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void customLogin(ActionEvent event) throws IOException {
		
		Dialog<Pair<String, String>> dialog = new Dialog<>();
		dialog.setTitle("Login Dialog");
		dialog.setHeaderText("Look, a Custom Login Dialog");
		
		// dialog.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));
		
		ButtonType loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
		
		// create the username and password lables and fields
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));
		
		TextField username = new TextField();
		username.setPromptText("Username");
		PasswordField password = new PasswordField();
		password.setPromptText("password");
		
		grid.add(new Label("Username:"), 0, 0);
		grid.add(username, 1, 0);
		grid.add(new Label("Password"), 0, 1);
		grid.add(password, 1, 1);
		
		// Enable/disable the login button depending on whether a username was entered
		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(true);
		
		// validation
		
		username.textProperty().addListener((v, oldValue, newValue) -> {
			loginButton.setDisable(newValue.trim().isEmpty());
		});
		
		dialog.getDialogPane().setContent(grid);
		
		//Request focus on the username field be default
		Platform.runLater(() -> username.requestFocus());
		
		// convert result to a username-password-pair when the login button is clicked
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				return new Pair<>(username.getText(), password.getText());
			}
			return null;
		});
		
		Optional<Pair<String, String>> result = dialog.showAndWait();
		
		result.ifPresent(usernamePassword -> {
			System.out.println("Username= " + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
		});
	}
	
	/**
	 * This method opens a choice dialog. It is similar to confirmation with action dialog,
	 * but the options are contained in a choice dialog box, rather than a confirmation dialog box.
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void choiceDialog(ActionEvent event) throws IOException {
		List<String> choices = new ArrayList<>();
		choices.add("stage 1");
		choices.add("stage 2");


		ChoiceDialog<String> dialog = new ChoiceDialog<>("Options", choices);
		dialog.setTitle("Choice Dialog");
		dialog.setHeaderText("Where would you like to go?");
		dialog.setContentText("stage:");

		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();
		result.ifPresent(choice -> {
			try {
				Stage currentStage = (Stage) choiceDialog.getScene().getWindow();
				currentStage.close();
				
				Stage newStage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource(choice.equals("stage 1") ? "stage1.fxml" : "stage2.fxml"));
				Parent root = loader.load();
				Scene scene = new Scene(root);
				
				newStage.setScene(scene);
				newStage.show();
			} catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		});
	}
}
