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
  @Test
    public void testCalculateCGPA() {
        // Set up test data
        String id = "1234";
        // Call the method being tested
        String result = StudentGrading.claclulateCGPA(id);
        // Verify the result
        String[] parts = result.split(",");
        assertEquals(3, parts.length);
        double totalPoints = Double.parseDouble(parts[0]);
        double totalCredits = Double.parseDouble(parts[1]);
        double cgpa = Double.parseDouble(parts[2]);
        assertTrue(cgpa > 0.0 && cgpa <= 4.0);
    }
  @Test
    public void testCalculateCGPA() {
        // Set up test data
        String id = "1234";
        // Call the method being tested
        String result = StudentGrading.claclulateCGPA(id);
        // Verify the result
        String[] parts = result.split(",");
        assertEquals(3, parts.length);
        double totalPoints = Double.parseDouble(parts[0]);
        double totalCredits = Double.parseDouble(parts[1]);
        double cgpa = Double.parseDouble(parts[2]);
        assertTrue(cgpa > 0.0 && cgpa <= 4.0);
    }

    @Test
    public void testAddStudent() {
        // Set up test data
        String testInput = "1\nJohn Doe\nM\n";
        InputStream savedInput = System.in;
        try {
            System.setIn(new ByteArrayInputStream(testInput.getBytes()));
            // Call the method being tested
            StudentGrading.batch = null;
            StudentGrading.addStudent(null);
            // Verify the result
            assertNotNull(StudentGrading.batch);
            assertEquals("John Doe", StudentGrading.batch.getName());
            assertEquals("M", StudentGrading.batch.getGender());
        } finally {
            System.setIn(savedInput);
        }
    }

 
   
  
