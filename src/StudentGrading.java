
import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

//the main method for implementing the grading system
public class StudentGrading {

    public static BatchStudent batch;
    public Grading grading;

    static void createFile() {
        final String STUDENT_FILE = "student.txt";
        final String GRADE_FILE = "grade.txt";
        final String COURSE_FILE = "course.txt";
        try {
            File student_file = new File(STUDENT_FILE);
            File grade_file = new File(GRADE_FILE);
            File course_file = new File(COURSE_FILE);

            if (student_file.createNewFile() && grade_file.createNewFile() && course_file.createNewFile()) {
                System.out.println("New File is created succesfully!");
            } else {
                System.out.println("File already exists.");
            }
        } catch (Exception e) {
            System.out.println("Sorry can not create file.");
            System.exit(0);
        }
    }

   
//add additional code right here.
}
