import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO{
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

    public boolean addStudent(int roll_number, String name) throws SQLException {
        String query = "INSERT INTO studs VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, roll_number);
        ps.setString(2, name);
        int rows_affected = ps.executeUpdate();
        return rows_affected > 0;
    }

    public boolean deleteStudent(int roll_number) throws SQLException {
        String query = "DELETE FROM studs WHERE roll_number = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, roll_number);
        int rows_affected = ps.executeUpdate();
        return rows_affected > 0;
    }

    public Student updateStudentName(int roll_number, String name) throws SQLException {
        String query = "UPDATE studs SET name = ? WHERE roll_number = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, name);
        ps.setInt(2, roll_number);
        ps.executeUpdate();
        return new Student(roll_number, name);
    }

}
