package controllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.stage.FileChooser;
import models.FillQuestion;
import models.MxQuestion;
import models.Questions;
import models.ShortQuestion;
import models.TorFQuestion;

public interface ValidateUtility {
	
	@FXML
	public static boolean validateQuestionInput(ComboBox<String> courseList, ComboBox<String> questionType, TextArea questionField) {
		
		if (courseList.getValue() == null || questionType.getValue() == null || questionField.getText().isEmpty()) {
			return false;
		}
		
		return true;
	}
	
	@FXML
	public static void addQuestion(ComboBox<String> courseList, ComboBox<String> questionType, TextArea questionField, 
			TextField optionA, RadioButton answerA, TextField optionB, RadioButton answerB, TextField optionC, RadioButton answerC, TextField optionD, RadioButton answerD) {

		if (questionType.getValue().equals("MC")) {
			MxQuestion mxQuestion = new MxQuestion(courseList.getValue(), questionType.getValue(), questionField.getText(), optionA.getText(),
					answerA.isSelected(), optionB.getText(), answerB.isSelected(), optionC.getText(), answerC.isSelected(), optionD.getText(), answerD.isSelected());
			writeQuestionToFile(mxQuestion);
		} else if (questionType.getValue().equals("Fill")) {
			FillQuestion fillQuestion = new FillQuestion(courseList.getValue(), questionType.getValue(), questionField.getText(), optionA.getText(), optionB.getText(), optionC.getText(), optionD.getText());
			writeQuestionToFile(fillQuestion);
		} else if (questionType.getValue().equals("T/F")) {
			TorFQuestion torfQuestion = new TorFQuestion (courseList.getValue(), questionType.getValue(), questionField.getText(), optionA.getText(), answerA.isSelected(), optionB.getText(), answerB.isSelected());
			writeQuestionToFile(torfQuestion);
		} else if(questionType.getValue().equals("Short")) {
            ShortQuestion shortAnswerQuestion = new ShortQuestion(courseList.getValue(), questionType.getValue(), questionField.getText(), optionA.getText());
            writeQuestionToFile(shortAnswerQuestion);
		}
	}

	
	public static void writeQuestionToFile(Questions questions) {
		
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save Question");
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		File selectedFile = fileChooser.showSaveDialog(null);
	
		if (selectedFile!=null) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile + ".txt"))) {
				writer.write(questions.toString());
				Main.getMyQuestions().addQuestion(questions);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Main.loader("questionList.fxml");
		}
		}
	
	// confirmation action button
	@FXML
	public static void confirmAction() throws IOException {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
		alert.setHeaderText("You are missing some important information");
		alert.setContentText("Do you want to head back to Question Page or keep working on this question");
		
		// create buttons
		ButtonType btn1 = new ButtonType("Question Page");
		ButtonType btn2 = new ButtonType("Continue with Question");
		
		alert.getButtonTypes().setAll(btn1, btn2);
		
		// different options
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == btn1) {
			Main.loader("questionList.fxml");
		} else if (result.get() == btn2) { }
	}
	
	/**
	 * A loader method that will prompt the user to indicate whether they would like to add a question by writing their own or uploading a file.
	 * If the user selects "write my own", the program will load the fxml file passed as a parameter.
	 * If the user wants to upload their own file, it will store the entire file as a string in the body of a multiple choice question, under general courses, 
	 * regardless of the question type of the original file. NOTES FOR FUTURE: This is a temporary solution meant to test the functionality of the file upload feature.
	 * Ideally, the program would be able to parse the file and determine the question type, course, etc., and data into the appropriate fields.
	 * 
	 * @param fxml   file to be loaded
	 */
	public static void addQuestionMethod(String fxml) throws IOException{
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
		    Main.loader(fxml);
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
	
}

