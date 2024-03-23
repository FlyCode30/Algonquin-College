/* changes from last version
 * - updated some documentation
 * - tried storing the questions in an observable list. The model for this is contained in the TableListCourseInfo class
 * - cousreListController has an initialize method that creates the table view, some columns and calls the default method, which adds a course if the list is empty
 * - attempted to update the addCourseController class so that a user can input information for a new course, click the add Course button, and the course will be added to the courseList.fxml 
 *   as well as return them to the courseList.fxml page. I can't get the button to return to courseList.fxml, but i can't add a course to the list.
 */


package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import models.MyQuestionsCollection;
import models.TableListCourseInfo;



public class Main extends javafx.application.Application{
	
	@FXML
	private static Stage primaryStage;
	@FXML
	private Scene scene;
	@FXML
	private Button coursePage;
	@FXML
	private Button questionPage;
	@FXML
	private Button quizPage;
	private static final TableListCourseInfo courseList = new TableListCourseInfo();
	private static final MyQuestionsCollection myQuestions = new MyQuestionsCollection();
	
	public void start(Stage stage) {
	    try {
			primaryStage = stage;
			loader("Main.fxml");
			primaryStage.setTitle("My Flashcards");
			primaryStage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static TableListCourseInfo getCourseList() {
		return courseList;
	}
	
	public static MyQuestionsCollection getMyQuestions() {
		return myQuestions;
	}
	
	/*
	 * This method will take the user to the questionList.fxml page
	 */
	@FXML
	public void goToQuestionPage(ActionEvent event) throws IOException {
		Main.loader("questionList.fxml");
	}
	
	/*
	 * This method will take the user to the courseList.fxml page
	 */
	public void goToCoursePage(ActionEvent event) throws IOException {
		Main.loader("courseList.fxml");
	}
	
	public static void main(String[] args) {
        launch(args);
    }
	
	/**
	 * This is a loader method that all other controller classes will use to load their respective fxml files
	 */
	public static void loader(String fxml) {
		try {
			Parent root = FXMLLoader.load(Main.class.getResource(fxml));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
