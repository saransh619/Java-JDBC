import java.sql.*;
public class ScrollEx{
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/himalaya","root","");
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        String sql = "select * from Student";
        ResultSet rs = st.executeQuery(sql);
        System.out.println("Roll \t Name \t Address");
        // while(rs.next()){
        //     System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
        // }
        rs.absolute(3);
        System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
        rs.previous();
        System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
        rs.absolute(5);
        System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
        con.close();
    }
}