package testApp;

public class MxQuestion extends Questions {
	
	protected String optionA;
	protected Boolean answerA;
	protected String optionB;
	protected Boolean answerB;
	protected String optionC;
	protected Boolean answerC;
	protected String optionD;
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
	public MxQuestion(String courseInfo, String body, String optionA, Boolean answerA, String optionB,
			Boolean answerB, String optionC, Boolean answerC, String optionD, Boolean answerD) {
		super(courseInfo, body);
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
	
	// this method is used to get option A
	public String getOptionA() {
		return optionA;
	}
	
	// this method is used to set option A
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	
	public Boolean getAnswerA() {
		validateAnswers();
		return answerA;
	}
	
	// this method is used to set answer A. If answer B, C, or D are true, answer A is false
	public void setAnswerA(Boolean answerA) {
		this.answerA = answerA;
		validateAnswers();
	}
	
	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	
	public Boolean getAnswerB() {
		validateAnswers();
		return answerB;
	}
	
	public void setAnswerB(Boolean answerB) {
		this.answerB = answerB;
		validateAnswers();
	}
	
	public String getOptionC() {
		return optionC;
	}
	
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	
	public Boolean getAnswerC() {
		validateAnswers();
	    return answerC;
	}
	
	// create a setter for Answer C so that if answer A, B, or D are true, answer C is false
	public void setAnswerC(Boolean answerC) {
		this.answerC = answerC;
		validateAnswers();
	}
	
	public String getOptionD() {
		return optionD;
	}
	
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	
	public Boolean getAnswerD() {
		validateAnswers();
		return answerD;
	}
	
	// create a setter for Answer D so that if answer A, B, or C are true, answer D is false
	public void setAnswerD(Boolean answerD) {
		this.answerD = answerD;
		validateAnswers();
	}
	
	/**
	 * This method will return the question and the options for the question
	 * 
	 */
	@Override
	public String toString() {
		return super.toString() + "   A) " + getOptionA() + "\n" + "   B) " + getOptionB() + "\n" + "   C) " + getOptionC() + "\n" + "   B) " + getOptionD() + "\n" + "The correct answer is: " + getCorrectAnswer();
	}
	
	
	
	/**
	 * This method will return the correct answer. I used it in the toString method to print out the correct answer for each multiple choice question
	 * 
	 */
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
	 * This method will validate the answers. It will check to see if more than one
	 * answer is true, if no answer is true, or if only one answer is true
	 * 
	 * 
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