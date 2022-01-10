import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class InsertDemo{
    JFrame f;
    JLabel r1,n1,a1;
    JTextField tr,tn,ta;
    JButton btn;

    public InsertDemo(){
        f = new JFrame("Insert Demo");
        r1 = new JLabel("Roll");
        n1 = new JLabel("Name");
        a1 = new JLabel("Address");
        tr = new JTextField(15);
        tn = new JTextField(15);
        ta = new JTextField(15);
        btn = new JButton("Insert");
        f.add(r1);f.add(tr);f.add(n1);f.add(tn);f.add(a1);f.add(ta);f.add(btn);
        f.setSize(500,500);
        f.setLayout(new FlowLayout());
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int roll = Integer.parseInt(tr.getText());
                String name = tn.getText();
                String address = ta.getText();
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/himalaya","root","");
                    Statement st = con.createStatement();
                    String sql = "insert into student values('"+roll+"','"+name+"','"+address+"')";
                    int row = st.executeUpdate(sql);
                    if(row > 0){
                        JOptionPane.showMessageDialog(f,"Data Suucessfully Inserted");
                    }else{
                        JOptionPane.showMessageDialog(f,"Error in insertion");
                    }
                    con.close();
                    tr.setText("");
                    tn.setText("");
                    ta.setText("");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(f,ex.getMessage());
                }
            }
        });
    }
    public static void main(String[] args){
        new InsertDemo();
    }
}