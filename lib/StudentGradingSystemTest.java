import org.junit.jupiter.api.Assertions;

public class StudentGradingSystemTest {

    Grading grading;

    @BeforeEach
    void setUp() {
        grading = new Grading("ugr/121212", "Kiki", "1999", "Female");
    }

    @Test
    void testAddStudentGrade() {
        boolean result = grading.AddStudentGrade("ugr/121212", "1999", "4", "3/2/4/3", "SE101/SE102/SE103/SE104",
                "Programming/Networking/COA/Operating");
        Assertions.assertTrue(result);
    }

    @Test
    void testAddStudentGradeWithInvalidYear() {
        boolean result = grading.AddStudentGrade("0", "5", "4", "3/2/4/3", "SE101/SE102/SE103/SE104",
                "Programming/Networking/COA/Operating");
        Assertions.assertFalse(result);
    }
}
