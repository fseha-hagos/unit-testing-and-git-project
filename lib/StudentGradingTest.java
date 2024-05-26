import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import src.StudentGrading;

class StudentGradingTest {
    // Here's a test case for the createFile() method
    StudentGrading studentGrading;

    @BeforeEach
    void setUp() {
        studentGrading = new StudentGrading();
    }

    @Test
    void testCreateFile_FileCreation() {

        studentGrading.createFile();
        File studentFile = new File("student.txt");
        File gradeFile = new File("grade.txt");
        File courseFile = new File("course.txt");
        assertTrue(studentFile.exists());
        assertTrue(gradeFile.exists());
        assertTrue(courseFile.exists());
    }

    @Test
    void testPreinputFiles() {
        // assertFalse(studentGrading.preInputFiles());
    }

    // unit tests for checkValidId function
    @Test
    public void testValidIdExists() throws IOException {
        // Create a temporary test file with a valid ID
        File testFile = new File("student_test.txt");
        // File testFile = File.createTempFile("student_test", ".txt");
        FileWriter writer = new FileWriter(testFile);
        writer.write("1234,Fseha,m\n");
        writer.write("5678,hagos,m\n");
        writer.close();

        // Test with a valid ID
        String validId = "1234";
        assertTrue(studentGrading.checkValidId(validId, "student_test.txt"));

        // Delete the temporary file
        testFile.delete();
    }

    @Test
    public void testInvalidIdNonExistent() throws IOException {
        // Create a temporary test file with some IDs
        File testFile = new File("student_test.txt");
        // File testFile = File.createTempFile("student_test", ".txt");
        FileWriter writer = new FileWriter(testFile);
        writer.write("5678,fseha,m\n");
        writer.write("9012,kibrom,m\n");
        writer.close();

        // Test with a non-existent ID
        String invalidId = "3456";
        assertFalse(studentGrading.checkValidId(invalidId, "student_test.txt"));

        // Delete the temporary file
        testFile.delete();
    }

    @Test
    public void testEmptyFile() throws IOException {
        // Create an empty temporary file
        File testFile = new File("student_test.txt");
        testFile.createNewFile();

        // Test with an ID
        String anyId = "1234";
        assertFalse(studentGrading.checkValidId(anyId, "student_test.txt"));

        // Delete the temporary file
        testFile.delete();
    }

    @Test
    public void testIOException() throws IOException {
        // Simulate an IOException by providing a non-existent file
        String nonexistentFile = "nonexistent.txt";
        assertFalse(studentGrading.checkValidId(nonexistentFile, "nonexistent.txt"));
    }

    // test for legalYear

    @Test
    public void testValidStudentAndYear() throws Exception {
        // Create a temporary test file with student data
        File testFile = new File("grade_test.txt");
        FileWriter writer = new FileWriter(testFile);
        writer.write("1234,2023\n");
        writer.write("5678,2022\n");
        writer.close();

        // Capture standard output for testing prompts
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Test with valid ID and year
        String studentId = "1234";
        String validYear = "2023";
        String expectedOutput = "ENTER STUDENT YEAR :\n";
        assertEquals(validYear, StudentGrading.legalYear(studentId, "grade_test.txt"));
        assertEquals(expectedOutput, outContent.toString());

        // Clean up resources
        testFile.delete();
        System.setOut(System.out);
    }

    @Test
    public void testInvalidStudentId() throws Exception {
        // Create a temporary test file with student data
        File testFile = new File("grade_test.txt");
        FileWriter writer = new FileWriter(testFile);
        writer.write("5678,2022\n");
        writer.write("9012,2024\n");
        writer.close();

        // Test with invalid ID
        String invalidId = "3456";
        String expectedYear = null;
        assertNull(StudentGrading.legalYear(invalidId, "grade_test.txt"));

        // Clean up resources
        testFile.delete();
    }

    @Test
    public void testInvalidYear() throws Exception {
        // Create a temporary test file with student data
        File testFile = new File("grade_test.txt");
        FileWriter writer = new FileWriter(testFile);
        writer.write("1234,2023\n");
        writer.write("5678,2022\n");
        writer.close();

        // Capture standard output for testing prompts
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Test with valid ID but invalid year (should ask for re-entry twice)
        String studentId = "1234";
        String invalidYear = "2022";
        String expectedOutput1 = "ENTER STUDENT YEAR :\n";
        String expectedOutput2 = "PLEASE ENTER ACADAMIC YEAR :\n";
        assertEquals(null, StudentGrading.legalYear(studentId, "grade_test.txt"));
        assertTrue(outContent.toString().contains(expectedOutput1));
        assertTrue(outContent.toString().contains(expectedOutput2));

        // Clean up resources
        testFile.delete();
        System.setOut(System.out);
    }

    @Test
    public void testIOException_for_checkValidYear() throws IOException {
        // Test with a non-existent file
        String nonexistentFile = "nonexistent.txt";
        assertThrows(FileNotFoundException.class, () -> studentGrading.legalYear("1000", nonexistentFile));
    }

}