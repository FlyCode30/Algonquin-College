package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
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

	// FXML variables for the courseList.fxml file 
	
	/** Scene for the courseList.fxml file */
	@FXML
	private Scene scene;
	/** Table view for displaying the list of courses */
	@FXML
	private Button addQuestion;
	@FXML
	private Button removeQuestion;
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
	
	/** TableListCourseInfo object used for the list of courses */
	private TableListCourseInfo courseList;
	
    /** 
     * Loads the page for displaying the list of courses
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
	 * Loads the page for adding a question to the Question List.
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void addQuestion(ActionEvent event) throws IOException {
		Main.addQuestion("questionPage.fxml");
	}
	
	/**
	 * Loads the page for viewing the Question List.
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void viewQuestions(ActionEvent event) throws IOException {
		Main.loader("questionList.fxml");
	}
	
	/**
	 * Loads the page for adding a course to the Course List.
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void goToAddCoursePage(ActionEvent event) throws IOException {
		Main.loader("addCourse.fxml");
	}


	/**
	 * this method will initialize the Course List Page
	 * A default course is added for new users. 
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

	@FXML
	public void removeCourseByName(ActionEvent event) throws IOException {
		TableListCourseInfo courseList = Main.getCourseList();
		
		// Get the selected course from the table view
		CourseInfo selectedCourse = courseTable.getSelectionModel().getSelectedItem();
		
		if (selectedCourse != null) {
			courseList.removeCourse(selectedCourse);
			courseTable.getItems().remove(selectedCourse);
		} else {
			// Error messsage in case you can't remove course
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Please select a course to remove.");
			alert.showAndWait();
		}
	}
	
	/* Notes for future implementation: We would also include additional code that would check for existing directories
	 * and load them into the Course List here. We were not able to do that at this time. 
	 * 
	 */
	
}