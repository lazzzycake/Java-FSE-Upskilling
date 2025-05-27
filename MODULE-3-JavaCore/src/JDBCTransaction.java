import java.sql.*;

public class JDBCTransaction {

    // Transfer method
    public static void transferMoney(Connection conn, int fromAcc, int toAcc, double amount) {
        try {
            conn.setAutoCommit(false); // Begin transaction

            // Debit from sender
            PreparedStatement debitStmt = conn.prepareStatement(
                "UPDATE accounts SET balance = balance - ? WHERE account_id = ?"
            );
            debitStmt.setDouble(1, amount);
            debitStmt.setInt(2, fromAcc);
            int debitRows = debitStmt.executeUpdate();

            // Credit to receiver
            PreparedStatement creditStmt = conn.prepareStatement(
                "UPDATE accounts SET balance = balance + ? WHERE account_id = ?"
            );
            creditStmt.setDouble(1, amount);
            creditStmt.setInt(2, toAcc);
            int creditRows = creditStmt.executeUpdate();

            if (debitRows == 1 && creditRows == 1) {
                conn.commit(); // All good
                System.out.println("Transaction successful. Transferred Rs." + amount);
            } else {
                conn.rollback(); // Something failed
                System.out.println("Transaction failed. Rolled back.");
            }

        } catch (SQLException e) {
            try {
                conn.rollback(); // Error occurred, rollback
                System.out.println("Error during transaction. Rolled back.");
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                conn.setAutoCommit(true); // Restore default behavior
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String user = "root";
        String pass = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected to the database!");

            // Transfer ₹200 from account 1 to 2
            transferMoney(conn, 1, 2, 200.00);

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
