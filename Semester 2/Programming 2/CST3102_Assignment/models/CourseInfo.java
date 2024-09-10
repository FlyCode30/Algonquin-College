package models;

/**
 * Class is used to create a course object consisting of the program name, program year, semester, and course name
 */
public class CourseInfo {

	/** program name */
	protected String programName;
	/** program year */
	protected String programYear;
	/** semester */
	protected String semester;
	/** course name */
	protected String courseName;
	
	/**
	 * Constructor for CourseInfo
	 * 
	 * @param programName
	 * @param programYear
	 * @param semester
	 * @param courseName
	 */
	public CourseInfo(String programName, String programYear, String semester, String courseName) {
		this.programName = programName;
		this.programYear = programYear;
		this.semester = semester;
		this.courseName = courseName;
	}
	
	/** gets program name for CourseInfo */
	public String getProgramName() {
		return programName;
	}
	
	/** gets program year for CourseInfo */
	public String getProgramYear() {
		return programYear;
	}
	
	/** gets semester for CourseInfo */
	public String getSemester() {
		return semester;
	}
	
	/** gets course name for CourseInfo */
	public String getCourseName() {
		return courseName;
	}
	
	/** sets program name for CourseInfo */
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	
	/** sets program year for CourseInfo */
	public void setProgramYear(String programYear) {
		this.programYear = programYear;
	}
	
	/** sets semester for CourseInfo */
	public void setSemester(String semester) {
		this.semester = semester;
	}
	
	/** sets course name for CourseInfo */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
	public String toString() {
        return programYear + semester + "-" + courseName;
    }
	
	/**
	 *  Writes a unique hashcode for the courseInfo object
	 *  NOTES: Probably don't need this, maybe removed in future versions.
	 */
	@Override
	public int hashCode() {
		int result = 5;
		result = 15 * result + programName.hashCode();
		result = 15 * result + programYear.hashCode();
		result = 15 * result + semester.hashCode();
		result = 15 * result + courseName.hashCode();
		return result;
	}
	
	/** 
	 * write an equals method to the compare the parameters of the object to the parameters of the courseInfo object
	 * NOTES: Method was used for testing purposes, may be removed in future versions.
	 */
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		CourseInfo courseInfo = (CourseInfo) obj;
		return (courseInfo.getProgramName().equals(this.getProgramName())
				&& courseInfo.getProgramYear().equals(this.getProgramYear())
				&& courseInfo.getSemester().equals(this.getSemester())
				&& courseInfo.getCourseName().equals(this.getCourseName()));
	}
	
}
