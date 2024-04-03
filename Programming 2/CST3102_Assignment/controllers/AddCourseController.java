package controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import models.CourseInfo;

/**
 * This controller class allows the user to add a course to the Course List.
 */
public class AddCourseController implements Initializable {
	
	// FXML variables for the addCourse.fxml file
	
	/** The scene. */
	@FXML
	private Scene scene;
	/** User Input for Course Name. */
	@FXML
	private TextField courseName;
	/** User Input for Program Name. */
	@FXML
	private TextField programName;
	/** ComboBox for user input or selecting from pre-made choices */
	@FXML
	private ComboBox<String> programYear;
	/** Pre-made choices for program year. */
	private String[] years = {"N/A", "1", "2", "3", "4", "5", "6", "7", "8"};
	/** User Input for Semester. */
	@FXML
	private TextField semester;
	/** Button to add course and return to courseList.fxml. */
	@FXML
	private Button addCourseButton;
	
    /* 
     * this method will load the addCourse.fxml
     */
	public void start(Stage homeStage) {
	    try {
	    	Main.loader("addCourse.fxml");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * this method will return the user to the course list page
     */
	@FXML
	public void returnToCourseList(ActionEvent event) throws IOException{
       Main.loader("courseList.fxml");
	}
	
	/*
	 * This method will add a course to the courseList.fxml based on the inputs in text fields. 
	 * The user will be prompted to select a directory to save the course files.
	 * If the directory does not exist, it will be created.
	 */
	@FXML
	public void addCourse(ActionEvent event) throws IOException {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		File selectedDirectory = directoryChooser.showDialog(null);
		
		if (selectedDirectory != null) {
			CourseInfo course = new CourseInfo(programName.getText(), programYear.getValue(), semester.getText(), courseName.getText());
			Main.getCourseList().addCourse(course);
	
			String folderName = course.toString();
			String directoryPath = selectedDirectory + "\\" + folderName;
		
			Path path = Paths.get(directoryPath);
			if (!Files.exists(path)) {
				try {
					Files.createDirectories(path);
					System.out.println("Directory created: " + path);
				} catch (IOException e) {
	                System.err.println("Failed to create directory!" + e.getMessage());
	            }
			} else {
				System.out.println("Directory already exists");
		}
			returnToCourseList(event);
		}
	}

	/*
	 * this method will initialize the programYear ComboBox with the pre-made
	 * choices
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		programYear.getItems().addAll(years);
    }
		
}
