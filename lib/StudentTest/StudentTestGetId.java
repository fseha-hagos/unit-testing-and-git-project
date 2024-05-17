package src.StudentTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {

    @Test
    void testGetStudentID_ValidStudentID_ReturnsStudentID() {
        Student student = new Student("12345", "John Doe", "Sophomore", "Male");
        assertEquals("12345", student.getStudentID());
    }
    
    @Test
    void testGetStudentID_NullStudentID_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Student(null, "John Doe", "Sophomore", "Male"));
    }

    @Test
    void testGetStudentID_EmptyStudentID_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Student("", "John Doe", "Sophomore", "Male"));
    }
    
    @Test
    void testGetStudentID_BlankStudentID_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Student(" ", "John Doe", "Sophomore", "Male"));
    }




