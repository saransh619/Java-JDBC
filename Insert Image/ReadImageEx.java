import java.sql.*;
import java.io.*;
public class ReadImageEx
{
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/himalaya","root","");
        PreparedStatement ps = con.prepareStatement("Select * from Student where Roll=?");
        ps.setInt(1,122); //here 122 is Roll no.

        ResultSet rs = ps.executeQuery();
        while(rs.next())
        {
            System.out.println("Roll = " + rs.getInt(1) + " Name = " + rs.getString(2) + " Address = " + rs.getString(3));
            Blob b = rs.getBlob(4);
            byte [] brr = b.getBytes(1,(int)b.length());
            FileOutputStream out = new FileOutputStream("me.jpg");
            out.write(brr);
        }
        con.close();
        System.out.println("Successfully read BLOB");
    }
}