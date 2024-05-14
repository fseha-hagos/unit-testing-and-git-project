import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
 @Test
    public void testAddGrade() {
        GradingSystem system = new GradingSystem();
        system.addStudent("Kebede", 101);
        system.addGrade(101, 95); // Add grade 95 for student with ID 101
        Assertions.assertEquals(95, system.getAverageGrade(101));
    }
    @Test
    public void testAddNewStudent() {
        system.addStudent("John", 101);
        Assertions.assertFalse(system.hasStudent(101)); //Add Kebede to Student grading system
    }

