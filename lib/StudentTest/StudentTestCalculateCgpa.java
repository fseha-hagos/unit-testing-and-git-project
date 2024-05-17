import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    private Student student;

    @BeforeEach
    public void setUp() {
        student = new MockStudent("12345", "John Doe", "Sophomore", "Male");
    }

    @Test
    public void calculateCGPA_withIncompleteGrade_returnsZero() {
        // Arrange
        Course course = new Course("MATH101", 3.0, 'I');
        student.addCourse(course);

        // Act
        double result = student.calculateCGPA();

        // Assert
        assertEquals(0.0, result, "CGPA should be 0.0 when an 'I' grade is present");
    }