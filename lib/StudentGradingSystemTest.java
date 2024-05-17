import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class StudentGradingTest {

    @Test
    public void testCheckValidId() {
        // Set up test data
        String validId = "1234";
        String invalidId = "5678";
        // Call the method being tested
        boolean result1 = StudentGrading.checkValidId(validId);
        boolean result2 = StudentGrading.checkValidId(invalidId);
        // Verify the results
        assertTrue(result1);
        assertFalse(result2);
    }

    @Test
    public void testCalculateGPA() {
        // Set up test data
        String id = "1234";
        String year = "2";
        // Call the method being tested
        String result = StudentGrading.claclulateGPA(id, year);
        // Verify the result
        String[] parts = result.split(",");
        assertEquals(3, parts.length);
        double totalPoints = Double.parseDouble(parts[0]);
        double totalCredits = Double.parseDouble(parts[1]);
        double gpa = Double.parseDouble(parts[2]);
        assertTrue(gpa > 0.0 && gpa <= 4.0);
    }

  
