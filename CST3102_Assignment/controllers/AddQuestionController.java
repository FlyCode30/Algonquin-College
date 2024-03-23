package controllers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
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

public class AddQuestionController {

	@FXML
	private Button addQuestionButton;
	@FXML
	private Button returnToQuestionList;
	@FXML
	private ComboBox<String> courseList;
	@FXML
	private ComboBox<String> questionType;
	@FXML
	private TextField question;
	@FXML
	private TextField optionA;
	@FXML
	private TextField optionB;
	@FXML
	private TextField optionC;
	@FXML
	private TextField optionD;
	@FXML
	private CheckBox answerA;
    @FXML
    private CheckBox answerB;
    @FXML
    private CheckBox answerC;
    @FXML
    private CheckBox answerD;
    
	
	
	public void start (Stage stage) throws Exception{
        Main.loader("addQuestion.fxml");
	}
	
	public void returnToQuestionList(ActionEvent event) {
		Main.loader("questionList.fxml");
	}
	
	/**
	 * This method will add a question to the myQuestions object. Each question type has a different set of parameters, 
	 * so this method will check the question type and add the appropriate question to the myQuestions object.
	 * The initialize method was setup to limit input options to ensure that only the necessary information is input for the type of question being added.
	 * 
	 * @param event
	 * @throws IOException
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
	 * This method will initialize the courseList ComboBox with the list of programs as well as the questionType ComboBox with the list of question types
	 * 
	 * This method allows users to select what type of question they want to add, and then changes the options and answers accordingly. This is done as a means to insure that 
	 * users only input the necessary information for the type of question they are adding, thereby reducing the chance of errors.
	 * 
	 * Yes, this is very long. Ideally we would put all this code into a css file, and then simply reference the css file in the fxml file.
	 * Until then, this probably has to stay
	 * 
	 */
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
				optionA.setFont(Font.font("True", FontWeight.BOLD , 20));
				optionA.setEditable(false);
				answerA.setDisable(false);
				optionB.setFont(Font.font("False", FontWeight.BOLD , 20));
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
	 * This method will return the list of programs from the courseList objects
	 * 
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
	 * This method will write the question to a file
	 * 
	 * @param content
	 */
	public void writeToFile(Questions questions) {
		
		LocalDateTime now = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	    String timestamp = now.format(formatter);
	
		String course = questions.getCourseInfo();
		
	    String fileName = course + "_Q-" +timestamp + ".txt";
	    String filePath = "C:\\Users\\mikes\\Documents\\ProAssQuestions\\" + fileName;
		    
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


