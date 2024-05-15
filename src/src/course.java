package src;

import java.util.InputMismatchException;
import java.util.Scanner;

abstract class Course {
    private String courseCode;
    private String courseName;

    public Course(String c, String n) {
        courseCode = c;
        courseName = n;
    }

    abstract String addStudentScore();

    // setter methods
    public void setCourseCode(String code) {
        courseCode = code;
    }

    public void setCourseName(String name) {
        courseCode = name;
    }

    // getter methods
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

}
