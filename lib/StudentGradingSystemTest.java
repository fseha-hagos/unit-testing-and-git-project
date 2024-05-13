import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
 @Test
    public void testAddGrade() {
        GradingSystem system = new GradingSystem();
        system.addStudent("Kebede", 101);
        system.addGrade(101, 95); // Add grade 90 for student with ID 1
        Assertions.assertEquals(95, system.getAverageGrade(101));
    }
     