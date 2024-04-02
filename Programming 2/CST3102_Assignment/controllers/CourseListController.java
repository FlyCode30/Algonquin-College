package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.CourseInfo;
import models.TableListCourseInfo;

/**
 * This controller class uses the courseList.fxml file to display the list of
 * courses in the courseList
 */
public class CourseListController {

	/** FXML variables for the courseList.fxml file */
	@FXML
	private Scene scene;
	/** Table view for displaying the list of courses */
	@FXML
	private TableView<CourseInfo> courseTable;
	// Columns for the table view 
	/** Column for course name */
	@FXML
	private TableColumn<CourseInfo, String> courseNameColumn = new TableColumn<>("Course Name");
	/** Column for program name */
	@FXML
	private TableColumn<CourseInfo, String> programNameColumn = new TableColumn<>("Program Name");
	/** Column for program year */
	@FXML
	private TableColumn<CourseInfo, Integer> programYearColumn = new TableColumn<>("Program Year");
	/** Column for program semester */
	@FXML
	private TableColumn<CourseInfo, String> programSemesterColumn = new TableColumn<>("Program Semester");
	
	/** TableListCourseInfo object for courseList */
	private TableListCourseInfo courseList;
	
    /** 
     * this method will load the courseList.fxml
     * @param stage for courseList.fxml
     */
	@FXML
	public void start(Stage stage) {
		try {
			Main.loader("courseList.fxml");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * this method will load the questionPage.fxml used to add a question
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void addQuestion(ActionEvent event) throws IOException {
		Main.loader("questionPage.fxml");
	}
	
	/**
	 * this method will load the questionList.fxml page
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void viewQuestions(ActionEvent event) throws IOException {
		Main.loader("questionList.fxml");
	}
	
	/**
	 * this method will load the scene for the addCourse.fxml page
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void goToAddCoursePage(ActionEvent event) throws IOException {
		Main.loader("addCourse.fxml");
	}
	
	/**
	 * this method will initialize the courseList.fxml page
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void initialize() {
	    
		Main.getCourseList().setDefault();
		courseList = Main.getCourseList();
		courseTable.setItems(courseList.getCourseInfo());
		
		
		// course name column
		courseNameColumn.setCellValueFactory(new PropertyValueFactory<>("courseName"));
		// program name column
		programNameColumn.setCellValueFactory(new PropertyValueFactory<>("programName"));
		// program year column
		programYearColumn.setCellValueFactory(new PropertyValueFactory<>("programYear"));
		// program semester column
		programSemesterColumn.setCellValueFactory(new PropertyValueFactory<>("semester"));

	}
	
}
