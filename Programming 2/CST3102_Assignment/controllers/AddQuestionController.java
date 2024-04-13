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

public class AddQuestionController implements ValidateUtility{
	
	// FXML variables for the questionPage.fxml file
	
	/** Button to add a question */
	@FXML
	private Button addQuestionButton;
	/** Button to return to the question list */
	@FXML
	private Button returnToQuestionList;
	/** ComboBox for selecting the course */
	@FXML
	private ComboBox<String> courseList;
	/** ComboBox for selecting the question type */
	@FXML
	private ComboBox<String> questionType;
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


    
	
	/** Loads the Question List Page. */
	public void start (Stage stage) throws Exception{
        Main.loader("questionPage.fxml");
	}
	
	/** Returns to the question list page */

	public void returnToQuestionList(ActionEvent event) {
		Main.loader("questionList.fxml");
	}
	
	/**
	 * This method will add a question to the questions list. 
	 * It will also write the question to a file using the writeToFile method, and then return the user to the 
	 * question list page.
	 * 
	 * @param event
	 * @throws IOException
	 */
	
	/* NOTES** There are no try-catch blocks for the file writing method. This would be added to the writeToFile method
	 * to check for fields left blank or other errors. It would prompt the user to enter the missing information. Currently,
	 * similar functionality exists by adjusting the interface based on the question type selected, forcing the user to only 
	 * enter the necessary information for the question type selected. 
	 */
	@FXML
	public void addQuestionButton(ActionEvent event) throws IOException {
		if (!ValidateUtility.validateQuestionInput(courseList, questionType, questionField)) {
			ValidateUtility.confirmAction();
		} else {
			ValidateUtility.addQuestion(courseList, questionType, questionField, optionA, answerA, optionB, answerB, optionC, answerC, optionD, answerD);
		}
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
		courseList.setItems(CourseListController.getCourseInfoString());
		questionType.setItems(FXCollections.observableArrayList("MC", "T/F", "Fill", "Short"));
		
		questionType.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
			
			if (newValue.equals("MC")) {
				optionA.setFont(Font.getDefault());
				optionA.setEditable(true);
				optionA.setText(null);
				answerA.setDisable(false);
				optionB.setFont(Font.getDefault());
				optionB.setText(null);
				optionB.setEditable(true);
				optionB.setDisable(false);
				answerB.setDisable(false);
				optionC.setDisable(false);
				optionC.setEditable(true);
				answerC.setDisable(false);
				optionD.setDisable(false);
				optionD.setEditable(true);
				answerD.setDisable(false);
			} else if (newValue.equals("T/F")) {
				optionA.setFont(Font.font("System", FontWeight.BOLD , 20));
				optionA.setText("True");
				optionA.setDisable(false);
				optionA.setEditable(false);
				answerA.setDisable(false);
				optionB.setFont(Font.font("System", FontWeight.BOLD , 20));
				optionB.setText(null);
				optionB.setText("False");
				optionB.setEditable(false);
				optionB.setDisable(false);
				answerB.setDisable(false);
				optionC.setDisable(true);
				optionC.setEditable(false);
				answerC.setDisable(true);
				optionD.setDisable(true);
				optionD.setEditable(false);
				answerD.setDisable(true);
			} else if (newValue.equals("Fill")) {
				optionA.setFont(Font.getDefault());
				optionA.setText(null);
				optionA.setEditable(true);
				answerA.setDisable(true);
				optionB.setFont(Font.getDefault());
				optionB.setText(null);
				optionB.setEditable(true);
				optionB.setDisable(false);
				answerB.setDisable(true);
				optionC.setDisable(false);
				optionC.setEditable(true);
				answerC.setDisable(true);
				optionD.setDisable(false);
				optionD.setEditable(true);
				answerD.setDisable(true);
			} else if (newValue.equals("Short")) {
				optionA.setFont(Font.getDefault());
				optionA.setText(null);
				optionA.setEditable(true);
				answerA.setDisable(true);
				optionB.setFont(Font.getDefault());
				optionB.setText(null);
				optionB.setEditable(false);
				optionB.setDisable(true);
				answerB.setDisable(true);
				optionC.setDisable(true);
				optionC.setEditable(false);
				answerC.setDisable(true);
				optionD.setDisable(true);
				optionD.setEditable(false);
				answerD.setDisable(true);
			}
		});
	}
	
		
}
	


