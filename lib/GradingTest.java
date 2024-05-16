
import static org.junit.Assert.*;
import org.junit.*;

public class GradingTest {

    @Test
    public void testAddStudentGrade_FirstYear() {
        Grading grading = new Grading("1", "fish", "1", "Male");

        assertTrue(grading.AddStudentGrade("0", "1", "4", "3/3/4/4", "SE101/SE102/SE103/SE104", 
                    "Programming/Networking/COA/Operating"));
    }

    @Test
    public void testAddStudentGrade_SeniorYear() {
        Grading grading = new Grading("1", "nani", "4", "Female");

        assertTrue(grading.AddStudentGrade("5", "4", "3", "3/3/4", "SE401/SE402/SE403", 
                    "AdvancedProgramming/Security/Database"));
    }

    @Test
    public void testAddStudentGrade_InvalidInput() {
        Grading grading = new Grading("1", "abdat", "3", "Male");

        assertFalse(grading.AddStudentGrade("0", "3", "4", "3/3/4/3", "SE101/SE102/SE103/SE104", 
                    "Programming/Networking/COA/Operating"));
    }


}
