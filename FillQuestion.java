package testApp;

public class FillQuestion extends Questions{

	
	protected String optionA;
	protected String optionB;
	protected String optionC;
	protected String optionD;
	
	
	// this is the constructor for the FillQuestions class. it consists of answers A, B, C, and D but no options
	public FillQuestion(String courseInfo, String body, String optionA, String optionB, String optionC,
			String optionD) {
		super(courseInfo, body);
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
	}

	// this method is used to get option A
	public String getOptionA() {
		return optionA;
	}
	
	// this method is used to set option A
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	
	// this method is used to get option B
	public String getOptionB() {
		return optionB;
	}
	
	// this method is used to set option B
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	
	// this method is used to get option C
	public String getOptionC() {
		return optionC;
	}
	
	// this method is used to set option C
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	
	// this method is used to get option D
	public String getOptionD() {
		return optionD;
	}
	
	// this method is used to set option D
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	
	// this method is used to return a string representation of the object
	public String toString() {
		return super.toString() + "   " + getOptionA() + "\n   " + getOptionB() + "\n   " + getOptionC() + "\n   " + getOptionD();
	}
}
