package models;

public class TorFQuestion extends Questions{
	
	protected  String optionA;
	protected Boolean answerA;
	protected  String optionB;
	protected Boolean answerB;
	
	// this is the constructor for the TorFQuestions class. It adds on options B to the questions
	public TorFQuestion(String courseInfo, String type, String body, String optionA, Boolean answerA, String optionB,
			Boolean answerB) {
		super(courseInfo, type, body);
		this.answerA = answerA;
		this.answerB = answerB;
	}

	// this method is used to get option A
	public String getOptionA() {
		return optionA;
	}
	
	// this method is used to get answer A
	public Boolean getAnswerA() {
		return answerA;
	}
	
	// this method is used to set answer A. If answer B is true, answer A is false
	public void setAnswerA(Boolean answerA) {
		if (answerB == true) {
			this.answerA = false;
		} else {
			this.answerA = answerA;
		}
	}
	
	public String getOptionB() {
		return optionB;
	}
	
	
	public Boolean getAnswerB() {
		return answerB;
	}
	
	public void setAnswerB(Boolean answerB) {
			if (answerA == true) {
            this.answerB = false;
        } else {
            this.answerB = answerB;
        }
	}
	
	// this method returns which answer is true
	public String getAnswer() {
		
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
		
	
	public String toString() {
		return super.toString() + "   A: True" + "   B: False" + "\n";
	}
	
}
