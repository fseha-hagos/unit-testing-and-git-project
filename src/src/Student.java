package src;

abstract class Student {
    private String studentID;
    private String studentName;
    private String studentYear;
    private String studentGender;
    // private double creditHoursEarned;
    // private double pointsEarned;

    // Constructor
    public Student(String studentID, String studentName, String studentYear, String studentGender) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentYear = studentYear;
        this.studentGender = studentGender;
        // this.creditHoursEarned = 0;
        // this.pointsEarned = 0;
}

// Abstract method to calculate GPA
public abstract double calculateGPA();
public abstract double calculateCGPA();
public String getStudentID() {
    return studentID;
}

public String getStudentName() {
    return studentName;
}
public String getStudentYear() {
    return studentYear;
}
}



