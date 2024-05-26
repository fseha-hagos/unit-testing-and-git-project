package src;

import java.util.InputMismatchException;
import java.util.Scanner;

abstract class Course {
    private String courseCode;
    private String courseName;

    public Course(String c, String n) {
        courseCode = c;
        courseName = n;
    }

    abstract String addStudentScore();

    // setter methods
    public void setCourseCode(String code) {
        courseCode = code;
    }

    public void setCourseName(String name) {
        courseCode = name;
    }

    // getter methods
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

}

class ProgrammingCourse extends Course {
    Scanner scanner = new Scanner(System.in);

    public ProgrammingCourse(String code, String name) {
        super(code, name);
    }

    public String addStudentScore() {

        double score = 0;
        boolean right = false;
        String c_code = super.getCourseCode();
        String c_name = super.getCourseName();
        while (!right) {
            try {
                System.out.print("Programming (1-4) : ");
                score = scanner.nextDouble();

                if (score > 0 && score <= 100)
                    right = true;
                if (score < 50) {
                    score = 1;
                } else if (score < 65) {
                    score = 2;
                } else if (score < 80) {
                    score = 3;
                } else if (score <= 100) {
                    score = 4;
                }
            }

            catch (InputMismatchException e) {
                System.out.print("please enter between (1-4) : ");
                scanner.nextLine();
            }
        }

        return (c_code + "," + c_name + "," + score);
    }
}

class ComputerNetworkingCourse extends Course {
    Scanner scanner = new Scanner(System.in);

    public ComputerNetworkingCourse(String code, String name) {
        super(code, name);
    }

    public String addStudentScore() {

        double score = 0;
        boolean right = false;
        String c_code = super.getCourseCode();
        String c_name = super.getCourseName();
        while (!right) {
            try {
                System.out.print("Computer Networking (1-4) : ");
                score = scanner.nextDouble();
                if (score > 0 && score <= 100)
                    right = true;

            } catch (InputMismatchException e) {
                System.out.print("please enter between (1-4) : ");
                scanner.nextLine();
            }
        }

        if (score < 50) {
            score = 1;
        } else if (score < 65) {
            score = 2;
        } else if (score < 80) {
            score = 3;
        } else if (score <= 100) {
            score = 4;
        }
        return (c_code + "," + c_name + "," + score);
    }
}

class COACourse extends Course {
    Scanner scanner = new Scanner(System.in);

    public COACourse(String code, String name) {
        super(code, name);
    }

    public String addStudentScore() {

        double score = 0;
        boolean right = false;
        String c_code = super.getCourseCode();
        String c_name = super.getCourseName();
        while (!right) {
            try {
                System.out.print("COA (1-4) : ");
                score = scanner.nextDouble();
                if (score > 0 && score <= 100)
                    right = true;
                if (score < 50) {
                    score = 1;
                } else if (score < 65) {
                    score = 2;
                } else if (score < 80) {
                    score = 3;
                } else if (score <= 100) {
                    score = 4;
                }
            } catch (InputMismatchException e) {
                System.out.print("please enter between (1-4) : ");
                scanner.nextLine();
            }
        }

        return (c_code + "," + c_name + "," + score);
    }
}

class OperatingSystemCourse extends Course {
    Scanner scanner = new Scanner(System.in);

    public OperatingSystemCourse(String code, String name) {
        super(code, name);
    }

    public String addStudentScore() {

        double score = 0;
        boolean right = false;
        String c_code = super.getCourseCode();
        String c_name = super.getCourseName();
        while (!right) {
            try {
                System.out.print("Operating System (1-4) : ");
                score = scanner.nextDouble();

                if (score > 0 && score <= 100)
                    right = true;
                if (score < 50) {
                    score = 1;
                } else if (score < 65) {
                    score = 2;
                } else if (score < 80) {
                    score = 3;
                } else if (score <= 100) {
                    score = 4;
                }
            } catch (InputMismatchException e) {
                System.out.print("please enter between (1-4) : ");
                scanner.nextLine();
            }
        }

        return (c_code + "," + c_name + "," + score);
    }
}

class OtherCourse extends Course {
    Scanner scanner = new Scanner(System.in);

    public OtherCourse(String code, String name) {
        super(code, name);
    }

    public String addStudentScore() {

        double score = 0;
        boolean right = false;
        String c_code = super.getCourseCode();
        String c_name = super.getCourseName();
        while (!right) {
            try {
                System.out.print(c_name + " (1-4) : ");
                score = scanner.nextDouble();

                if (score > 0 && score <= 100)
                    right = true;

                if (score < 50) {
                    score = 1;
                } else if (score < 65) {
                    score = 2;
                } else if (score < 80) {
                    score = 3;
                } else if (score <= 100) {
                    score = 4;
                }

            } catch (InputMismatchException e) {
                System.out.print("please enter between (1-4) : ");
                scanner.nextLine();
            }
        }

        return (c_code + "," + c_name + "," + score);
    }
}