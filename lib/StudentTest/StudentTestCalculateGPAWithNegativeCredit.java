package src.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import src.Student;

public class StudentTestCalculateGPAWithNegativeCredit {

    @Test
    public void testCalculateGPAWithNegativeCredit_1() {
        Student student = new Student("12345", "John Doe", "Sophomore", "Male");
        student.setCreditHoursEarned(-5);
        student.setPointsEarned(60);
        double expectedGPA = 12.0; // 60 points / 5 credits
        double actualGPA = student.calculateGPA();
        assertEquals(expectedGPA, actualGPA, "GPA should not be calculated with negative credits");
    }

    @Test
    public void testCalculateGPAWithNegativeCredit_2() {
        Student student = new Student("67890", "Jane Smith", "Junior", "Female");
        student.setCreditHoursEarned(-10);
        student.setPointsEarned(120);
        double expectedGPA = 12.0; // 120 points / 10 credits
        double actualGPA = student.calculateGPA();
        assertEquals(expectedGPA, actualGPA, "GPA should not be calculated with negative credits");
    }

    @Test
    public void testCalculateGPAWithNegativeCredit_3() {
        Student student = new Student("11111", "Bob Johnson", "Senior", "Male");
        student.setCreditHoursEarned(-15);
        student.setPointsEarned(180);
        double expectedGPA = 12.0; // 180 points / 15 credits
        double actualGPA = student.calculateGPA();
        assertEquals(expectedGPA, actualGPA, "GPA should not be calculated with negative credits");
    }

    @Test
    public void testCalculateGPAWithNegativeCredit_4() {
        Student student = new Student("22222", "Alice Brown", "Freshman", "Female");
        student.setCreditHoursEarned(-20);
        student.setPointsEarned(240);
        double expectedGPA = 12.0; // 240 points / 20 credits
        double actualGPA = student.calculateGPA();
        assertEquals(expectedGPA, actualGPA, "GPA should not be calculated with negative credits");
    }

    @Test
    public void testCalculateGPAWithNegativeCredit_5() {
        Student student = new Student("33333", "Charlie Green", "Sophomore", "Male");
        student.setCreditHoursEarned(-25);
        student.setPointsEarned(300);
        double expectedGPA = 12.0; // 300 points / 25 credits
        double actualGPA = student.calculateGPA();
        assertEquals(expectedGPA, actualGPA, "GPA should not be calculated with negative credits");
    }
}
