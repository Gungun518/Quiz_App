package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

    // Database URL, username, and password (change as necessary)
    private static final String URL = "jdbc:mysql://localhost:3306/quiz_app"; // Your database name
    private static final String USER = "root";  // Database username
    private static final String PASSWORD = "";  // Database password

    // Method to get a connection to the database
    public static Connection getConnection() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
