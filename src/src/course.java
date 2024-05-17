package src;

import java.util.InputMismatchException;
import java.util.Scanner;

abstract class Course {
    private String courseCode;
    private String courseName;
    private int    credithours;
    public Course(String c, String n,int crh) {
        courseCode = c;
        courseName = n;
        creditHour=crh;
    }

    abstract String addStudentScore();

    // setter methods
    public void setCourseCode(String code) {
        courseCode = code;
    }

    public void setCourseName(String name) {
        courseCode = name;
    }
    public void setCreitHour(int credithour) {
        creditHour = creditHour;
    }
    // getter methods
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }
    public int getCreditHours() {
		return creditHours;
}
