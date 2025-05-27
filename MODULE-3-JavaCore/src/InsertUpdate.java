import java.sql.*;

public class InsertUpdate {
    // Method to insert a student
    public static void insertStudent(Connection connection, String name, int age) {
        String sql = "INSERT INTO students (name, age) VALUES (?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Student inserted successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to insert student.");
            e.printStackTrace();
        }
    }

    // Method to update a student by ID
    public static void updateStudent(Connection connection, int id, String name, int age) {
        String sql = "UPDATE students SET name = ?, age = ? WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setInt(3, id);
            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("No student found with ID: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Failed to update student.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String username = "root";
        String password = "root"; // Your MySQL password

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            // Insert a new student
            insertStudent(connection, "Priya", 22);

            // Update a student
            updateStudent(connection, 1, "Ravi", 21); // Ensure ID 1 exists

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
