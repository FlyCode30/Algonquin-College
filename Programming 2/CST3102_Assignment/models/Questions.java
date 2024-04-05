package models;

/**
 * This is the abstract class for the questions. It is the template for all the
 * questions that will be created. The design philosophy is to have a template as the parent class that can be used as the item type
 * when working with questions or list in the controller classes, but always the flexibility of different types of questions as child classes.
 * 
 * NOTES FOR FUTURE ITERATIONS: Currently, all question types have are not setup to expand beyond the number of the options/answers they currently have.
 * Future iterations will reconsider this. 
 */
public abstract class Questions {
	
	// Attributes for all question types
	
	/** The course information for the question */
	protected String courseInfo;
	/** The type of question */
	protected String type;
	/** The body of the question */
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
	
	/** Gets the course information for the question */
	public String getCourseInfo() {
		return courseInfo;
	}

	/** Sets the course information for the question */
	public void setCourseInfo(String courseInfo) {
		this.courseInfo = courseInfo;
	}
	
	/** Gets the type of question */
	public String getType() {
		return type;
	}
	
	/** Sets the type of question */
	public void setType(String type) {
		this.type = type;
	}
	
	/** Gets the body of the question */
	public String getBody() {
		return body;
	}

	/** Sets the body of the question */
	public void setBody(String body) {
		this.body = body;
	}
	
	/** Returns the question as a string */
	public String toString() {
		return "\n" + courseInfo + " - " + type + "\n" + body + "\n";
	}
	
}