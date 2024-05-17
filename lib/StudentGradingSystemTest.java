import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
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
        assertTrue(studentGrading.preInputFiles());
    }

}