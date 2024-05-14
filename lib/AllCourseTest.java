import org.junit.jupiter.api.Assertions;
import org.juit.*;

public class AllCourseTest {

    @BeforeEach
    void setUp() {
        AllCourses courses = new AllCourses("mat12", "Mathematics", 4);
    }

    // testing the getCourseCode() methode
    @Test
    void testGetCourseCode() {
        Assertions.assertEquals("mat12", courses.getCourseCode());
    }

    // testing the setCourseCode() methode
    @Test
    void testSetCourseCode() {
        courses.setCourseCode("mat02");
        Assertions.assertEquals("mat02", courses.getCourseCode());
    }

    // testing the getCourseName function
    @Test
    void testGetCourseName() {
        Assertions.assertEquals("Mathematics", courses.getCourseName());
    }

    // testing the setCourseName() methode
    @Test
    void testSetCourseName() {
        courses.setCourseName("physics");
        Assertions.assertEquals("physics", courses.getCourseName());
    }

    // testing the getCreditHour() methode
    @Test
    void testGetCreditHour() {
        Assertions.assertEquals(4, courses.getCreditHour());
    }

    // testing the setCreditHoure() methode
    @Test
    void testSetCreditHour() {
        courses.setCreditHour(3);
        Assertions.assertEquals(3, courses.setCreditHour());
    }

}
