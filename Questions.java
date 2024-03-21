package models;


public abstract class Questions {
	
	protected String courseInfo;
	protected String type;
	protected String body;

	// this constructor is the template for the questions
	public Questions (String courseInfo, String type, String body) {
		this.courseInfo = courseInfo;
		this.type = type;
		this.body = body;
	}
	
	// this method is used to get the course information
	public String getCourseInfo() {
		return courseInfo;
	}

	// this method is used to set the course information
	public void setCourseInfo(String courseInfo) {
		this.courseInfo = courseInfo;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	// this method is used to get the question body
	public String getBody() {
		return body;
	}

	// this method is used to set the question body
	public void setBody(String body) {
		this.body = body;
	}
	
	/**
	 * this method returns a string for each question. Seeing as how it is only the body of the question, it may be useful to use this method to display the question in the GUI
	 * the <?> was me testing using an identifier for the question to help with the reader, but this may be beyond the scope of the project, so we may have to remove it
	 */
	public String toString() {
		return "\n" + courseInfo + " - " + type + "\n" + body + "\n";
	}
	
}