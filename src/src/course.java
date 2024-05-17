package src;

import java.util.InputMismatchException;
import java.util.Scanner;

abstract class Course {
    private String courseCode;
    private String courseName;
    private int credithour;
    public Course(String c, String n,int crh) {
        courseCode = c;
        courseName = n;
	coursecredithour=crh;
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

