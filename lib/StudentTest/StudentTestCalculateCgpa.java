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
    
    @Test
    public void calculateCGPA_withValidGrades_returnsCorrectCGPA() {
        // Arrange
        Course course1 = new Course("MATH101", 3.0, 'A');
        Course course2 = new Course("PHYS201", 4.0, 'B');
        student.addCourse(course1);
        student.addCourse(course2);

        // Act
        double result = student.calculateCGPA();

        // Assert
        assertEquals(3.25, result, "CGPA should be calculated correctly for valid grades");
    }
    
    @Test
    public void calculateCGPA_withWeightedGrades_returnsCorrectCGPA() {
        // Arrange
        Course course1 = new Course("MATH101", 3.0, 'A');
        Course course2 = new Course("PHYS201", 4.0, 'B');
        Course course3 = new Course("CHEM101", 2.0, 'C');
        student.addCourse(course1);
        student.addCourse(course2);
        student.addCourse(course3);


        // Act
        double result = student.calculateCGPA();

        // Assert
        assertEquals(3.1666666666666665, result, "CGPA should be calculated correctly for weighted grades");
    }
   
    @Test
    public void calculateCGPA_withNoCourses_returnsZero() {
        // Arrange
        Student student = new MockStudent("12345", "John Doe", "Sophomore", "Male");
    
        // Act
        double result = student.calculateCGPA();
    
        // Assert
        assertEquals(0.0, result, "CGPA should be 0.0 when no courses are added");
    }
    @Test
public void calculateCGPA_withDifferentCourseWeights_returnsWeightedAverage() {
    // Arrange
    Student student = new MockStudent("12345", "John Doe", "Sophomore", "Male");
    Course course1 = new Course("MATH101", 3.0, 'A');
    Course course2 = new Course("PHYS201", 4.0, 'B');
    Course course3 = new Course("CHEM101", 2.0, 'C');
    student.addCourse(course1);
    student.addCourse(course2);
    student.addCourse(course3);

    // Act
    double result = student.calculateCGPA();

    // Assert
    assertEquals(3.25, result, "CGPA should be the weighted average of all courses when courses have different weights");
}
@Test
public void calculateCGPA_withMixedGradesAndDifferentWeights_returnsCorrectAverage() {
    // Arrange
    Student student = new MockStudent("12345", "John Doe", "Sophomore", "Male");
    Course course1 = new Course("MATH101", 3.0, 'A');
    Course course2 = new Course("PHYS201", 4.0, 'B');
    Course course3 = new Course("CHEM101", 2.0, 75);
    student.addCourse(course1);
    student.addCourse(course2);
    student.addCourse(course3);

    // Act
    double result = student.calculateCGPA();

    // Assert
    assertEquals(3.25, result, "CGPA should be the weighted average of all courses when courses have different types of grades and different weights");
}
    @Test
public void calculateCGPA_withMultipleCoursesDifferentGrades_returnsWeightedAverage() {
    // Arrange
    Student student = new MockStudent("12345", "John Doe", "Sophomore", "Male");
    Course course1 = new Course("MATH101", 3.0, 'A');
    Course course2 = new Course("PHYS201", 4.0, 'B');
    Course course3 = new Course("CHEM101", 2.0, 'C');
    student.addCourse(course1);
    student.addCourse(course2);
    student.addCourse(course3);

    // Act
    double result = student.calculateCGPA();

    // Assert
    assertEquals(3.1666666666666665, result, "CGPA should be the weighted average of all courses when courses have different grades");
}

@Test
public void calculateCGPA_withMultipleCoursesDifferentGradesAndDifferentWeights_returnsCorrectAverage() {
    // Arrange
    Student student = new MockStudent("12345", "John Doe", "Sophomore", "Male");
    Course course1 = new Course("MATH101", 3.0, 'A');
    Course course2 = new NewCourse("PHYS201", 4.0, 'B', 1.5);
    Course course3 = new Course("CHEM101", 2.0, 'C', 0.75);
    student.addCourse(course1);
    student.addCourse(course2);
    student.addCourse(course3);

    // Act
    double result = student.calculateCGPA();

    // Assert
    assertEquals(3.25, result, "CGPA should be the weighted average of all courses when courses have different types of grades and different weights");
}
@Test
public void calculateCGPA_withMultipleCoursesDifferentGradesAndDifferentWeights_returnsCorrectAverageWithDecimal() {
    // Arrange
    Student student = new MockStudent("12345", "John Doe", "Sophomore", "Male");
    Course course1 = new Course("MATH101", 3.0, 'A');
    Course course2 = new NewCourse("PHYS201", 4.0, 'B', 1.5);
    Course course3 = new Course("CHEM101", 2.0, 'C', 0.75);
    student.addCourse(course1);
    student.addCourse(course2);
    student.addCourse(course3);

    // Act
    double result = student.calculateCGPA();

    // Assert
    assertEquals(3.25, result, 0.0001, "CGPA should be the weighted average of all courses when courses have different types of grades and different weights");
}


@Test
public void calculateCGPA_withMultipleCoursesDifferentGradesAndDifferentWeights_returnsCorrectAverageWithNegativeAndZeroWeights() {
    // Arrange
    Student student = new MockStudent("12345", "John Doe", "Sophomore", "Male");
    Course course1 = new Course("MATH101", 3.0, 'A');
    Course course2 = new NewCourse("PHYS201", 4.0, 'B', -1.5);
    Course course3 = new Course("CHEM101", 2.0, 'C', 0);
    student.addCourse(course1);
    student.addCourse(course2);
    student.addCourse(course3);

    // Act
    double result = student.calculateCGPA();

    // Assert
    assertEquals(3.25, result, "CGPA should be the weighted average of all courses when courses have different types of grades and different weights, even with negative and zero weights");
}


}

