import static org.junit.Assert.*;
import org.junit.*;

public class BatchStudentTest {

    @Test
    public void testCalculateGPA_ExistingData() {
        // Prepare test data
        BatchStudent student = new BatchStudent("1", "fish", "1", "Male");

        // Set up mock data in cgpa.txt
        // For example, assume the following data in cgpa.txt: "1,3.5,3.8,3.9"
        // This means student with ID 1 has GPAs 3.5 for year 1, 3.8 for year 2, and 3.9 for year 3

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

        // Set up mock data in cgpa.txt
        // For example, assume the following invalid data in cgpa.txt: "1,3.5,3.8,3.9"
        // Here, student ID doesn't match with the current student ID

        double expectedGPA = 0.0; // Expected GPA should be 0.0 when data is invalid

        // Perform the test
        double actualGPA = student.calculateGPA();

        // Assertion
        assertEquals(expectedGPA, actualGPA, 0.01); // Assuming precision up to two decimal places
    }



}
