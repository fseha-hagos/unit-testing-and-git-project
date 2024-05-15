
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.AllCourses;

public class AllCoursesTest {

    AllCourses allCourse;

    @BeforeEach
    void setUp() {
        allCourse = new AllCourses("mat01", "mathematics", 3);
    }

    @Test
    void testGetCourseCode() {
        Assertions.assertEquals("mat", allCourse.getCourseCode());
    }

    @Test
    void testSetCourseCode() {
        allCourse.setCourseCode("mat23");
        Assertions.assertEquals("mat23", allCourse.getCourseCode());
    }

    @Test
    void testGetCourseName() {
        // AllCourses allCourse = new AllCourses("mat", "mathematics", 3);
        Assertions.assertEquals("mathematics", allCourse.getCourseName());
    }

    @Test
    void testSetCourseName() {
        //// AllCourses allCourse = new AllCourses("mat", "mathematics", 3);
        allCourse.setCourseCode("physics");
        Assertions.assertEquals("physics", allCourse.getCourseName());
    }

    public int testGetCreditHour() {
        Assertions.assertEquals(3, allCourse.testGetCreditHour());
    }

    public void testSetCreditHour(int creditHour) {
        allCourse.setCeditHour(4);
        Assertions.assertEquals(4, allCourse.getCreditHoure());
    }

}
