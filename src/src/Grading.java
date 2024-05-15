package src;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

class Grading {
    private String studentID;
    private String studentName;
    private String studentYear;
    private String studentGender;
    private String credit_of_year;
    private String[] format_credit;
    private String[] course_code;
    private String[] course_name;

    Course programming, networking, coa, operating, course;

    public Grading(String studentID, String studentName, String studentYear, String studentGender) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentYear = studentYear;
        this.studentGender = studentGender;

    }

    public boolean AddStudentGrade(String _id, String year, String total_course, String formated_credit, String ccode,
            String cname) {
        boolean senior = false;
        format_credit = formated_credit.split("/");
        course_code = ccode.split("/");
        course_name = cname.split("/");
        try (BufferedReader reader = new BufferedReader(new FileReader("student.txt"))) {

            String line;

            // if the data is empty then the first person is going to have the first id.
            if ((line = reader.readLine()) == null) {
                studentID = "1";

            }

            // if the data is not empty
            else {

                // if the data is not empty and the prson to add is not in first year
                if (_id != "0") {
                    senior = true;
                    studentID = _id;
                }

                // if the data is not empty and the person to add is firss year
                // the id will be 1 more than the largest id.
                else {
                    int max = 0;
                    String current = null;
                    do {
                        String[] stu = line.split(",");
                        if (Integer.parseInt(stu[0]) > max) {
                            max = Integer.parseInt(stu[0]);
                        }
                    } while ((line = reader.readLine()) != null);

                    // increments the student id by 1 and assignes to the next student.
                    studentID = "" + (max + 1);
                }
            }

            try {

                String gradeData = "";
                int s_year = Integer.parseInt(year);
                if (senior == false) {
                    System.out.print("\nPlease enter scores for " + studentName + " " + "of year 1:\n");
                    programming = new ProgrammingCourse(course_code[0], course_name[0]);
                    networking = new ComputerNetworkingCourse(course_code[1], course_name[1]);
                    coa = new COACourse(course_code[2], course_name[2]);
                    operating = new OperatingSystemCourse(course_code[3], course_name[3]);
                    String pScore = ((programming.addStudentScore()).split(","))[2];
                    String nScore = ((networking.addStudentScore()).split(","))[2];
                    String cScore = ((coa.addStudentScore()).split(","))[2];
                    String oScore = ((operating.addStudentScore()).split(","))[2];
                    gradeData = studentID + "," + "1" + "," + pScore + "/" + nScore + "/" + cScore + "/" + oScore + ","
                            + formated_credit + "\n";
                } else {
                    System.out.print("\nPlease enter scores for " + studentName + "of year " + year + ":");
                    int t_course = Integer.parseInt(total_course);
                    String content = null;

                    try (BufferedReader r_course = new BufferedReader(new FileReader("course.txt"))) {
                        int row = 0;
                        // it is going to fetch the specified year data course code and name

                        for (int p = 1; p <= Integer.parseInt(year); p++) {
                            content = r_course.readLine();
                        }

                    } catch (Exception e) {
                        System.out.println("add order returns false error 0");
                    }

                    if (content != null) {
                        String[] all_content = content.split(",");
                        String[] course_code = all_content[1].split("/");
                        String[] course_name = all_content[2].split("/");
                        System.out.println(all_content[1] + "   " + all_content[2]);
                        gradeData = studentID + "," + studentYear + ",";
                        for (int i = 0; i < t_course; i++) {
                            course = new OtherCourse(course_code[i], course_name[i]);
                            String other_score = ((course.addStudentScore()).split(","))[2];
                            // gradeData = gradeData +other_score;
                            if (i == (t_course - 1)) {
                                gradeData = gradeData + other_score + "," + formated_credit + "\n";
                            } else {
                                gradeData = gradeData + other_score + "/";
                            }

                        } // end for loop
                    } // end if content

                } // end else

                // writting in to a student
                if (!senior) {
                    try (BufferedWriter w_student = new BufferedWriter(new FileWriter("student.txt", true))) {
                        w_student.write(studentID + "," + studentName + "," + studentGender + "\n");
                    } catch (Exception e) {
                        System.out.println("add oreder returns false error 0");
                    }
                }

                try (BufferedWriter w_grade = new BufferedWriter(new FileWriter("grade.txt", true))) {
                    w_grade.write(gradeData);
                } catch (Exception e) {

                    System.out.println("add oreder returns false error 0");
                }

            } catch (Exception e) {
                System.out.println("add oreder returns false error 1");
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
        return true;
    }

}// closing grading class
