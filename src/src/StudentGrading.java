package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentGrading {

    public static BatchStudent batch;
    public Grading grading;

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

    public static void addStudent(BatchStudent batch) {
        Scanner scanner = new Scanner(System.in);
        String id, name, gender;
        int year;
        System.out.println("ENTER LEARNING YEAR (1-5) :");
        year = scanner.nextInt();
        while (year > 5 && year < 1) {
            System.out.println("ENTER LEARNING YEAR ONLY(1-5) :");
            year = scanner.nextInt();
        }
        if (year == 1) {
            System.out.println("ENTER STUDENT NAME :");
            name = scanner.next();
            System.out.println("PLEASE ENTER STUDENT GENDER(M/F) :");
            gender = scanner.next();
            while ((gender == "M" || gender == "m" || gender == "F" || gender == "f")) {
                System.out.println("PLEASE ENTER STUDENT GENDER ONLY(M/F) :");
                gender = scanner.next();
            }
            batch = new BatchStudent("0", name, "" + year, gender);
            batch.addStudentGrade();
        } else {
            boolean isValid = false;

            try {
                System.out.println("ENTER ID :");
                id = "" + scanner.next();
                isValid = checkValidId(id);
                // check if the student has grade on the specified year.

                int max = 0;
                while (!isValid && max != 3) {
                    System.out.println("PLEASE ENTER VALID ID :");
                    id = scanner.nextLine();
                    isValid = checkValidId(id);
                    System.out.println(isValid);
                    if (max == 3) {
                        System.out.println("max limit imit.");
                        break;
                    }
                    max++;
                }
                if (isValid) {
                    // check if the specified student has been graded
                    try (BufferedReader r = new BufferedReader(new FileReader("grade.txt"))) {

                        String line;
                        while ((line = r.readLine()) != null) {
                            String[] data = line.split(",");

                            if (data[0].equals(id) && data[1].equals("" + year)) {
                                System.out.println("UNFORTUNATELY THE DATA HAS BEEN ENTERD BEFORE!");
                                System.out.println("DO YOU WANT TO EDIT THE DATA (Y/N) :");
                                Scanner s = new Scanner(System.in);
                                String in = s.nextLine();
                                if (in.equals("y") || in.equals("Y")) {
                                    editScore();
                                    return;
                                } else {
                                    return;
                                }
                            }
                        }
                    } catch (Exception e) {
                    }

                    try (BufferedReader reader = new BufferedReader(new FileReader("student.txt"))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            String[] studentData = line.split(",");
                            String the_id = (String) studentData[0];

                            if (the_id.equals(id)) {

                                name = (String) studentData[1];
                                gender = (String) studentData[2];
                                batch = new BatchStudent(id, name, "" + year, gender);
                                batch.addStudentGrade();
                                break;
                            }
                        }
                    } catch (Exception e) {
                    }

                }
            } catch (Exception e) {
            }
        }

    }

    //////////////////////////////////////////////////

    public static void editScore() {
        String id, year;
        boolean valid = false;
        int trial = 0;
        System.out.println("+++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++");
        System.out.println("++++                            +++++++");
        System.out.println("+++YOU HAVE ENTERED THE EDITING MOOD.+++");
        System.out.println("++++                            +++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++");

        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER ID TO EDIT :");
        id = legalId();

        if (id != null) {
            System.out.println("WHICH YEAR DO YOU WANT TO EDIT :");
            year = legalYear(id);
            if (year != null) {
                try (BufferedReader read = new BufferedReader(new FileReader("grade.txt"))) {
                    String line;
                    while ((line = read.readLine()) != null) {
                        String[] data = line.split(",");

                        if (data[0].equals(id)) {
                            System.out.println("YOU ARE IN THE EDITING INERFACE AND BE CAREFUL WITH THE EDITING!");
                            // ''''''''''''''''''''''''''''''''''''''''''''''
                        }
                    }

                } catch (Exception e) {
                }

            } // if year
        } // if id
    }
    ///////////////////////////////////////////////////////

    public static boolean checkValidId(String check_id) {
        String id;
        boolean valid;
        try (BufferedReader reader = new BufferedReader(new FileReader("student.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] studentData = line.split(",");
                id = (String) studentData[0];

                if (id.equals(check_id)) {
                    return true;
                }
            }
        }

        catch (Exception e) {
            return false;
        }
        return false;

    }

    public static String claclulateGPA(String id, String year) {
        double tgpa = 0;
        double tch = 0;
        double tpoint = 0;
        boolean found = false;
        try (BufferedReader cgpa_reader = new BufferedReader(new FileReader("grade.txt"))) {

            String line;

            while ((line = cgpa_reader.readLine()) != null && !found) {
                String[] ids = (line.split(","));

                if (ids[0].equals(id) && ids[1].equals(year)) {
                    String[] sco = ids[2].split("/");
                    String[] cre = ids[3].split("/");
                    for (int p = 0; p < sco.length; p++) {
                        tpoint = tpoint + (Double.parseDouble(sco[p]) * Double.parseDouble(cre[p]));
                        tch = tch + Double.parseDouble(cre[p]);
                    }
                    found = true;
                    // tgpa = tgpa + (Double.parseDouble(ids[3]));
                    // tch += (Double.parseDouble(ids[4]));
                }

            }

        } catch (Exception e) {
        }
        // returns format total_point,total_credit,gpa
        return "" + tpoint + "," + tch + "," + (tpoint / tch);
        // System.out.println("tpoint:"+tpoint);
        // System.out.println(("tch:"+tch));
        // System.out.println("gpa:"+(tpoint/tch));

    }

    // return ""+cgpa_total_points+","+cgpa_total_credit+","+cgpa;
    public static String claclulateCGPA(String id) {
        double gpa = 0;
        double tgpa = 0;
        double tch = 0;
        double tpoint = 0;
        double cgpa_total_points = 0;
        double cgpa_total_credit = 0;
        double cgpa = 0;
        boolean found = false;
        try (BufferedReader cgpa_reader = new BufferedReader(new FileReader("grade.txt"))) {

            String line;

            while ((line = cgpa_reader.readLine()) != null) {
                String[] ids = (line.split(","));

                if (ids[0].equals(id)) {
                    String yr = ids[1];

                    String[] cre = ids[3].split("/");
                    String[] sco = ids[2].split("/");
                    for (int p = 0; p < sco.length; p++) {

                        tpoint = tpoint + (Double.parseDouble(sco[p]) * Double.parseDouble(cre[p]));
                        tch = tch + Double.parseDouble(cre[p]);
                    }
                    gpa = (tpoint / tch);
                    cgpa_total_points = cgpa_total_points + (gpa * tch);
                    cgpa_total_credit = cgpa_total_credit + tch;
                    // tgpa = tgpa + (Double.parseDouble(ids[3]));
                    // tch += (Double.parseDouble(ids[4]));
                }

            }
            cgpa = cgpa_total_points / cgpa_total_credit;
        } catch (Exception e) {
        }
        return "" + cgpa_total_points + "," + cgpa_total_credit + "," + cgpa;
        // System.out.println("cgpa_total_points:"+cgpa_total_points);
        // System.out.println(("cgpa_total_credit:"+cgpa_total_credit));
        // System.out.println("cgpa:"+cgpa);

    }

    ///////////////////////////////////////////////////////

    public static String legalId() {
        String i;
        Scanner s = new Scanner(System.in);
        System.out.println("ENTER ID :");
        i = s.nextLine();
        int max = 0;
        boolean valid = checkValidId(i);
        while (!valid && max != 3) {
            System.out.println("PLEASE ENTER VALID ID :");
            i = s.nextLine();
            max++;
            valid = checkValidId(i);
        }
        if (valid)
            return i;
        else
            return null;
    }

    //////////////////////////////////////////////////////////
    public static String legalYear(String ids) {

        try (BufferedReader rr = new BufferedReader(new FileReader("grade.txt"))) {
            Scanner scan = new Scanner(System.in);
            String current = null, year;
            int trial = 0;
            System.out.println("ENTER STUDENT YEAR :");
            year = scan.nextLine();
            while ((current = rr.readLine()) != null && trial != 3) {
                String[] data = current.split(",");
                if (ids.equals(data[0]) && year.equals(data[1])) {
                    return year;
                }
                System.out.println("PLEASE ENTER ACADAMIC YEAR :");
                year = scan.nextLine();
                trial++;
            }

        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public static void displayAll() {
        String cline = "";
        try (BufferedReader c_reader = new BufferedReader(new FileReader("course.txt"))) {
            String cur;
            while ((cur = c_reader.readLine()) != null) {
                cline = cline + cur + System.getProperty("line.separator");
            }
        } catch (Exception e) {
        }

        for (int b = 1; b <= 5; b++) {

            try (BufferedReader g_reader = new BufferedReader(new FileReader("grade.txt"))) {
                String current_grade, name = "", gender = "", id = "";
                System.out.println("ACADAMIC YEAR : " + b);
                System.out.println();
                System.out.print("ID\tNAME\tGENDER\t\t");
                String[] c = cline.split("\n");

                // prints the course code
                System.out.print(displayGrade(((c[b]).split(","))[1]));
                System.out.print("POINT\tCREDIT\tGPA\t\n");
                while ((current_grade = g_reader.readLine()) != null) {
                    String[] line_grade = current_grade.split(",");
                    if (line_grade[1].equals("" + b)) {
                        BufferedReader s_reader = new BufferedReader(new FileReader("student.txt"));
                        String line;
                        while ((line = s_reader.readLine()) != null) {
                            if ((line.split(","))[0].equals(line_grade[0])) {
                                name = line.split(",")[1];
                                gender = line.split(",")[2];
                                id = line_grade[0];
                                break;
                            }
                        }

                        System.out.println("----------------------------------------");

                        if (gender.equals("m") || gender.equals("M")) {
                            gender = "MALE";
                        } else {
                            gender = "FEMALE";
                        }
                        System.out.print(id + "\t" + name + "\t" + gender + "\t\t");
                        String grade = displayGrade(line_grade[2]);
                        String[] gpa = claclulateGPA(line_grade[0], line_grade[1]).split(",");
                        System.out.print(grade + gpa[0] + "\t" + gpa[1] + "\t" + gpa[2] + "\t");
                        System.out.print("\n===============================================\n");
                    }

                }
            } catch (Exception e) {
            }
        }

        /*
         * try(BufferedReader reader = new BufferedReader(new
         * FileReader("student.txt"))){
         * String current;
         * while((current = reader.readLine()) != null){
         * String []line = current.split(",");
         * for(int i = 0;i<line.length; i++){
         * System.out.print(line[i]+"\t");
         * }}
         * 
         * }catch(Exception e){}
         */
    }

    public static void displayGrade(String idd, String year) {
        String name = "";
        String gender = "";
        String id = "";
        String grade_collect = "";
        String cgpa;
        id = idd;

        try (BufferedReader s_read = new BufferedReader(new FileReader("student.txt"))) {
            String line;
            while ((line = s_read.readLine()) != null) {
                if ((line.split(","))[0].equals(id)) {
                    name = line.split(",")[1];
                    gender = line.split(",")[2];
                    break;
                }
            }
            System.out.println("\n\n");
            System.out.println("=====================================");
            System.out.println("=====================================");
            if (gender.equals("m") || gender.equals("M")) {
                gender = "MALE";
            } else {
                gender = "FEMALE";
            }
            System.out.println("ID :" + id + "\tNAME :" + name + "\tGENDER :" + gender);
            System.out.println("-------------------------------------");
        } catch (Exception e) {
            System.out.println("SORRY THE SPECIFIED ID DOES NOT HAVE VALUE.");
        }

        try (BufferedReader s_read = new BufferedReader(new FileReader("course.txt"))) {
            String current, ccode = "", cname;
            boolean found = false;
            while ((current = s_read.readLine()) != null && !found) {
                String[] line = current.split(",");
                if (line[0].equals(year)) {
                    found = true;
                    ccode = displayGrade(line[1]);
                    cname = displayGrade(line[2]);
                    break;
                }
            }
            if (found) {
                System.out.println("ACADAMIC YEAR : " + year + "\n");
                System.out.println(ccode + " POINT\t" + "CREDIT H.\t" + "GPA\t");
            }
        } catch (Exception e) {
            System.out.println("SORRY THE SPECIFIED ID DOES NOT HAVE VALUE.");
        }
        try (BufferedReader s_read = new BufferedReader(new FileReader("grade.txt"))) {
            String current;

            while ((current = s_read.readLine()) != null) {
                String[] word = current.split(",");
                if (word[0].equals(idd) && word[1].equals(year)) {
                    String grade = displayGrade(word[2]);
                    String[] gpa = claclulateGPA(idd, year).split(",");

                    System.out.println(grade + gpa[0] + "\t" + gpa[1] + "\t  " + gpa[2]);

                }
            }
            System.out.println("===============================================================");
            String[] ccgpa = claclulateCGPA(idd).split(",");
            System.out.println("CGPA OF STUDENT");
            System.out.println("POINT\tCREDIT H.\tGPA\t");
            System.out.println(ccgpa[0] + "\t" + ccgpa[1] + "\t  " + ccgpa[2]);
            System.out.println("===============================================================");

        } catch (Exception e) {
        }

        /////////////////////////////////
        ////////////////////////////////
        ///////////////////////////////
        /////////////////////////////////
        /////////////////////////////////////

        // String[] da = data[j].split(",");

    }

    public static String displayGrade(String data) {
        String line = "";
        String[] word = data.split("/");
        for (int i = 0; i < word.length; i++) {
            line = line + word[i] + "\t";
        }
        return line;
    }

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
                        addStudent(batch);
                        // System.out.println("add a new studnt.");
                        break;
                    case 2:
                        // EDIT STUDENT SCORE
                        // editScore();
                        // System.out.println("edit the student file");
                        break;
                    case 3:
                        // DISPLAY GRADE

                        break;
                    // System.out.println("displays a single student grade");

                    case 4:
                        // DISPLAY GRADE
                        // System.out.println("display all student grade.");

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
