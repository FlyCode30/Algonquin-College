package models;

/**
 * This class is used to create short answer questions. It extends the Questions
 * class. It has the attributes of answer A. It has a constructor that takes in
 * the course information, type, body, and answer A. It has getters and setters
 * for answer A. It has a toString method that will return the question and the
 * answer for the question.
 * 
 * NOTES FOR FUTURE ITERATIONS: Currently, with the way the interface is setup, short answer questions
 * are not user friendly. We included them for testing purposes, but this class will need to be updated
 * for future iterations.
 *
 */
public class ShortQuestion extends Questions{

	/** Represents the answer for a short question type.*/
	protected String optionA;
	
	/**
	 * This is the constructor for the ShortQuestion class. It adds on answer A to
	 * the questions.
	 * 
	 * @param courseInfo
	 * @param type
	 * @param body
	 * @param optionA
	 */
	public ShortQuestion(String courseInfo, String type, String body, String optionA) {
		super(courseInfo, type, body);
		this.optionA = optionA;
	}
	
	/** Gets the answer for a short answer question */
	public String getOptionA() {
		return optionA;
	}
	
	/** Sets the answer for a short answer question */
	public String setOptionA() {
		return optionA;
	}
	
	/** Returns the a short answer question as a string */
	public String toString() {
		return super.toString() + "   Answer: " + getOptionA();
	}
	
}
