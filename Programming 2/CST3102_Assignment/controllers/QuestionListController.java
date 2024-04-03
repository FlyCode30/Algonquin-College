package controllers;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.MxQuestion;
import models.MyQuestionsCollection;
import models.Questions;
import models.Reader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * This controller class uses the questionList.fxml file to display a list of questions
 */
public class QuestionListController {
	
	/**
	 * This is the instnace of the MyQuestionsCollection this program uses. The collection is an observable list.
	 * This was chosen to the flexibility of the observable list and the ability to update the list in real time.
	 * The priority parameters needed for this collection was frequent insertions and deletions. Order was not a priority 
	 * as the course info is part of the object and can be used to identify the type of question.  
	 */
	private MyQuestionsCollection myQuestions;
	@FXML
	private TableView<Questions> questionList;
	@FXML
	TableColumn<Questions, String> courseColumn = new TableColumn<>("Course");
	@FXML
	TableColumn<Questions, String> typeColumn = new TableColumn<>("Type");
	@FXML
	TableColumn<Questions, String> questionColumn = new TableColumn<>("Question");
	@FXML
	private Scene scene;
	@FXML
	private Button allQuestions;
	@FXML
	private Button viewCourses;
	@FXML
	private Button addQuestion;
	@FXML
	private Button addCourse;
	@FXML
	private Button refresh;
	

	public void start(Stage homeStage) {
	    try {
			Main.loader("questionList.fxml");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will load the page for adding a course.
	 */
	@FXML
	public void addCourse(ActionEvent event) throws IOException {
		Main.loader("addCourse.fxml");
	}
	
	/**
	 * This method will load the page for adding a question. It give the user 2 options: write their own question or upload a file.
	 * Currently, upload file works, but it will upload any question as a multiple choice question and make the entire the question
	 * the body of the question. 
	 */
	
	/*
	 * Notes for further development: Change the upload feature so that it correctly inputs the file as a question object, with the 
	 * options and answers going into the appropriate fields.  
	 */
	@FXML
	private void addQuestion(ActionEvent event) throws IOException {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
		alert.setHeaderText("What would you like to do?");
		alert.setContentText("Are you ok with this?");
		
		// create the buttons
		ButtonType writeQuestion = new ButtonType("Write my own");
		ButtonType upLoadQuestion = new ButtonType("Upload a file");
		ButtonType cancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
		
		alert.getButtonTypes().setAll(writeQuestion, upLoadQuestion, cancel);
		
		// 4 different ways to handle the result
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == writeQuestion) {
		    Main.loader("questionPage.fxml");
		} else  if (result.get() == upLoadQuestion) {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
			File selectedFile = fileChooser.showOpenDialog(null);
     
			StringBuilder textBuilder = new StringBuilder();
		
			try {
				// reads each line from the file and append it to the StringBuilder
				Files.lines(Paths.get(selectedFile.getAbsolutePath())).forEach(line -> textBuilder.append(line));
				String text = textBuilder.toString();
				MxQuestion newQuestion = new MxQuestion("General", "MC", text, null, false, null, false, null, false, null, false);
				Main.getMyQuestions().addQuestion(newQuestion);
			}
			catch (IOException e) {
	            e.printStackTrace();
	        }
			
			
		}
	}
	
	
	/**
	 * This method will load the courseList.fxml
	 */
	@FXML
	public void viewCourses(ActionEvent event) throws IOException {
		Main.loader("courseList.fxml");
	}
	
	public void writeAllToFile() {
		
		LocalDateTime now = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	    String timestamp = now.format(formatter);
	
		String folderPath = "C:\\Users\\mikes\\Documents\\ProAssQuestions";
		String allMyQuestions = Reader.readStringFiles(folderPath, 5000);
		
		
	    String fileName = "MyQuestions_" + timestamp + ".txt";
	    String filePath = "C:\\Users\\mikes\\Documents\\ProAssQuestions\\" + fileName;
		    
	    Task<Void> task = new Task<Void>() {
	        @Override
	        protected Void call() throws Exception {
	            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
	                writer.write(allMyQuestions);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            return null;
	        }
	    };
	    new Thread(task).start();
	}
	
	/** Initialize the list of questions and courses. This is in case the user visits this page before the courseList page, 
	 * the courses are still added.
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