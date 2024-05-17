package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentGrading {

    // this functions creats files that can save al the data needed for the student
    // registration system.
    static void createFile() {
        final String STUDENT_FILE = "student.txt";
        final String GRADE_FILE = "grade.txt";
        final String COURSE_FILE = "course.txt";
        try {
            File student_file = new File(STUDENT_FILE);
            File grade_file = new File(GRADE_FILE);
            File course_file = new File(COURSE_FILE);

            if (student_file.createNewFile() && grade_file.createNewFile() && course_file.createNewFile()) {
                System.out.println("The File System is created succesfully!");
            } else {
                System.out.println("File already exists.");
            }
        } catch (Exception e) {
            System.out.println("Sorry thereis some problem on creating the file system!!!");
            System.exit(0);
        }
    }

    ///////////////////////////////////////////////////
    public static void preInputFiles() {
        Scanner scanner = new Scanner(System.in);
        String[] year_one_ccode = { "pr", "cn", "coa", "os" };
        String[] year_one_cname = { "Programming", "Networking", "COA", "Operating" };
        String[] year_one_chour = { "5", "7", "5", "7" };

        String[] year_two_ccode = { "os", "pr", "coa", "net" };
        String[] year_two_cname = { "Operating", "programming", "COA", "networking" };
        String[] year_two_chour = { "4", "4", "4", "4" };

        String[] year_three_ccode = { "net", "coa", "pr", "os" };
        String[] year_three_cname = { "networking", "COA", "programming", "Operating" };
        String[] year_three_chour = { "3", "3", "3", "3" };

        String[] year_four_ccode = { "coa", "pr", "os", "net" };
        String[] year_four_cname = { "COA", "programming", "Operating", "networking" };
        String[] year_four_chour = { "5", "5", "5", "5" };

        String[] year_five_ccode = { "net", "os", "pr", "coa" };
        String[] year_five_cname = { "networking", "Operating", "programming", "COA" };
        String[] year_five_chour = { "4", "4", "4", "4" };

        System.out.println("i hope you will be satisfied...");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out
                .println("\n\nthis form is for the coordinator or the manager to fill the caricullem of all 5 years\n");
        System.out.println("do you want to fill manually or you want it default?");
        System.out.println("1. default         2. manual");

        try {
            Scanner config = new Scanner(System.in);
            try {
                int choise = config.nextInt();
                config.nextLine();
                if (choise == 2) {
                    System.out
                            .println("1,the courses for year one are fixed but you can change fill the credit hours.");
                    System.out
                            .println(
                                    "2,the system needs you to fill the courses and credit houres for each courses in 2-5 years.");

                    boolean forbreaker = false;
                    for (int i = 2; i <= 5 && !forbreaker; i++) {
                        System.out.println("ENTER INFORMATION FOR YEAR: " + i);

                        // scanner
                        boolean right = false, cont = false;
                        int max_trial = 3;
                        int trial = 0;
                        int total_course = 0;

                        while ((total_course > 4 || total_course < 1) && trial != max_trial) {
                            try {
                                System.out.println("ENTER TOTAL NUMBER OF COURSES (1-4): ");
                                total_course = scanner.nextInt();
                                scanner.nextLine();
                                cont = true;

                            } catch (InputMismatchException e) {

                                System.out.println("please enter valid inputs or press z to skip:");
                                trial++;
                                String l = scanner.next();
                                if (l.equals("z")) {
                                    trial = max_trial;
                                    forbreaker = false;
                                    cont = false;
                                    break;
                                }
                                ;
                            }
                        } // end while

                        int index = total_course;
                        trial = 0;
                        while (index > 0 && (trial != max_trial) && cont == true) {
                            try {
                                String course_name, course_code;
                                int credit_hour;
                                System.out.println("enter course name:");
                                course_name = scanner.nextLine();
                                System.out.println("enter course code:");
                                course_code = scanner.nextLine();
                                System.out.println("enter credit hour:");
                                credit_hour = scanner.nextInt();
                                scanner.nextLine();
                                while (credit_hour > 7 || credit_hour < 1) {
                                    System.out.println("credit hour must be between 1 and 7} ");
                                    credit_hour = scanner.nextInt();

                                }
                                if (i == 2) {
                                    year_two_ccode[total_course - index] = course_code;
                                    year_two_cname[total_course - index] = course_name;
                                    year_two_chour[total_course - index] = "" + credit_hour;
                                    index--;
                                } else if (i == 3) {
                                    year_three_ccode[total_course - index] = course_code;
                                    year_three_cname[total_course - index] = course_name;
                                    year_three_chour[total_course - index] = "" + credit_hour;
                                    index--;
                                } else if (i == 4) {
                                    year_four_ccode[total_course - index] = course_code;
                                    year_four_cname[total_course - index] = course_name;
                                    year_four_chour[total_course - index] = "" + credit_hour;
                                    index--;
                                } else if (i == 5) {
                                    year_five_ccode[total_course - index] = course_code;
                                    year_five_cname[total_course - index] = course_name;
                                    year_five_chour[total_course - index] = "" + credit_hour;
                                    index--;
                                }

                                // sooner i will limit the name to 30 characters.
                            } catch (Exception e) {
                                System.out.print("please entervalid inputs or press z to skip: ");
                                trial++;
                                String l = scanner.next();
                                if (l.equals("z")) {
                                    trial = max_trial;
                                    forbreaker = true;
                                    return;
                                }
                                ;
                            }
                        } // end while loop
                    } // end for loop

                } else {
                    System.out.println("you have chosen default thankyou.");
                }
            } catch (Exception e) {
                System.out.println("you enterd wrong character and we make it default.");

            }

        } catch (Exception e) {
        }

        try (BufferedWriter c_writer = new BufferedWriter(new FileWriter("course.txt"))) {
            String one_ccode = "";
            String one_cname = "";
            String one_chour = "";

            String two_ccode = "";
            String two_cname = "";
            String two_chour = "";

            String three_ccode = "";
            String three_cname = "";
            String three_chour = "";

            String four_ccode = "";
            String four_cname = "";
            String four_chour = "";

            String five_ccode = "";
            String five_cname = "";
            String five_chour = "";

            String one = "";
            String two = "";
            String three = "";
            String four = "";
            String five = "";

            for (int k = 0; k < year_one_ccode.length; k++) {
                if (k == year_one_ccode.length - 1) {
                    one_ccode = one_ccode + year_one_ccode[k];
                    one_cname = one_cname + year_one_cname[k];
                    one_chour = one_chour + year_one_chour[k];
                } else {
                    one_ccode = one_ccode + year_one_ccode[k] + "/";
                    one_cname = one_cname + year_one_cname[k] + "/";
                    one_chour = one_chour + year_one_chour[k] + "/";
                }
            }
            one = "1," + one_ccode + "," + one_cname + "," + one_chour + "\n";

            for (int k = 0; k < year_two_ccode.length; k++) {
                if (k == year_two_ccode.length - 1) {
                    two_ccode = two_ccode + year_two_ccode[k];
                    two_cname = two_cname + year_two_cname[k];
                    two_chour = two_chour + year_two_chour[k];
                } else {
                    two_ccode = two_ccode + year_two_ccode[k] + "/";
                    two_cname = two_cname + year_two_cname[k] + "/";
                    two_chour = two_chour + year_two_chour[k] + "/";
                }
            }
            two = "2," + two_ccode + "," + two_cname + "," + two_chour + "\n";

            for (int k = 0; k < year_three_ccode.length; k++) {
                if (k == year_three_ccode.length - 1) {
                    three_ccode = three_ccode + year_three_ccode[k];
                    three_cname = three_cname + year_three_cname[k];
                    three_chour = three_chour + year_three_chour[k];
                } else {
                    three_ccode = three_ccode + year_three_ccode[k] + "/";
                    three_cname = three_cname + year_three_cname[k] + "/";
                    three_chour = three_chour + year_three_chour[k] + "/";
                }
            }
            three = "3," + three_ccode + "," + three_cname + "," + three_chour + "\n";

            for (int k = 0; k < year_four_ccode.length; k++) {
                if (k == year_four_ccode.length - 1) {
                    four_ccode = four_ccode + year_four_ccode[k];
                    four_cname = four_cname + year_four_cname[k];
                    four_chour = four_chour + year_four_chour[k];
                } else {
                    four_ccode = four_ccode + year_four_ccode[k] + "/";
                    four_cname = four_cname + year_four_cname[k] + "/";
                    four_chour = four_chour + year_four_chour[k] + "/";
                }
            }
            four = "4," + four_ccode + "," + four_cname + "," + four_chour + "\n";

            for (int k = 0; k < year_five_ccode.length; k++) {
                if (k == year_five_ccode.length - 1) {
                    five_ccode = five_ccode + year_five_ccode[k];
                    five_cname = five_cname + year_five_cname[k];
                    five_chour = five_chour + year_five_chour[k];
                } else {
                    five_ccode = five_ccode + year_five_ccode[k] + "/";
                    five_cname = five_cname + year_five_cname[k] + "/";
                    five_chour = five_chour + year_five_chour[k] + "/";
                }
            }
            five = "5," + five_ccode + "," + five_cname + "," + five_chour + "\n";
            c_writer.write(one + two + three + four + five);
        } catch (Exception e) {

        }

    }// end function pre input

    ////////////////////////////////////////////////

    public static void main(String[] args) {

        createFile();
        // check if course file fills and if not fills it.

        try (BufferedReader c_reader = new BufferedReader(new FileReader("course.txt"))) {
            String line = c_reader.readLine();
            if (line == null) {
                preInputFiles();
            }
            c_reader.close();

        } catch (Exception e) {
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nStudent Grading System Menu:");
            System.out.println("1. ADD STUDENT SCORE");
            System.out.println("2. EDIT STUDENT SCORE");
            System.out.println("3. DISPLAY GRADE");
            System.out.println("4. DISPLAY ALL");
            System.out.println("5. DELETE STUDENT");
            System.out.println("6. EXIT");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                // Consume the newline character

                switch (choice) {
                    case 1:
                        // ADD STUDENT SCORE"
                        // addStudent();
                        System.out.println("add a new studnt.");
                        break;
                    case 2:
                        // EDIT STUDENT SCORE
                        // editScore();
                        System.out.println("edit the student file");
                        break;
                    case 3:
                        // DISPLAY GRADE
                        System.out.println("displays a single student grade");
                        break;
                    case 4:
                        // DISPLAY GRADE
                        System.out.println("display all student grade.");
                        // displayAll();
                        break;
                    case 5:
                        // DELETE STUDENT
                        // deleteAccount();
                        System.out.println("deletes a studetn from the file");
                        break;
                    case 6:
                        System.out.println("Exiting Student Grading System. Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Enter Any Key To Continue.");
                }
                String a = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("PLEASE ENTER A VALID NUMBER 1-7.");
                String a = scanner.nextLine();
            }
        }
    }
}
