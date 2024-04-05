package models;

/** 
 * this class is used to create FillQuestion objects which are a type of question. "Answers" in this this class are actually options for 
 * other questions. Since Answer A,B,C, and D are Boolean values in the other question types, and all answers would true in a fill the blank question,
 * options are used instead.
 * 
 * NOTES: The question type should be hard coded here rather than in the controller classes as it is a property of the question object.
 * Will consider adjusting this for future iterations.
 */
public class FillQuestion extends Questions{

	/** the answer for option A */
	protected String optionA;
	/** the answer for option B */
	protected String optionB;
	/** the answer for option C */
	protected String optionC;
	/** the answer for option D */
	protected String optionD;
	
	
	/**
	 * Contstructor for a fill in the blank question
	 * 
	 * @param courseInfo
	 * @param type
	 * @param body
	 * @param optionA
	 * @param optionB
	 * @param optionC
	 * @param optionD
	 */

	public FillQuestion(String courseInfo, String type, String body, String optionA, String optionB, String optionC,
			String optionD) {
		super(courseInfo, type, body);
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
	}

	/** this method is used to get option A */
	public String getOptionA() {
		return optionA;
	}
	
	/** Sets the answer for option A */
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	
	/** Gets the answer for option B */
	public String getOptionB() {
		return optionB;
	}
	
	/** Sets the answer for option B */
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	
	/** this method is used to get option C */
	public String getOptionC() {
		return optionC;
	}
	
	/** Sets the answer for option C */
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	
	/** Get the answer for option D */
	public String getOptionD() {
		return optionD;
	}
	
	/** Sets the answer for option D */
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	
	/** toString method for a fill question */
	public String toString() {
		return super.toString() + "   " + getOptionA() + "\n   " + getOptionB() + "\n   " + getOptionC() + "\n   " + getOptionD();
	}
}
