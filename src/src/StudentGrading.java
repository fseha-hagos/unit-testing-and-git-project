package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class StudentGrading {

    ///////////////////////////////////////////////////
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // check if course file fills and if not fills it.

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
