import static org.junit.Assert.*;
import org.junit.*;

public class BatchStudentTest {

    @Test
    public void testCalculateGPA_ExistingData() {
        // Prepare test data
        BatchStudent student = new BatchStudent("1", "fish", "1", "Male");

        double expectedGPA = 3.5; // Expected GPA for year 1

        // Perform the test
        double actualGPA = student.calculateGPA();

        // Assertion
        assertEquals(expectedGPA, actualGPA, 0.01); // Assuming precision up to two decimal places
    }

    @Test
    public void testCalculateGPA_NoData() {
        // Prepare test data
        BatchStudent student = new BatchStudent("6", "kiros", "2", "Female");
        double expectedGPA = 0.0; // Expected GPA should be 0.0 when there's no data

        // Perform the test
        double actualGPA = student.calculateGPA();

        // Assertion
        assertEquals(expectedGPA, actualGPA, 0.01); // Assuming precision up to two decimal places
    }

    @Test
    public void testCalculateGPA_InvalidData() {
        // Prepare test data
        BatchStudent student = new BatchStudent("3", "kebede", "3", "Male");


        double expectedGPA = 0.0; // Expected GPA should be 0.0 when data is invalid

        // Perform the test
        double actualGPA = student.calculateGPA();

        // Assertion
        assertEquals(expectedGPA, actualGPA, 0.01); // Assuming precision up to two decimal places
    }


    @Test
    public void testCalculateCGPA_ExistingData() {
        // Prepare test data
        Student student = new Student("21", "Gebremariam", "Male");

        double expectedCGPA = 3.5; // Expected CGPA

        // Perform the test
        double actualCGPA = student.calculateCGPA();

        // Assertion
        assertEquals(expectedCGPA, actualCGPA, 0.01); // Assuming precision up to two decimal places
    }

    @Test
    public void testCalculateCGPA_NoData() {
        // Prepare test data
        Student student = new Student("22", "abersh", "Female");

        double expectedCGPA = 0.0; // Expected CGPA should be 0.0 when there's no data

        // Perform the test
        double actualCGPA = student.calculateCGPA();

        // Assertion
        assertEquals(expectedCGPA, actualCGPA, 0.01); // Assuming precision up to two decimal places
    }

    @Test
    public void testCalculateCGPA_InvalidData() {
        // Prepare test data
        Student student = new Student("33", "solomon", "Male");

        double expectedCGPA = 0.0; // Expected CGPA should be 0.0 when data is invalid

        // Perform the test
        double actualCGPA = student.calculateCGPA();

        // Assertion
        assertEquals(expectedCGPA, actualCGPA, 0.01); // Assuming precision up to two decimal places
    }


}


