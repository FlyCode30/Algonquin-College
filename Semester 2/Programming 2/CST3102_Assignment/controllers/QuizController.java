package controllers;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * This controller class allows users to add questions to the Question List.
 */

public class QuizController {
	
	// FXML variables for the questionPage.fxml file
	

	/** Button to return to the question list */
	@FXML
	private Button returnToQuestionList;
	/** Text field for entering the question */
	@FXML
	private TextArea questionField;
	/** Text field for entering option A */
	@FXML
	private TextField optionA;
	/** Text field for entering option B */
	@FXML
	private TextField optionB;
	/** Text field for entering option C */	
	@FXML
	private TextField optionC;
	/** Text field for entering option D */	
	@FXML
	private TextField optionD;
	/** RadioButton for selecting answer */
	@FXML
	private RadioButton answerA, answerB, answerC, answerD;
	@FXML
	private Button nextQuestion;


    
	
	/** Loads the Question List Page. */
	public void start (Stage stage) throws Exception{
        Main.loader("quizPage.fxml");
	}
	
	/** Returns to the question list page */

	public void returnToQuestionList(ActionEvent event) {
		Main.loader("questionList.fxml");
	}
	

	
	/**
	 * Initializes the Add Question Page by setting the items for the courseList and questionType ComboBoxes.
	 * Also initializes the settings for the interface based on the question type selected.
	 */
	
	/*
	 * Notes for future improvements: Currently, this method adjusts the interface by adjusting each individual element.
	 * Future improvements would put this into a css file and the method would call a style sheet to adjust the interface.
	 */
	@FXML
	public void initialize() {
		
	}
}
	


