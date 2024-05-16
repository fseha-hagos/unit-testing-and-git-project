import static org.junit.Assert.*;
import org.junit.*;

public class BatchStudentTest {

    @Test
    public void testCalculateGPA_ExistingData() {
        // Prepare test data
        BatchStudent student = new BatchStudent("1", "John", "1", "Male");

        double expectedGPA = 3.5; // Expected GPA for year 1

        // Perform the test
        double actualGPA = student.calculateGPA();

        // Assertion
        assertEquals(expectedGPA, actualGPA, 0.01); // Assuming precision up to two decimal places
    }

    @Test
    public void testCalculateCGPA_ExistingData() {
        // Prepare test data
        BatchStudent student = new BatchStudent("1", "John", "1", "Male");

        double expectedCGPA = 3.5; // Expected CGPA

        // Perform the test
        double actualCGPA = student.calculateCGPA();

        // Assertion
        assertEquals(expectedCGPA, actualCGPA, 0.01); // Assuming precision up to two decimal places
    }


    @Test
    public void testAddStudentGrade_ValidData() {
        // Prepare test data
        BatchStudent student = new BatchStudent("1", "John", "1", "Male");

        // Perform the test
        boolean result = student.addStudentGrade();

        // Assertion
        assertTrue(result); // Expecting true for successful addition
    }

    @Test
    public void testRetrieveGrade_ValidId() {
        // Prepare test data
        BatchStudent student = new BatchStudent("1", "John", "1", "Male");


        // Perform the test
        student.retrieveGrade("1");

    }

}
