import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        try  {
            connection = DB_CONNECT.getConnection();
            System.out.println("Connected to the database successfully.");

            // Perform database operations here...

        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }

        StudentDAO student_dao = new StudentDAO(connection);
        Student dummy = student_dao.getStudentByRollNumber(1);
        System.out.println(dummy.name + " " + dummy.roll_number);

    }
}

class StudentDAO{
    Connection conn;
    public StudentDAO(Connection conn){
        this.conn = conn;
    }


    public Student getStudentByRollNumber(int roll_number) throws SQLException {
        String query = "SELECT * FROM studs WHERE roll_number = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, roll_number);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return new Student(rs.getInt("roll_number"), rs.getString("name"));
    }

}

class Student{
    int roll_number;
    String name;

    public Student(int roll_number, String name) {
        this.roll_number = roll_number;
        this.name = name;
    }
}