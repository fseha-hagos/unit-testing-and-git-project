import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProgrammingCourse extends Course {

    public ProgrammingCourse(String c1, String n1) {
        super(c1, n1);
    }

    @Override
    String addStudentScore() {
        return "Programming, 95";
    }
}

public class CourseTest {

    @Test
    void testAddStudentScore() {
        ProgrammingCourse programmingCourse = new ProgrammingCourse("SE101", "Programming");

        String result = programmingCourse.addStudentScore();

        // Assert the result
        Assertions.assertEquals("Programming", "95", result);
    }
    @Test
    void testAddStudentScore_ValidScore() {
        Course course = new ProgrammingCourse("C001", "Programming");
        String result = course.addStudentScore();
        String[] parts = result.split(",");
        double score = Double.parseDouble(parts[2]);
        assertTrue(score >= 1 && score <= 4);
    }
    // test for InvalidScore 
    @Test
    void testAddStudentScore_InvalidScore() {
        Course course = new ComputerNetworkingCourse("C002", "Computer Networking");
        String result = course.addStudentScore();
        String[] parts = result.split(",");
        double score = Double.parseDouble(parts[2]);
        assertFalse(score < 1 || score > 4);
    }
}
