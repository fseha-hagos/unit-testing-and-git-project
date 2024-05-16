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

    // Abstract method to calculate CGPA
    public double calculateCGPA() {
        String sID = getStudentID();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("cgpa.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] g = line.split(",");
                if (g[0] == sID)
                    return Double.parseDouble(g[-1]);
            }

            // if there is no data it returns 0;
            return cgpa;
        } catch (Exception e) {
        }
        return cgpa;
    }

    // adds a student grade and returns true i fadded and flase if not
    public boolean addStudentGrade() {
        int totla_c;
        String ccode = "";
        String cname = "";
        String credit = "";
        int nYear = Integer.parseInt(sYear);
        try (BufferedReader r = new BufferedReader(new FileReader("course.txt"))) {
            String line = "";
            for (int i = 0; i < nYear; i++) {
                line = r.readLine();
            }
            String[] data = line.split(",");
            totla_c = (data[1].split("/")).length;
            ccode = data[1];
            cname = data[2];
            credit = data[3];

        } catch (Exception e) {
            return false;
        }
        grading = new Grading(sID, sName, sYear, sGeneder);
        return grading.addStudentGrade(sID, sYear, "" + totla_c, credit, ccode, cname);
    }

    public void retireiveGrade(String retrieve_id) {
        String id, name, gender, year, coa, net, ope, pro, credit, gpa, cgpa;
        if (StudentGrading.checkValidId(retrieve_id) == true) {
            try (BufferedReader reader = new BufferedReader(new FileReader("student.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] studentData = line.split(",");
                    if ((String) studentData[0] == (String) retrieve_id) {
                        id = (String) retrieve_id;
                        name = (String) studentData[1];
                        gender = (String) studentData[2];
                    }
                }
            } catch (Exception e) {
            }
            try (BufferedReader reader = new BufferedReader(new FileReader("grade.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] studentScore = line.split(",");
                    if ((String) studentScore[0] == (String) retrieve_id) {
                        year = (String) studentScore[1];
                        coa = (String) studentScore[2];
                        net = (String) studentScore[3];
                        ope = (String) studentScore[4];
                        pro = (String) studentScore[5];

                    }
                }
            } catch (Exception e) {
            }
            try (BufferedReader reader = new BufferedReader(new FileReader("cgpa.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] studentScore = line.split(",");
                    if ((String) studentScore[0] == (String) retrieve_id) {
                        year = (String) studentScore[1];
                        coa = (String) studentScore[2];
                        net = (String) studentScore[3];
                        ope = (String) studentScore[4];
                        pro = (String) studentScore[5];

                    }
                }
            } catch (Exception e) {
            }
        }
    }
}
