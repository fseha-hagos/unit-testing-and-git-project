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
}
