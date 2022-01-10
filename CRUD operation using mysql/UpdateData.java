import java.sql.*;
public class UpdateData {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/himalaya", "root", "");
        Statement stmt = con.createStatement();
        String sql = "update Student set Name='Hari' where Roll='102'";
        int row = stmt.executeUpdate(sql);
        if(row > 0) {
            System.out.println("Row 1 updated successfully");
        }else{
            System.out.println("Error in update");
        }
        con.close();
    }
}
