package controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * This controller class allows the user to add a course to the Course List.
 */
public class CreateQuizController {
	
	// FXML variables for the addCourse.fxml file
	
	/** The scene. */
	@FXML
	private Scene scene;
	/** User Input for Course Name. */
	@FXML
	private Label courseLabel;
	/** User Input for Program Name. */
	@FXML
	private Label numberQuestionsLabel;
	/** ComboBox for user input or selecting from pre-made choices */
	@FXML
	private ComboBox<String> courseInfo;
	@FXML
	private ComboBox<String> numberQuestions;
	private String[] numberOptions = {"5", "10", "15", "20", "25", "30"};
	@FXML
	private Button returnMyCourses;
	@FXML
	private Button returnMyQuestions;
	@FXML
	private Button startQuiz;
	
    /* 
     * this method will load the addCourse.fxml
     */
	public void start(Stage homeStage) {
	    try {
	    	Main.loader("createQuiz.fxml");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** initializes the scene. Populates program year and semester with pre-made choices */
	public void initialize() {
		courseInfo.setItems(CourseListController.getCourseInfoString());
		numberQuestions.getItems().addAll(numberOptions);
    }

	/** returns to course list */
	
	@FXML
	public void returnToCourseList(ActionEvent event) throws IOException{
       Main.loader("courseList.fxml");
	}
	
	@FXML
	public void returnMyQuestions(ActionEvent event) throws IOException {
		Main.loader("questionList.fxml");
	}
	

	
	

		
}
