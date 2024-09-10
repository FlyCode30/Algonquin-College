package client_server_javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import java.io.*;
import java.net.*;

public class SimpleServerController implements Runnable {
	@FXML
	private TextArea chatArea;
	@FXML
	private TextField messageField;
	@FXML
	private Button startButton;
	@FXML
	private Button stopButton;
	@FXML
	private Button sendButton;
	private ServerSocket serverSocket;
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;

	public void initialize() {
		try {
			serverSocket = new ServerSocket(9988);
		} catch (IOException e) {
			e.printStackTrace();
		}
		startButton.setDisable(false);
		stopButton.setDisable(true);
		chatArea.appendText("Click start to allow the server receive connections...\n");
	}

	@FXML
	void startServer(ActionEvent event) {
		try {
			socket = serverSocket.accept();
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			chatArea.appendText("Client connected!\n");
			startButton.setDisable(true);
			stopButton.setDisable(false);
			new Thread(this).start(); // Start the Runnable as a new thread
		} catch (IOException e) {
			showAlert("Could not start server!\n" + e.getMessage());
		}
	}

	@FXML
	void stopServer(ActionEvent event) {
		try {
			in.close();
			out.close();
			socket.close();
			serverSocket.close();
			startButton.setDisable(false);
			stopButton.setDisable(true);
		} catch (IOException e) {
			showAlert("Could not stop server!");
		}
	}

	@FXML
	void sendMessage(ActionEvent event) {

		String message = messageField.getText();
		try {
			out.writeUTF(message);
			chatArea.appendText("\nServer: " + message);
			messageField.setText("");
		} catch (IOException ex) {
			showAlert("Error sending message!");
		}
	}

	@Override
	public void run() {
		try {
			String message;
			while ((message = in.readUTF()) != null) {
				chatArea.appendText("\nClient: " + message);
			}
			in.close();
			out.close();
			socket.close();
			serverSocket.close();
			startButton.setDisable(false);
			stopButton.setDisable(true);
			chatArea.appendText("Conversation with client has ended!\n");
		} catch (IOException e) {
			Alert alert=new Alert(javafx.scene.control.Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Error receiving message!");
			alert.showAndWait();
		}
	}

	private void showAlert(String message) {
			javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText(message);
			alert.showAndWait();
	}}


