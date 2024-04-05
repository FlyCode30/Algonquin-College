package models;

/**
 * This class is used to create multiple choice questions. It extends the
 * Questions class. It has the attributes of options A, B, C, and D, and answers
 * A, B, C, and D. It has a constructor that takes in the course information,
 * type, body, option A, answer A, option B, answer B, option C, answer C,
 * option D, and answer D. It has getters and setters for each option and
 * answer. It has a toString method that will return the question and the
 * options for the question. It has a getCorrectAnswer method that will return
 * the correct answer for the question. It has a validateAnswers method that
 * will check to see if more than one answer is true, if no answer is true, or
 * if only one answer is true.
 * 
 * 
 */
public class MxQuestion extends Questions {
	
	// Attributes for multiple choice questions
	
	/** The first option for the question */
	protected String optionA;
	/** The first answer for the question */
	protected Boolean answerA;
	/** The second option for the question */
	protected String optionB;
	/** The second answer for the question */
	protected Boolean answerB;
	/** The third option for the question */
	protected String optionC;
	/** The third answer for the question */
	protected Boolean answerC;
	/** The fourth option for the question */
	protected String optionD;
	/** The fourth answer for the question */
	protected Boolean answerD;

	/**
	 *  this is the constructor for the MxQuestions class. It adds on options B, C, and D to the questions and answers A, B, C, and D.
	 *  the validate method may not be needed, but left it in just in case
	 * @param courseInfo
	 * @param body
	 * @param optionA
	 * @param answerA
	 * @param optionB
	 * @param answerB
	 * @param optionC
	 * @param answerC
	 * @param optionD
	 * @param answerD
	 */
	public MxQuestion(String courseInfo, String type, String body, String optionA, Boolean answerA, String optionB,
			Boolean answerB, String optionC, Boolean answerC, String optionD, Boolean answerD) {
		super(courseInfo, type, body);
		this.optionA = optionA;
		this.answerA = answerA;
		this.optionB = optionB;
		this.answerB = answerB;
		this.optionC = optionC;
		this.answerC = answerC;
		this.optionD = optionD;
		this.answerD = answerD;
		validateAnswers();
	}
	
	/** Gets the first option for the question */
	public String getOptionA() {
		return optionA;
	}
	
	/** Sets the first option for the question */
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	
	/** Gets the first answer for the question */
	public Boolean getAnswerA() {
		validateAnswers();
		return answerA;
	}
	
	/** Sets the first answer for the question */
	public void setAnswerA(Boolean answerA) {
		this.answerA = answerA;
		validateAnswers();
	}
	
	/** Gets the second option for the question */
	public String getOptionB() {
		return optionB;
	}

	/** Sets the second option for the question */
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	
	/** Gets the second answer for the question */
	public Boolean getAnswerB() {
		validateAnswers();
		return answerB;
	}
	
	/** Sets the second answer for the question */
	public void setAnswerB(Boolean answerB) {
		this.answerB = answerB;
		validateAnswers();
	}
	
	/** Gets the third option for the question */
	public String getOptionC() {
		return optionC;
	}
	
	/** Sets the third option for the question */
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	
	/** Gets the third answer for the question */
	public Boolean getAnswerC() {
		validateAnswers();
	    return answerC;
	}
	
	/** Sets the third answer for the question */
	public void setAnswerC(Boolean answerC) {
		this.answerC = answerC;
		validateAnswers();
	}
	
	/** Gets the fourth option for the question */
	public String getOptionD() {
		return optionD;
	}
	
	/** Sets the fourth option for the question */
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	
	/** Gets the fourth answer for the question */
	public Boolean getAnswerD() {
		validateAnswers();
		return answerD;
	}
	
	/** Sets the fourth answer for the question */
	public void setAnswerD(Boolean answerD) {
		this.answerD = answerD;
		validateAnswers();
	}
	
	/** Returns the question as a string */
	@Override
	public String toString() {
		return super.toString() + "   A) " + getOptionA() + "\n" + "   B) " + getOptionB() + "\n" + "   C) " + getOptionC() + "\n" + "   B) " + getOptionD() + "\n";
	}
	
	
	
	/** Returns the correct answer for a multiple choice question */
	public String getCorrectAnswer() {
		if (answerA == true) {
			return optionA;
		} else if (answerB == true) {
			return optionB;
		} else if (answerC == true) {
			return optionC;
		} else if (answerD == true) {
			return optionD;
		} else {
            return "Error: No correct answer was chosen";
        }
	}
	
	/**
	 * Validates the answer for a multiple choice question. It will check to see if more than one
	 * answer is true, if no answer is true, or if only one answer is true
	 */
	private void validateAnswers()	{
		int trueCount = 0;
		
		if (answerA == true) { trueCount++; }
		if (answerB == true) { trueCount++; }
		if (answerC == true) { trueCount++; }
		if (answerD == true) { trueCount++; }
	
		if (trueCount >1) {
			System.out.println("Error: More than one answer is correct");
		} else if (trueCount == 0) {
			System.out.println("Error: Please choose at least one correct answer");
		} else if (trueCount == 1) { }
	}
	
}