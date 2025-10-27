import java.sql.*;
import java.util.*;

public class CollegeAdmissionSystem {
    private static final String URL = "jdbc:mysql://localhost:3306/college_addmission";
    private static final String USER = "root";
    private static final String PASSWORD = "Usha@2412";  // change this

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);
             Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ Connected to Database!");

            while (true) {
                System.out.println("\n===== College Admission System =====");
                System.out.println("1. Register Student");
                System.out.println("2. Add Course");
                System.out.println("3. Apply for Course");
                System.out.println("4. Process Admissions (by Cutoff)");
                System.out.println("5. View Admission List");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> registerStudent(con, sc);
                    case 2 -> addCourse(con, sc);
                    case 3 -> applyForCourse(con, sc);
                    case 4 -> processAdmissions(con);
                    case 5 -> viewAdmissions(con);
                    case 6 -> {
                        System.out.println("👋 Exiting...");
                        return;
                    }
                    default -> System.out.println("❌ Invalid choice!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        // 1️⃣ Register Student
        private static void registerStudent(Connection con, Scanner sc) throws SQLException {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter marks: ");
            int marks = sc.nextInt();

            String sql = "INSERT INTO students (name, marks) VALUES (?, ?)";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, name);
                ps.setInt(2, marks);
                ps.executeUpdate();
                System.out.println("✅ Student Registered Successfully!");
            }
        }

        // 2️⃣ Add Course
        private static void addCourse(Connection con, Scanner sc) throws SQLException {
            System.out.print("Enter course name: ");
            String course = sc.nextLine();
            System.out.print("Enter cutoff marks: ");
            int cutoff = sc.nextInt();

            String sql = "INSERT INTO courses (course_name, cutoff_marks) VALUES (?, ?)";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, course);
                ps.setInt(2, cutoff);
                ps.executeUpdate();
                System.out.println("✅ Course Added!");
            }
        }

        // 3️⃣ Apply for Course
        private static void applyForCourse(Connection con, Scanner sc) throws SQLException {
            System.out.print("Enter student ID: ");
            int sid = sc.nextInt();
            System.out.print("Enter course ID: ");
            int cid = sc.nextInt();

            String sql = "INSERT INTO applications (student_id, course_id) VALUES (?, ?)";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, sid);
                ps.setInt(2, cid);
                ps.executeUpdate();
                System.out.println("✅ Application Submitted!");
            }
        }

        // 4️⃣ Process Admissions
        private static void processAdmissions(Connection con) throws SQLException {
            String sql = """
            SELECT s.id AS student_id, s.name, s.marks, c.course_name, c.cutoff_marks
            FROM applications a
            JOIN students s ON a.student_id = s.id
            JOIN courses c ON a.course_id = c.id
        """;

            try (Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery(sql)) {

                while (rs.next()) {
                    int sid = rs.getInt("student_id");
                    int marks = rs.getInt("marks");
                    int cutoff = rs.getInt("cutoff_marks");
                    String status = marks >= cutoff ? "Approved" : "Rejected";

                    PreparedStatement ps = con.prepareStatement("UPDATE students SET status = ? WHERE id = ?");
                    ps.setString(1, status);
                    ps.setInt(2, sid);
                    ps.executeUpdate();
                }
                System.out.println("✅ Admissions processed successfully!");
            }
        }

        // 5️⃣ View Admission List
        private static void viewAdmissions(Connection con) throws SQLException {
            String sql = "SELECT * FROM students";
            try (Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery(sql)) {

                System.out.println("\n=== Admission List ===");
                while (rs.next()) {
                    System.out.printf("ID: %d | Name: %s | Marks: %d | Status: %s%n",
                            rs.getInt("id"), rs.getString("name"),
                            rs.getInt("marks"), rs.getString("status"));
                }
            }
        }
    }


