package models;

/** 
 * This class is used to create true or false questions. It extends the Questions
 * class. It has the attributes of options A and B, and answers A and B.
 * 
 * NOTES: Some of the attributes (option A and B being "true" and "false") are coded in the controller classes
 * when the GUI is initialized. This may make some of the methods in this class redundant. Will revise this
 * in future iterations.
 */

public class TorFQuestion extends Questions{
	
	// Attributes for true or false questions
	
	/** The first option for the question */
	protected  String optionA;
	/** The first answer for the question */
	protected Boolean answerA;
	/** The second option for the question */
	protected  String optionB;
	/** The second answer for the question */
	protected Boolean answerB;
	
	/**
	 * This is the constructor for the TorFQuestion class. It adds on options A and
	 * B to the questions and answers A and B.
	 * 
	 * @param courseInfo
	 * @param type
	 * @param body
	 * @param optionA
	 * @param answerA
	 * @param optionB
	 * @param answerB
	 */
	public TorFQuestion(String courseInfo, String type, String body, String optionA, Boolean answerA, String optionB,
			Boolean answerB) {
		super(courseInfo, type, body);
		this.answerA = answerA;
		this.answerB = answerB;
	}

	/** Gets the first answer for a true or false question */
	public String getOptionA() {
		return optionA;
	}
	
	/** Sets the first answer for a true or false question */
	public Boolean getAnswerA() {
		return answerA;
	}
	
	/** Sets the first answer for a true or false question */	
	public void setAnswerA(Boolean answerA) {
		if (answerB == true) {
			this.answerA = false;
		} else {
			this.answerA = answerA;
		}
	}
	
	/** Gets the second option for a true or false question */
	public String getOptionB() {
		return optionB;
	}
	
	/** Sets the second option for a true or false question */
	public Boolean getAnswerB() {
		return answerB;
	}
	
	/** Sets the second option for a true or false question */
	public void setAnswerB(Boolean answerB) {
			if (answerA == true) {
            this.answerB = false;
        } else {
            this.answerB = answerB;
        }
	}
	
	/** Returns the a true or false question as a string */
	public String getAnswerString() {
		
		String answer = "";
		
		if (answerA == true) {
			answer = "true";
		} else if (answerB == true) {
			answer = "false";
		} else {
			answer = "error: please check your question and answer options.";
		}
		return answer;
	}
		
	/** Returns the a true or false question as a string */
	public String toString() {
		return super.toString() + "   A: True" + "   B: False" + "\n";
	}
	
}
