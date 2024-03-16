package javaFxControllers;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import testApp.MyQuestionsCollection;
import testApp.Questions;

import java.awt.Button;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * This controller class uses the questionList.fxml file to display a list of
 * questions
 */
public class questionListController extends Application {

	private MyQuestionsCollection myQuestions;
	@FXML
	private TableView<Questions> questionList;
	@FXML
	TableColumn<Questions, String> courseColumn = new TableColumn<>("Course");
	@FXML
	TableColumn<Questions, String> questionColumn = new TableColumn<>("Question");
	@FXML
	private Scene scene;
	@FXML
	private Button viewCourses;
	@FXML
	private Button addQuestion;
	@FXML
	private Button addCourse;
	@FXML
	private Button refresh;
	

	@Override
	public void start(Stage homeStage) {
	    try {
			Main.loader("questionList.fxml");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will load the questionList.fxml
	 */
	@FXML
	public void addQuestion(ActionEvent event) throws IOException {
		Main.loader("questionPage.fxml");
	}
	
	/**
	 * This method will load the addCourse.fxml
	 */
	@FXML
	public void addCourse(ActionEvent event) throws IOException {
		Main.loader("addCourse.fxml");
	}
	
	/**
	 * This method will load the courseList.fxml
	 */
	@FXML
	public void viewCourses(ActionEvent event) throws IOException {
		Main.loader("courseList.fxml");
	}
	
	/** Initialize the list of questions and courses (in case the user goes here first, instead of courseList.fxml)
	 * 
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
		// program name column
		questionColumn.setCellValueFactory(new PropertyValueFactory<>("body"));
	}
}
