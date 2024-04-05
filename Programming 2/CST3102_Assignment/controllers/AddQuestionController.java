package controllers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import models.CourseInfo;
import models.FillQuestion;
import models.MxQuestion;
import models.Questions;
import models.ShortQuestion;
import models.TorFQuestion;

/**
 * This controller class allows users to add questions to the Question List.
 */

public class AddQuestionController {
	
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
	private TextArea question;
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
	/** CheckBox for selecting answer A */
	@FXML
	private CheckBox answerA;
	/** CheckBox for selecting answer B */
    @FXML
    private CheckBox answerB;
    /** CheckBox for selecting answer C */
    @FXML
    private CheckBox answerC;
    /** CheckBox for selecting answer D */
    @FXML
    private CheckBox answerD;
    
	
	/**
	 * Loads the Question List Page.
	 * 
	 * @param stage
	 * @throws Exception
	 */
	public void start (Stage stage) throws Exception{
        Main.loader("questionPage.fxml");
	}
	
	/**
	 * This method will return to the question list page
	 * 
	 * @param event
	 */
	public void returnToQuestionList(ActionEvent event) {
		Main.loader("questionList.fxml");
	}
	
	/**
	 * This method will add a question to the myQuestions collection. 
	 * It will also write the question to a file using the writeToFile method, and then return the user to the 
	 * question list page.
	 * 
	 * @param event
	 * @throws IOException
	 */
	
	/* Notes for future improvements: A choice dialog box or separate button could be included so that a user could 
	 * add a new question and stay on the same page, or add a new question and return to the question list page.
	 * 
	 * Also, there are no try-catch blocks for the file writing method. This would be added to the writeToFile method
	 * to check for fields left blank or other errors. It would prompt the user to enter the missing information. 
	 */
	@FXML
	public void addQuestion(ActionEvent event) throws IOException {
		// if user selected multiple choice question type then add a multiple choice question to the myQuestions object
		if (questionType.getValue().equals("MC")) {
			MxQuestion mxQuestion = new MxQuestion(courseList.getValue(), questionType.getValue(), question.getText(), optionA.getText(),
					answerA.isSelected(), optionB.getText(), answerB.isSelected(), optionC.getText(), answerC.isSelected(), optionD.getText(), answerD.isSelected());
			// add the question to the myQuestions object
			Main.getMyQuestions().addQuestion(mxQuestion);
			// write the question to a file
			writeToFile(mxQuestion);
			// return to the question list page
			returnToQuestionList(event);
		} else if (questionType.getValue().equals("Fill")) {
			FillQuestion fillQuestion = new FillQuestion(courseList.getValue(), questionType.getValue(), question.getText(), optionA.getText(), optionB.getText(), optionC.getText(), optionD.getText());
			Main.getMyQuestions().addQuestion(fillQuestion);
			writeToFile(fillQuestion);
			returnToQuestionList(event);
		} else if (questionType.getValue().equals("T/F")) {
			TorFQuestion torfQuestion = new TorFQuestion (courseList.getValue(), questionType.getValue(), question.getText(), optionA.getText(), answerA.isSelected(), optionB.getText(), answerB.isSelected());
			Main.getMyQuestions().addQuestion(torfQuestion);
			writeToFile(torfQuestion);
			returnToQuestionList(event);
		} else if(questionType.getValue().equals("Short")) {
            ShortQuestion shortAnswerQuestion = new ShortQuestion(courseList.getValue(), questionType.getValue(), question.getText(), optionA.getText());
            Main.getMyQuestions().addQuestion(shortAnswerQuestion);
            writeToFile(shortAnswerQuestion);
            returnToQuestionList(event);
        } else if (questionType.getValue() == null) {
        	returnToQuestionList(event);
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
		courseList.setItems(getCourseInfo());
		questionType.setItems(FXCollections.observableArrayList("MC", "T/F", "Fill", "Short"));
		
		questionType.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
			
			if (newValue.equals("MC")) {
				optionA.setFont(Font.getDefault());
				optionA.setEditable(true);
				answerA.setDisable(false);
				optionB.setFont(Font.getDefault());
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
				optionA.setEditable(true);
				answerA.setDisable(true);
				optionB.setFont(Font.getDefault());
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
				optionA.setEditable(true);
				answerA.setDisable(true);
				optionB.setFont(Font.getDefault());
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
	
	/**
	 * This method will return the list of programs from the courseList objects.
	 * @return
	 */
	
	public ObservableList<String> getCourseInfo() {
		ObservableList<String> courses = FXCollections.observableArrayList();
		ObservableList<CourseInfo> courseList = Main.getCourseList().getCourseInfo();
		for (CourseInfo course : courseList) {
			String courseName = course.getProgramName();
			if (!courses.contains(courseName)) {
				courses.add(courseName);
			}
		}
		return courses;
	}


	/**
	 * This method writes a question to a text file. 
	 * It uses the course name to indicate the course the question is associated with, and a timestamp
	 * to create a unique ID for the file name
	 * 
	 * @param this method takes a type of question object as a parameter.
	 */
	
	/* 
	 * Notes for future improvements: We would find a way to change the unique ID to a more user-friendly format, like 
	 * Question1, Question2, etc. Or, we would use a directory chooser to allow the user to select the location to save
	 * and name the file themselves. 
	 * 
	 * Also, we would save the file in an xml format to allow for easier reading and writing of the question,
	 * or save the question in a database. 
	 */
	public void writeToFile(Questions questions) {
		
		LocalDateTime now = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	    String timestamp = now.format(formatter);
	
		String course = questions.getCourseInfo();
		
	    String fileName = course + "_Q-" +timestamp + ".txt";
	    String filePath = "E:\\My ToolBox\\7 Projects\\Learning\\Resources & Notes\\Algonquin B.Tech\\AC B.Tech 2023\\Semester 2\\Programming\\Assignments\\AssignmentQuestions\\" + fileName;
		    
	    Task<Void> task = new Task<Void>() {
	        @Override
	        protected Void call() throws Exception {
	            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
	                writer.write(questions.toString());
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            return null;
	        }
	    };
	    new Thread(task).start();
	}
	

}

