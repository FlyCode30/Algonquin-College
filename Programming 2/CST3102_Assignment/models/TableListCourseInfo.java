package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;


// this class will be used to create a table of course information in the courseList.fxml file

public class TableListCourseInfo {

	private ObservableList<CourseInfo> courseList;

	
	public TableListCourseInfo() {
		courseList = FXCollections.observableArrayList();
	}
	
	public ObservableList<CourseInfo> getCourseInfo() {
		return courseList;
	}
	
	/**
	 * This method will add a default course to the courseList if courseList is empty
	 * 
	 * @param courseInfo
	 */
	public void setDefault() {
		if (courseList.isEmpty()) {
            courseList.add(new CourseInfo("General", 0, "A", "General"));
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

//}
//
//// gets the string representation of courseName of an object in the courseList
//public String getCourseName(int index) {
//	return courseList.get(index).getCourseName();
//}
//
//// gets the string representation of programName of an object in the courseList
//public String getProgramName(int index) {
//	return courseList.get(index).getProgramName();
//}
//
//// gets the string representation of semester of an object in the courseList
//public String getSemester(int index) {
//	return courseList.get(index).getSemester();
//}

	
