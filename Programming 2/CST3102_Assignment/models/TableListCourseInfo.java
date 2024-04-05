package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


// this class will be used to create a table of course information in the courseList.fxml file

public class TableListCourseInfo {

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
	
	public boolean removeCourseByName(String courseName) {
	    for (CourseInfo course : courseList) {
	        if (course.getCourseName().equals(courseName)) {
	            courseList.remove(course);
	            return true; // Course removed successfully
	        }
	    }
	    return false; // Course not found
	}
	
	/**
	 * This method will add a default course to the courseList if courseList is empty
	 * 
	 * @param courseInfo
	 */
	public void setDefault() {
		if (courseList.isEmpty()) {
            courseList.add(new CourseInfo("General", "NA", "A", "General"));
		}
	}
	
	public void setCourseList(TableListCourseInfo courseList) {
		this.courseList = courseList.getCourseInfo();
	}
	
	public void addCourse(CourseInfo courseInfo) {
		courseList.add(courseInfo);
	}
	
	public void removeCourse(CourseInfo courseInfo) {
		courseList.remove(courseInfo);
	}
	
	public void clearList() {
		courseList.clear();
	}
	
	public int size() {
		return courseList.size();
	}
	
	public CourseInfo getCourse(int index) {
		return courseList.get(index);
	}
	
	public void setCourse(int index, CourseInfo courseInfo) {
		courseList.set(index, courseInfo);
	}
	
	public boolean contains(CourseInfo courseInfo) {
		return courseList.contains(courseInfo);
	}
	
	public String toString() {
		return courseList.toString();
	}
	
	public void remove(int index) {
		courseList.remove(index);
	}
}

