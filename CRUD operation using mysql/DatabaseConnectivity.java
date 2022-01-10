import java.sql.*;
public class DatabaseConnectivity{
        
        public static void main(String[] args) throws Exception {
            
            // 1. Register driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // 2. Get connection or create connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/himalaya", "root", "");
            
            // 3. Create statement
            Statement stmt = conn.createStatement();
            String sql = "select * from Student";
            
            // 4. Execute query
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Roll"+"\t"+"Name"+"\t"+"Address");
            
            // 5. Process result
            while(rs.next()){
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
            }
            System.out.println("Database Connectivity");

            // 6. Close connection
            conn.close();
        }
}