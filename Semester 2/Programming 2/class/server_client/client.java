package client_server_javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class client extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		// Load and show the client scene
		Parent root1 = FXMLLoader.load(getClass().getResource("simple_client.fxml"));
		primaryStage.setTitle("Simple Client");
		primaryStage.setScene(new Scene(root1, 400, 400));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
