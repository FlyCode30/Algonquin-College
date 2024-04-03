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
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import models.CourseInfo;
import models.FillQuestion;
import models.MxQuestion;
import models.MyQuestionsCollection;
import models.Questions;
import models.ShortQuestion;
import models.TorFQuestion;

/**
 * This controller class allows users to add questions to the Question List.
 */

public class ModifyQuestionController {
	
	// FXML variables for the questionPage.fxml file
	
	/** Button to add a question */
	@FXML
	private Button saveQuestion;
	/** Button to return to the question list */
	@FXML
	private Button deleteQuestion;
	@FXML
	private Button returnToQuestionList;
	/** ComboBox for selecting the course */
	@FXML
	private TextField courseInfo;
	/** ComboBox for selecting the question type */
	@FXML
	private ComboBox<String> questionType;
	/** Text field for entering the question */
	@FXML
	private TextField questionField;
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
    
    private Questions currentQuestion;
    
	
	/**
	 * Loads the Question List Page.
	 * 
	 * @param stage
	 * @throws Exception
	 */
	public void start (Stage stage) throws Exception{
        Main.loader("modifyQuestion.fxml");
	}
	
	public void removeQuestion(ActionEvent event) throws IOException {
		Main.getMyQuestions().removeQuestion(currentQuestion);
		Main.loader("questionList.fxml");
	}
	
	/**
	 * This method will set the question to be modified
	 */
	
	public void setQuestion(Questions question) {
		this.currentQuestion = question;
		if (question instanceof MxQuestion)  {
			courseInfo.setText(question.getCourseInfo());
			questionType.setValue("MC");
			questionField.setText(question.getBody());
			optionA.setText(((MxQuestion) question).getOptionA());
			optionB.setText(((MxQuestion) question).getOptionB());
			optionC.setText(((MxQuestion) question).getOptionC());
			optionD.setText(((MxQuestion) question).getOptionD());
			answerA.setSelected(((MxQuestion) question).getAnswerA());
			answerB.setSelected(((MxQuestion) question).getAnswerB());
			answerC.setSelected(((MxQuestion) question).getAnswerC());
			answerD.setSelected(((MxQuestion) question).getAnswerD());
		} else if (question instanceof TorFQuestion) {
            courseInfo.setText(question.getCourseInfo());
            questionType.setValue("T/F");
            questionField.setText(question.getBody());
            optionA.setText("True");
            optionB.setText("False");
            answerA.setSelected(((TorFQuestion) question).getAnswerA());
            answerB.setSelected(((TorFQuestion) question).getAnswerB());
            optionC.setDisable(true);
            optionD.setDisable(true);
            answerC.setDisable(true);
            answerD.setDisable(true);
        } else if (question instanceof FillQuestion) {
            courseInfo.setText(question.getCourseInfo());
            questionType.setValue("Fill");
            questionField.setText(question.getBody());
            optionA.setText(((FillQuestion) question).getOptionA());
            optionB.setText(((FillQuestion) question).getOptionB());
            optionC.setText(((FillQuestion) question).getOptionC());
            optionD.setText(((FillQuestion) question).getOptionD());
            answerA.setDisable(true);
            answerB.setDisable(true);
            answerC.setDisable(true);
            answerD.setDisable(true);
        } else if (question instanceof ShortQuestion) {
            courseInfo.setText(question.getCourseInfo());
            questionType.setValue("Short");
            questionField.setText(question.getBody());
            optionA.setText(((ShortQuestion) question).getOptionA());
            optionB.setDisable(true);
            optionC.setDisable(true);
            optionD.setDisable(true);
            answerA.setDisable(true);
            answerB.setDisable(true);
            answerC.setDisable(true);
            answerD.setDisable(true);
        } else if (!(question instanceof Questions)) {
        	questionField.setText(question.getBody());
        }
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
//	@FXML
//	public void addQuestion(ActionEvent event) throws IOException {
//		// if user selected multiple choice question type then add a multiple choice question to the myQuestions object
//		if (
//	}
	
	
	/**
	 * Initializes the Add Question Page by setting the items for the courseList and questionType ComboBoxes.
	 * Also initializes the settings for the interface based on the question type selected.
	 */
	
	@SuppressWarnings("unlikely-arg-type")
	/*
	 * Notes for future improvements: Currently, this method adjusts the interface by adjusting each individual element.
	 * Future improvements would put this into a css file and the method would call a style sheet to adjust the interface.
	 */
	@FXML
	public void initialize() {
//		courseList.setItems(getCourseInfo());
		questionType.setItems(FXCollections.observableArrayList("MC", "T/F", "Fill", "Short", "Other"));
		
//		
//		questionType.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
			
			if (questionType.equals("MC") || questionType.equals("Other")) {
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
			} else if (questionType.equals("T/F")) {
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
			} else if (questionType.equals("Fill")) {
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
			} else if (questionType.equals("Short")) {
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
	}
	
	/**
	 * This method will return the list of programs from the courseList objects.
	 * @return
	 */
	
//	public ObservableList<String> getCourseInfo() {
//		ObservableList<String> courses = FXCollections.observableArrayList();
//		ObservableList<CourseInfo> courseList = Main.getCourseList().getCourseInfo();
//		for (CourseInfo course : courseList) {
//			String courseName = course.getProgramName();
//			if (!courses.contains(courseName)) {
//				courses.add(courseName);
//			}
//		}
//		return courses;
//	}


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
//	public void writeToFile(Questions questions) {
//		
//		LocalDateTime now = LocalDateTime.now();
//	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
//	    String timestamp = now.format(formatter);
//	
//		String course = questions.getCourseInfo();
//		
//	    String fileName = course + "_Q-" +timestamp + ".txt";
//	    String filePath = "E:\\My ToolBox\\7 Projects\\Learning\\Resources & Notes\\Algonquin B.Tech\\AC B.Tech 2023\\Semester 2\\Programming\\Assignments\\AssignmentQuestions\\" + fileName;
//		    
//	    Task<Void> task = new Task<Void>() {
//	        @Override
//	        protected Void call() throws Exception {
//	            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
//	                writer.write(questions.toString());
//	            } catch (IOException e) {
//	                e.printStackTrace();
//	            }
//	            return null;
//	        }
//	    };
//	    new Thread(task).start();
//	}
	
}

