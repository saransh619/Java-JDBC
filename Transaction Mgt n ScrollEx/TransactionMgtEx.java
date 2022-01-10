import java.sql.*;

public class TransactionMgtEx {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/himalaya", "root", "");
            con.setAutoCommit(false);
            Statement stmt = con.createStatement();
            stmt.executeUpdate("insert into Student values (145, 'Hari', 'Nepalgunj')");
            stmt.executeUpdate("insert into Student values (146, 'Sita', 'Dang')");
            con.commit();
            System.out.println("Database insertion");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}