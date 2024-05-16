package src;
import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

class BatchStudent extends Student {
    Course programming, networking, coa, operatingSystem;
    Grading grading;
    private double gpa = 0.0;
    private double cgpa = 0.0;

    public BatchStudent(String studentID, String studentName, String sutdentYear, String studentGender) {
        super(studentID, studentName, sutdentYear, studentGender);

    }

    String sID = getStudentID();
    String sName = getStudentName();
    String sYear = getStudentYear();
    String sGeneder = getStudentGender();

    public double calculateGPA() {
        String sID = getStudentID();
        String sYear = getStudentYear();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("cgpa.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] g = line.split(",");
                if (g[0] == sID)
                    return Double.parseDouble(g[Integer.parseInt(sYear)]);
            }

            // if there is no data it returns 0;
            return gpa;
        } catch (Exception e) {
        }
        return gpa;
    }
}
