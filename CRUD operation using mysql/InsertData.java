import java.sql.*;

public class InsertData {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/himalaya", "root", "");
            // Statement stmt = con.createStatement();
            // String sql = "INSERT INTO Student VALUES (103, 'John', 'California')";

            // alternative way
            PreparedStatement pstmt = con.prepareStatement("insert into student values(?,?,?)");
            pstmt.setInt(1, 130);
            pstmt.setString(2, "Rock");
            pstmt.setString(3, "California");
            int row = pstmt.executeUpdate();
            // int row = stmt.executeUpdate(sql);
            if (row > 0) {
                System.out.println("Row 1 inserted");
            } else {
                System.out.println("Error in insertion");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}