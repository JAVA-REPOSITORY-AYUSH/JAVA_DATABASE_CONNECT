// src/main/java/com/example/DatabaseUtils.java


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_CONNECT {

    private static final String URL = "jdbc:mysql://localhost:3306/students";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    static {
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("JDBC Driver loaded successfully.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("JDBC Driver class not found: " + e.getMessage(), e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
