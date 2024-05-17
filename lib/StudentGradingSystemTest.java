import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class StudentGradingTest {
// Here's a test case for the createFile() method 
    @Test
    void testCreateFile_FileCreation() {
        StudentGrading.createFile();
        File studentFile = new File("student.txt");
        File gradeFile = new File("grade.txt");
        File courseFile = new File("course.txt");
        assertTrue(studentFile.exists());
        assertTrue(gradeFile.exists());
        assertTrue(courseFile.exists());
    }
}