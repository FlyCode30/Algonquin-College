package models;

public class CourseInfo {

	protected String programName;
	protected String programYear;
	protected String semester;
	protected String courseName;
	
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
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	
	public void setProgramYear(String programYear) {
		this.programYear = programYear;
	}
	
	public void setSemester(String semester) {
		this.semester = semester;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public String toString() {
        return programYear + semester + "-" + courseName;
    }
	
	/**
	 *  write a hashcode method to generate a unique hashcode for the object
	 *  We probably don't need this, but I left it in just in case. Same goes for the equals method.
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
	
	// write an equals method to the compare the parameters of the object to the parameters of the courseInfo object
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
