package models;

/**
 * This is the abstract class for the questions. It is the template for all the
 * questions that will be created. The design philosophy is to have a template as the parent class that can be used as the item type
 * when working with questions or list in the controller classes, but always the flexibility of different types of questions as child classes.
 */
public abstract class Questions {
	
	protected String courseInfo;
	protected String type;
	protected String body;

	/**
	 * This constructor will create a new Questions object with the course
	 * information, type, and body of the question. These parameters were choosen since all question types will have these base attributes. 
	 * 
	 * @param courseInfo
	 * @param type
	 * @param body
	 */
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
	
	/** this method returns a string for each question. */
	public String toString() {
		return "\n" + courseInfo + " - " + type + "\n" + body + "\n";
	}
	
}