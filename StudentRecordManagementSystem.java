package StudentRecordManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentRecordManagementSystem {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("******** Student Record Management System *********");
        System.out.println("1. Add Student");
        System.out.println("2. View Student");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");
        boolean running = true;
        while (running) {
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("\nEnter Student ID: ");
                    int Id = scanner.nextInt();
                    System.out.print("Enter student Name: ");
                    String name = scanner.next();
                    System.out.print("Enter student marks: ");
                    double marks = scanner.nextDouble();
                    Student student = new Student(Id, name, marks);
                    students.add(student);
                    System.out.println("\nStudent added successfuly.");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        System.out.println("**** Student List ****");
                        for (Student s : students)
                            System.out.println(s);
                    }
                    break;

                case 3:
                    System.out.print("Enter id to update");
                    int uId = scanner.nextInt();
                    scanner.nextLine();
                    boolean updated = students.stream().anyMatch(s -> s.getId() == uId);
                    if (updated) {
                        System.out.print("Enter new name: ");
                        String Uname = scanner.nextLine();
                        System.out.print("Enter new marks: ");
                        double Umarks = scanner.nextDouble();

                    } else {
                        System.out.println("Student not found.");
                    }


                    if (!updated) System.out.println("Student not found.");
                    break;

                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    int DId = scanner.nextInt();
                    boolean removed = students.removeIf(s -> s.getId() == DId);
                    if (removed)
                        System.out.println("Student deleted successfully.");
                    else
                        System.out.println("Student not found.");
                    break;

                case 5:
                    running = false;
                    System.out.println("Existing from this program....");
                    break;


                default:
                    System.out.println("Invalid number. Please try again.");


            }

        }

        scanner.close();

    }


}
