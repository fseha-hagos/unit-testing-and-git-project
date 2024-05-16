package src.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import src.Student;
public class StudentTest {

    @Test
    public void testGetStudentGender_EmptyGender_ReturnsNull() {
        // Create a student object with an empty gender field
        Student student = new Student("123", "John Doe", "2020", "");

        // Test getStudentGender() method
        String gender = student.getStudentGender();

        // Assert that the gender is null
        assertNull(gender);
    }

