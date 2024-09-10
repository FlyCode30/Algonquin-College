package application;
import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** 
 * This class is the main class for the application. It is responsible for launching the application and setting up stage1.
 */
public class TwoStageApp extends Application {
	
	/**
	 * This method sets up the first stage of the application.
	 */
    @Override
    public void start(Stage primaryStage) {
        // First stage
    	Parent p1;
		try {
			p1 = FXMLLoader.load(getClass().getResource("stage1.fxml"));
	    	Scene s1=new Scene(p1);
	        primaryStage.setScene(s1);
	        primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
	 * This method launches the application.
	 */
    public static void main(String[] args) {
        launch(args);
    }
}
