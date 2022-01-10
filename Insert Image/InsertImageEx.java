import java.sql.*;
import java.io.*;
public class InsertImageEx
{
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/himalaya","root","");
        PreparedStatement ps = con.prepareStatement("insert into Student values(?,?,?,?)");
        ps.setInt(1,122);
        ps.setString(2,"Saurabh");
        ps.setString(3,"Kirtipur");
        FileInputStream fin = new FileInputStream("Saransh.jpeg");
        ps.setBinaryStream(4, fin,fin.available());
        int row = ps.executeUpdate();
        if(row > 0){
            System.out.println("Image Inserted");
        }
        else{
            System.out.println("Image Not Inserted");
        }
        con.close();    
    }
}
