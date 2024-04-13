package client_server_javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import java.io.*;
import java.net.*;

public class SimpleClientController implements Runnable {
	@FXML
	private TextArea chatArea;
	@FXML
	private TextField textField;
	@FXML
	private Button sendButton;
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;

	public void initialize() {
		try {
			socket = new Socket("localhost", 9988);
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			new Thread(this).start(); // Start the Runnable as a new thread
		} catch (IOException e) {
			showAlert("Could not connect to server!");
		}
	}

	@FXML
	void sendMessage(ActionEvent event) {
		try {
			String message = textField.getText();
			out.writeUTF(message + "\n");
			chatArea.appendText("\nClient: " + message);
			textField.setText("");
		} catch (IOException e) {
			showAlert("Error sending message!");
		}
	}

	@Override
	public void run() {
		try {
			String message;
			while ((message = in.readUTF()) != null) {
				chatArea.appendText("\nServer: " + message);
			}
		} catch (IOException e) {
			showAlert("Error receiving message!");
		}
	}
	private void showAlert(String message) {
			javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText(message);
			alert.showAndWait();
	}
}


