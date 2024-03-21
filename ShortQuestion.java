package models;

public class ShortQuestion extends Questions{

	// this class extends the Questions class. It only has one additional field, which is answer A
	protected String optionA;
	
	// this is the constructor for the ShortQuestions class. It consists of answer A but no options
	public ShortQuestion(String courseInfo, String type, String body, String optionA) {
		super(courseInfo, type, body);
		this.optionA = optionA;
	}
	
	// this method is used to get answer A
	public String getAnswerA() {
		return optionA;
	}
	
	public String getOptionA() {
		return optionA;
	}
	
	public String setOptionA() {
		return optionA;
	}
	
	// this method is used to set answer A
	public void setAnswerA(String answerA) {
		this.optionA = answerA;
	}
	
	// this method is used to return a string representation of the object
	public String toString() {
		return super.toString() + "   Answer: " + getOptionA() + "<?>";
	}
	
}
