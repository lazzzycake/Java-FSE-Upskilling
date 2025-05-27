import java.sql.*;

public class JDBCExample {
    public static void main(String[] args) {
        // Replace these with your actual DB details
        String url = "jdbc:mysql://localhost:3306/jdbc_demo"; // Your database name
        String username = "root"; // Your MySQL username
        String password = "root";     // Your MySQL password (keep it empty if there is no password)

        try {
            // Load the JDBC driver (optional for newer Java versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println(" Connected to the database!");

            // Query the students table
            String query = "SELECT * FROM students";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Loop through the results
            while (rs.next()) {
                int id = rs.getInt("id");           // Assuming 'id' is an integer column
                String name = rs.getString("name"); // Assuming 'name' is a varchar column
                int age = rs.getInt("age");         // Assuming 'age' is an integer column

                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }

            // Close connections
            rs.close();
            stmt.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection or Query failed.");
            e.printStackTrace();
        }
    }
}
