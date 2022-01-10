import java.sql.*;
public class DeleteData {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/himalaya", "root", "");
        Statement stmt = con.createStatement();
        String sql = "Delete from Student where Roll='103'";
        int row = stmt.executeUpdate(sql);
        if(row > 0) {
            System.out.println("Row 1 deleted successfully");
        }else{
            System.out.println("Error in deletion");
        }
        con.close();
    }
}
