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

public class CourseListController {

	@FXML
	private Scene scene;
	@FXML
	private TableView<CourseInfo> courseTable;
	@FXML
	private TableColumn<CourseInfo, String> courseNameColumn = new TableColumn<>("Course Name");
	@FXML
	private TableColumn<CourseInfo, String> programNameColumn = new TableColumn<>("Program Name");
	@FXML
	private TableColumn<CourseInfo, Integer> programYearColumn = new TableColumn<>("Program Year");
	@FXML
	private TableColumn<CourseInfo, String> programSemesterColumn = new TableColumn<>("Program Semester");
	
	private TableListCourseInfo courseList;
	
    // this method will load the courseList.fxml
	@FXML
	public void start(Stage stage) {
		try {
			Main.loader("courseList.fxml");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void addQuestion(ActionEvent event) throws IOException {
		Main.loader("questionPage.fxml");
	}
	
	@FXML
	public void viewQuestions(ActionEvent event) throws IOException {
		Main.loader("questionList.fxml");
	}
	
	@FXML
	public void goToAddCoursePage(ActionEvent event) throws IOException {
		Main.loader("addCourse.fxml");
	}
	
	@FXML
	//method initializes the table view based on the parameters of the courseInfo objects in tableListCourseInfo
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
