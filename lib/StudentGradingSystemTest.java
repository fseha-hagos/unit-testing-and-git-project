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

   
