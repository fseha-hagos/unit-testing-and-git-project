import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest{
    private Student student;

    @BeforeEach
    public void setUp()
    {
        student = new Student("12345", "John Doe", "Freshman", "Male") {
            @Override
            public double calculateGPA() {
                return 0;
            }
            
    @Test
    public void testGetStudentYear_SpecialCharacters_ReturnsDefault() {
        student.setStudentYear("!@#$%^&*");
        assertEquals("Freshman", student.getStudentYear(), "Expected default value when student year contains special characters");
    }

    @Test
    public void testGetStudentYear_SpecialCharacters_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> student.setStudentYear("!@#$%^&*"), "Expected exception when student year contains special characters");
    }

    @Test
    public void testGetStudentYear_EmptyString_ReturnsDefault() {
        student.setStudentYear("");
        assertEquals("Freshman", student.getStudentYear(), "Expected default value when student year is an empty string");
    }

    @Test
    public void testGetStudentYear_EmptyString_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> student.setStudentYear(""), "Expected exception when student year is an empty string");
    }

        


        
