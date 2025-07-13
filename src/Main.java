import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Delete Student by ID");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();
                    Student student = new Student(id, name, age, course);
                    StudentManager.addStudent(student);
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.println("\n--- All Students ---");
                    for (Student s : StudentManager.getAllStudents()) {
                        System.out.println(s);
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    String searchId = scanner.nextLine();
                    Student found = StudentManager.findStudentById(searchId);
                    if (found != null) {
                        System.out.println("Found: " + found);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    String deleteId = scanner.nextLine();
                    StudentManager.deleteStudentById(deleteId);
                    System.out.println("Student deleted if ID existed.");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}