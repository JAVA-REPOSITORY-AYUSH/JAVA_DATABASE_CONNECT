
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        try  {
            //all db related operations in this try
            connection = DB_CONNECT.getConnection();
            System.out.println("Connected to the database successfully.");

            //fetching from db
            StudentDAO student_dao = new StudentDAO(connection);
            Student dummy = student_dao.getStudentByRollNumber(1);
            System.out.println(dummy.name + " " + dummy.roll_number);

            //adding into the database
            System.out.println(student_dao.addStudent(198, "chirag") + " : " + "succesfully added student");

            //deleting from the database
            System.out.println(student_dao.deleteStudent(198)  + " : " + "succesfully deleted student");

            //updating the database
            Student updated_student_entry = student_dao.updateStudentName(1, "new john");
            System.out.println( updated_student_entry.roll_number + " " + updated_student_entry.name  + " : " + "succesfully updated student");

        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }


    }
}


