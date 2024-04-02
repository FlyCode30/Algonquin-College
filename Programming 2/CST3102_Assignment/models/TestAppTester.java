package models;

public class TestAppTester {

	public static void main(String[] args)	{
		
		// create a new MyQuestionsCollection object
		MyQuestionsCollection myQuestions = new MyQuestionsCollection();

		// create a new CourseInfo object
		CourseInfo courseInfo = new CourseInfo("Computer Science", "2018", "Fall", "CSC 102");

		// create a new FillQuestion object
		FillQuestion fillQuestion = new FillQuestion(courseInfo.toString(), "Fill", "What is the capital of Canada?", "Ottawa",
				"Toronto", "Montreal", "Vancouver");

		// create a new ShortQuestion object
		ShortQuestion shortQuestion = new ShortQuestion(courseInfo.toString(), "Short", "What is the capital of Canada?",
				"Ottawa");
		
		// create a multiple choice question
		MxQuestion mx = new MxQuestion("Geography", "MC", "What is the capital of France?", "Paris", true, "London", false, "Berlin", false, "Madrid", false);
		
		System.out.println(mx.getCourseInfo());

		// add the fillQuestion and shortQuestion to the myQuestions object
		myQuestions.addQuestion(fillQuestion);
		myQuestions.addQuestion(shortQuestion);
		myQuestions.addQuestion(mx);

		// print the questions in the myQuestions object
		//System.out.println(myQuestions.getQuestions());
		
		// testing toString for MxQuestion
		//System.out.println(mx.toString());
		
		// testing reader class
		
//		// create a new Reader object
//		String folderpath = "C:\\Users\\mikes\\Documents\\ProAssQuestions\\";
//		Reader.processFilesFromFolder(folderpath, 10);

		
	}
}