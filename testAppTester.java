package testApp;

import java.io.Reader;

public class testAppTester {

	public static void main(String[] args)	{
		
		// create a new MyQuestionsCollection object
		MyQuestionsCollection myQuestions = new MyQuestionsCollection();

		// create a new CourseInfo object
		CourseInfo courseInfo = new CourseInfo("Computer Science", 2018, "Fall", "CSC 102");

		// create a new FillQuestion object
		FillQuestion fillQuestion = new FillQuestion(courseInfo.toString(), "What is the capital of Canada?", "Ottawa",
				"Toronto", "Montreal", "Vancouver");

		// create a new ShortQuestion object
		ShortQuestion shortQuestion = new ShortQuestion(courseInfo.toString(), "What is the capital of Canada?",
				"Ottawa");
		
		// create a multiple choice question
		MxQuestion mx = new MxQuestion("Geography", "What is the capital of France?", "Paris", true, "London", false, "Berlin", false, "Madrid", false);

		// add the fillQuestion and shortQuestion to the myQuestions object
		myQuestions.addQuestion(fillQuestion);
		myQuestions.addQuestion(shortQuestion);
		myQuestions.addQuestion(mx);

		// print the questions in the myQuestions object
		//System.out.println(myQuestions.getQuestions());
		
		// testing toString for MxQuestion
		//System.out.println(mx.toString());
		
		// testing reader class
		
		
	}
}