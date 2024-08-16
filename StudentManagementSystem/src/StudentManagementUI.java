
import java.util.Scanner;

public class StudentManagementUI {
    private StudentManagementSystem managementSystem;
    private Scanner scanner;

    public StudentManagementUI() {
        managementSystem = new StudentManagementSystem();
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add a new student");
            System.out.println("2. Remove a student");
            System.out.println("3. Search for a student");
            System.out.println("4. Display all students");
            System.out.println("5. Edit a student's details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    editStudent();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    private void addStudent() {
        System.out.print("Enter student's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student's roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter student's grade: ");
        String grade = scanner.nextLine();

        Student student = new Student(name, rollNumber, grade);
        managementSystem.removeStudent(student);
    }

    private void removeStudent() {
        System.out.print("Enter student's roll number to remove: ");
        int rollNumber = scanner.nextInt();
        managementSystem.removeStudent(rollNumber);
    }

    private void searchStudent() {
        System.out.print("Enter student's roll number to search: ");
        int rollNumber = scanner.nextInt();
        Student student = managementSystem.searchStudent(rollNumber);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private void displayAllStudents() {
        managementSystem.displayAllStudents();
    }

    private void editStudent() {
        System.out.print("Enter student's roll number to edit: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter student's new name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter student's new grade: ");
        String newGrade = scanner.nextLine();

        managementSystem.editStudent(rollNumber, newName, newGrade);
    }

    public static void main(String[] args) {
        StudentManagementUI ui = new StudentManagementUI();
        ui.showMenu();
    }
}