import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    String department;

    Student(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
}

public class Main {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. List Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                addStudent();
            } else if (choice == 2) {
                listStudents();
            } else if (choice == 3) {
                deleteStudent();
            } else if (choice == 4) {
                System.out.println("Program closed.");
            } else {
                System.out.println("Invalid choice.");
            }

        } while (choice != 4);
    }

    static void addStudent() {
        System.out.print("Enter student ID: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Enter student name: ");
        String name = input.nextLine();

        System.out.print("Enter department: ");
        String department = input.nextLine();

        students.add(new Student(id, name, department));
        System.out.println("Student added successfully.");
    }

    static void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : students) {
                System.out.println("ID: " + student.id + 
                                   ", Name: " + student.name + 
                                   ", Department: " + student.department);
            }
        }
    }

    static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = input.nextInt();

        boolean found = false;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id == id) {
                students.remove(i);
                found = true;
                System.out.println("Student deleted successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }
}
