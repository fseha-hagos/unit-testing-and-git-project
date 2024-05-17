import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    private Student student;

    @BeforeEach
    public void setUp() {
        student = new Student("12345", "John Doe", "Freshman", "Male") {
            @Override
            public double calculateGPA() {
                return 0;
            }
