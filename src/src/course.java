package src;

import java.util.InputMismatchException;
import java.util.Scanner;

abstract class Course {
    private String courseCode;
    private String courseName;
    private int credithour;
    public Course(String c, String n) {
        courseCode = c;
        courseName = n;
	coursecredithour=cr;
    }

    abstract String addStudentScore();

    // setter methods
    public void setCourseCode(String code) {
        courseCode = code;
    }

    public void setCourseName(String name) {
        courseCode = name;
    }
    public void setcrediihour(int credithour)
	coursecredithour = credit hour;
	}
    // getter methods
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }
    public int getCredithour() {
        return credithour; 
}
import java.util.ArrayList;

public class Course implements java.io.Serializable {
	
	private String courseName;
	private String courseID;
	private int maxStudents;
	private int currentStudents;
	private ArrayList<String> listNames = new ArrayList<String>();
	private String courseInstructor;
	private int courseSectionNumber;
	private String courseLocation;
	
	public Course(String ID, int section) {
		courseID = ID;
		courseSectionNumber = section;
	}
	
	public Course(String name, String ID, int max, int current, ArrayList<String> list, String instructor, int section, String location) {
		courseName = name;
		courseID = ID;
		maxStudents = max;
		currentStudents = current;
		listNames = list;
		courseInstructor = instructor;
		courseSectionNumber = section;
		courseLocation = location;
		
	}
	
	public Course() {}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public int getMaxStudents() {
		return maxStudents;
	}

	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}

	public int getCurrentStudents() {
		return currentStudents;
	}

	public void setCurrentStudents(int currentStudents) {
		this.currentStudents = currentStudents;
	}

	public ArrayList<String> getListNames() {
		return listNames;
	}

	public void setListNames(ArrayList<String> listNames) {
		this.listNames = listNames;
	}

	public int getCourseSectionNumber() {
		return courseSectionNumber;
	}

	public void setCourseSectionNumber(int courseSectionNumber) {
		this.courseSectionNumber = courseSectionNumber;
	}

	public String getCourseInstructor() {
		return courseInstructor;
	}

	public void setCourseInstructor(String courseInstructor) {
		this.courseInstructor = courseInstructor;
	}

	public String getCourseLocation() {
		return courseLocation;
	}

	public void setCourseLocation(String courseLocation) {
		this.courseLocation = courseLocation;
	}
	
	public void displayCourse(Course course) {
		//System.out.println(course.getListNames());
		System.out.println("Course name: " + course.getCourseName() + ", Instructor: " + course.getCourseInstructor() + ", Section #: " + course.getCourseSectionNumber());
	}
import java.util.ArrayList;

public class Course implements java.io.Serializable {
	
	private String courseName;
	private String courseID;
	private int maxStudents;
	private int currentStudents;
	private ArrayList<String> listNames = new ArrayList<String>();
	private String courseInstructor;
	private int courseSectionNumber;
	private String courseLocation;
	
	public Course(String ID, int section) {
		courseID = ID;
		courseSectionNumber = section;
	}
	
	public Course(String name, String ID, int max, int current, ArrayList<String> list, String instructor, int section, String location) {
		courseName = name;
		courseID = ID;
		maxStudents = max;
		currentStudents = current;
		listNames = list;
		courseInstructor = instructor;
		courseSectionNumber = section;
		courseLocation = location;
		coursescheduletime= schedule time;
	}
	
	public Course() {}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public int getMaxStudents() {
		return maxStudents;
	}

	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}

	public int getCurrentStudents() {
		return currentStudents;
	}

	public void setCurrentStudents(int currentStudents) {
		this.currentStudents = currentStudents;
	}

	public ArrayList<String> getListNames() {
		return listNames;
	}

	public void setListNames(ArrayList<String> listNames) {
		this.listNames = listNames;
	}

	public int getCourseSectionNumber() {
		return courseSectionNumber;
	}

	public void setCourseSectionNumber(int courseSectionNumber) {
		this.courseSectionNumber = courseSectionNumber;
	}

	public String getCourseInstructor() {
		return courseInstructor;
	}

	public void setCourseInstructor(String courseInstructor) {
		this.courseInstructor = courseInstructor;
	}

	public String getCourseLocation() {
		return courseLocation;
	}

	public void setCourseLocation(String courseLocation) {
		this.courseLocation = courseLocation;
	}
	
	public void displayCourse(Course course) {
		//System.out.println(course.getListNames());
		System.out.println("Course name: " + course.getCourseName() + ", Instructor: " + course.getCourseInstructor() + ", Section #: " + course.getCourseSectionNumber());
	}
	public int getscheduletime() {
		return scheduletime;
}	
