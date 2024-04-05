package controllers;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
 * This controller class is primarily meant to display the list of courses in the Course List.
 */
public class CourseListController {

	// FXML variables for the courseList.fxml file 
	
	/** Scene for the courseList.fxml file */
	@FXML
	private Scene scene;
	/** Table for displaying the list of courses */
	@FXML
	private TableView<CourseInfo> courseTable;
	/** Button for adding a course */
	@FXML
	private Button addCourse;
	/** BUtton for viewing questions */
	@FXML
	private Button viewQuestions;
	/** Button for adding a question */
	@FXML
	private Button addQuestion;
	/** Button for removingQuestion. NOTE** This button is inactive. Will be adjusted following GUI redesign. */
	@FXML
	private Button removeQuestion;

	
	
	// Columns for the table view 
	
	/** Course name column for course list */
	@FXML
	private TableColumn<CourseInfo, String> courseNameColumn = new TableColumn<>("Course Name");
	/** Program name column for course list */
	@FXML
	private TableColumn<CourseInfo, String> programNameColumn = new TableColumn<>("Program Name");
	/** Program year column for course list */
	@FXML
	private TableColumn<CourseInfo, Integer> programYearColumn = new TableColumn<>("Program Year");
	/** Program semester column for course list */
	@FXML
	private TableColumn<CourseInfo, String> programSemesterColumn = new TableColumn<>("Program Semester");
	
	
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
	 * Initializes the Course List Page by setting the table properties, populating the course list, and 
	 * adding a default course for the user in case the course list is empty.
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
	
	/**
	 * Loads the page for adding a question to the Question List.
	 * 
	 * @param event clicking addQuestionButton
	 * @throws IOException
	 */
	@FXML
	public void addQuestion(ActionEvent event) throws IOException {
		Main.addQuestion("questionPage.fxml");
	}
	
	/**
	 * Loads the page for viewing the Question List.
	 * 
	 * @param event clicking viewQuestions
	 * @throws IOException
	 */
	@FXML
	public void viewQuestions(ActionEvent event) throws IOException {
		Main.loader("questionList.fxml");
	}
	
	/**
	 * Loads the page for adding a course to the Course List.
	 * 
	 * @param event clicking addCourse
	 * @throws IOException
	 */
	@FXML
	public void goToAddCoursePage(ActionEvent event) throws IOException {
		Main.loader("addCourse.fxml");
	}

	/**
	 * Removes a course from the Course List.
	 * 
	 * @param event clicking removeCourse Button. 
	 * @throws IOException
	 */
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
	
	/** Returns course list as a string */
	
	public static ObservableList<String> getCourseInfoString() {
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

	
}