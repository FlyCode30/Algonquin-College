package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * This class is used to create a list of courses.
 * 
 */

public class TableListCourseInfo {

	/** Observable list of courses */
	private ObservableList<CourseInfo> courseList;

	/**
	 * This constructor will create a new TableListCourseInfo object with an empty
	 * courseList. It is called by the main controller class when the application is started.
	 */
	
	public TableListCourseInfo() {
		courseList = FXCollections.observableArrayList();
	}
	
	/**
	 * This method will return the courseList
	 * 
	 * @return courseList
	 */
	public ObservableList<CourseInfo> getCourseInfo() {
		return courseList;
	}
	
	/**
	 * Sets a default course in the course list if the list is empty.
	 * 
	 * @param courseInfo
	 */
	public void setDefault() {
		if (courseList.isEmpty()) {
            courseList.add(new CourseInfo("General", "NA", "A", "General"));
		}
	}
	
	/** Sets the course list */
	public void setCourseList(TableListCourseInfo courseList) {
		this.courseList = courseList.getCourseInfo();
	}
	
	/** Adds a course to the course list */
	public void addCourse(CourseInfo courseInfo) {
		courseList.add(courseInfo);
	}
	
	/** Removes a course from the course list by identifying the name of the course object.*/
	public void removeCourse(CourseInfo courseInfo) {
		courseList.remove(courseInfo);
	}
	
	/** Clears the course list */
	public void clearList() {
		courseList.clear();
	}
	
	/** Gets the size of the course list */
	public int size() {
		return courseList.size();
	}
	
	/** Gets a course from the course list */
	public CourseInfo getCourse(int index) {
		return courseList.get(index);
	}
	
	/** Sets a course in the course list */
	public void setCourse(int index, CourseInfo courseInfo) {
		courseList.set(index, courseInfo);
	}
	
	/** Checks if the course list contains a course */
	public boolean contains(CourseInfo courseInfo) {
		return courseList.contains(courseInfo);
	}
	
	/** Returns the course list as a string */
	public String toString() {
		return courseList.toString();
	}
	
	/** Removes a course from the course list by index */
	public void remove(int index) {
		courseList.remove(index);
	}
}

