package javaFxControllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import testApp.CourseInfo;

/**
 * This controller class uses the addCourse.fxml file to add a course to the courseList
 */
public class addCourseController {
	
	
	@FXML
	private Scene scene;
	@FXML
	private TextField courseName;
	@FXML
	private TextField programName;
	@FXML
	private TextField programYear;
	@FXML
	private TextField semester;
	@FXML
	private Button addCourseButton;
	
    // this method will load the addCourse.fxml
	public void start(Stage homeStage) {
	    try {
	    	Main.loader("addCourse.fxml");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void returnToCourseList(ActionEvent event) throws IOException{
       Main.loader("courseList.fxml");
	}
	
	// this method will add a course to the courseList.fxml based on the inputs in text fields
	@FXML
	public void addCourse(ActionEvent event) throws IOException {
		CourseInfo course = new CourseInfo(programName.getText(), Integer.parseInt(programYear.getText()), semester.getText(), courseName.getText());
		Main.getCourseList().addCourse(course);
		returnToCourseList(event);
	}
}

