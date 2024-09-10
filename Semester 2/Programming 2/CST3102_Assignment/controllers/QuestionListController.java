package controllers;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import models.MyQuestionsCollection;
import models.Questions;
import models.Reader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * This controller class uses the questionList.fxml file to display a list of questions
 */
public class QuestionListController {
	
	/**
	 * This displays the list of questions in the users questions observable list.
	 * This was chosen due to the flexibility of the observable list and the ability to update the list in real time.
	 * The priority parameters needed for this collection was frequent insertions and deletions. Order was not a priority 
	 * as the course info is part of the object and can be used to identify the type of question.  
	 */
	private MyQuestionsCollection myQuestions;
	/** The table view for the questions */
	@FXML
	private TableView<Questions> questionList;
	
	// Columns for the table view
	
	/** Column for the course name */
	@FXML
	TableColumn<Questions, String> courseColumn = new TableColumn<>("Course");
	/** Column for the type of question */
	@FXML
	TableColumn<Questions, String> typeColumn = new TableColumn<>("Type");
	/** Column for the question */
	@FXML
	TableColumn<Questions, String> questionColumn = new TableColumn<>("Question");
	/** The scene for the questionList.fxml file */
	@FXML
	private Scene scene;
	/** Button to view all questions */
	@FXML
	private Button viewQuestions;
	/** Button to view all courses */
	@FXML
	private Button viewCourses;
	/** Button to add a question to question list*/
	@FXML
	private Button addQuestion;
	/** Button to remove a question */
	@FXML
	private Button removeQuestion;
	/** Button to add a course. */
	@FXML
	private Button addCourse;
	/** Button to remove course. Inactive on this page. NOTE** Will be erased pending redesign of GUI */
	@FXML
	private Button removeCourse;
	/** Button to write all questions to a file. Button is functional, but may be taken out in next iteration of GUI. */
	@FXML
	private Button startQuiz;
	
	
	/** This method will load the questionList.fxml */
	public void start(Stage homeStage) {
	    try {
			Main.loader("questionList.fxml");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** Loads the page for viewing the course list. */
	@FXML
	public void viewCourses(ActionEvent event) throws IOException {
		Main.loader("courseList.fxml");
	}
	
	/** Loads the page for adding a course. */
	@FXML
	public void addCourse(ActionEvent event) throws IOException {
		Main.loader("addCourse.fxml");
	}
	
	@FXML
	public void startQuiz(ActionEvent event) throws IOException {
		Main.loader("createQuiz.fxml");
	}
	
	/**
	 * Calls the method for loading the page that that adds a question. It give the user 2 options: write their own question or upload a file.
	 * Currently, upload file works, but it will upload any question as a multiple choice question and make the entire the question
	 * the body of the question. 
	 */
	
	/*
	 * Notes for further development: Change the upload feature so that it correctly inputs the file as a question object, with the 
	 * options and answers going into the appropriate fields. Most likely implementing serialization and deserialization. 
     */
	@FXML
	private void addQuestion(ActionEvent event) throws IOException {
		ValidateUtility.addQuestionMethod("questionPage.fxml");
	}
	
	/**
	 * Removes a question from the question list. User selects a question from the list and clicks the remove button.
	 * Error message will display if no question is selected.
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void removeQuestion(ActionEvent event) throws IOException {
		MyQuestionsCollection courseList = Main.getMyQuestions();
		
		// Get the selected course from the table view
		Questions selectedQuestion = questionList.getSelectionModel().getSelectedItem();
		
		if (selectedQuestion != null) {
			courseList.removeQuestion(selectedQuestion);
			courseList.getQuestions().remove(selectedQuestion);
		} else {
			// Error messsage in case you can't remove course
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Please select a course to remove.");
			alert.showAndWait();
		}
	}
	
	

	
	/** Initialize the list of questions and courses. This is done so that if the user visits this page before the courseList page, 
	 * the course list is still initialized.
	 */
	@FXML
	public void initialize() {
		
		Main.getCourseList().setDefault();
		Main.getCourseList();
		
		
		// Initialize 
		myQuestions = Main.getMyQuestions();
		
		questionList.setItems(myQuestions.getQuestions());
		
		// course name column
		courseColumn.setCellValueFactory(new PropertyValueFactory<>("courseInfo"));
		// question type column
		typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
		// program name column
		questionColumn.setCellValueFactory(new PropertyValueFactory<>("body"));
		
		questionList.setRowFactory(tv -> {
			TableRow<Questions> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (!row.isEmpty())) {
                   Questions rowData = row.getItem();
                   Main.loaderWithQuestion("modifyQuestion.fxml", rowData);
				}
			});
		return row;
		});
	}

	
}