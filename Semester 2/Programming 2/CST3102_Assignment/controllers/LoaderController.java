package controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import models.MxQuestion;

public class LoaderController {
	
	public static List<MxQuestion> loadQuestionsFromFile(String directoryPath) {
		List<MxQuestion> questions = new ArrayList<>();
		
		try (Stream<Path> paths = Files.walk(Paths.get(directoryPath))) {
			paths.filter(Files::isRegularFile).forEach(file -> {
				MxQuestion question = parseQuestionFromFile(file);
				if (question != null) {
					Main.getMyQuestions().addQuestion(question);
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return questions;
	}

	
	public static MxQuestion parseQuestionFromFile(Path file) {
		try {
			List<String> lines = Files.readAllLines(file);
			if (lines.size() >= 10) { // Ensure the file has a right number of lines
				String courseInfo = lines.get(0);
				String questionType = lines.get(1);
				String question = lines.get(2);
				String optionA = lines.get(3);
				Boolean answerA = Boolean.parseBoolean(lines.get(4));
				String optionB = lines.get(5);
				Boolean answerB = Boolean.parseBoolean(lines.get(6));
				String optionC = lines.get(7);
				Boolean answerC = Boolean.parseBoolean(lines.get(8));
				String optionD = lines.get(9);
				Boolean answerD = Boolean.parseBoolean(lines.get(10));
				return new MxQuestion(courseInfo, questionType, question, optionA, answerA, optionB, answerB, optionC, answerC, optionD, answerD);
			}
		} catch (IOException e) {
			System.out.println("Error reading file: " + file);
            e.printStackTrace();
        }
			
		return null;
	}
	
}
				
	
	

		
		
	
	

		
	  