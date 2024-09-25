package Admin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class PrimarykeyDeleteUser {
    public PrimarykeyDeleteUser(){
        JFrame f5=new JFrame();
        f5.setSize(700, 500);
        f5.setVisible(true);
        f5.setLayout(null);
        f5.getContentPane().setBackground(Color.CYAN);
        JLabel entercardno=new JLabel("Enter cardno");
        f5.add(entercardno);
        entercardno.setBounds(250, 150, 300, 50);
        entercardno.setFont(new Font("Arial", Font.PLAIN, 30));
        JTextField tf=new JTextField();
        f5.add(tf);
        tf.setBounds(200, 200, 270, 36);
        JButton previous=new JButton("<-Previous");
        f5.add(previous);
        previous.setBounds(80,370,150,25);
        previous.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
        whattodoAdmin what=new whattodoAdmin();
        f5.dispose();
        }
    });
     JButton delete=new JButton("Delete->");
        f5.add(delete);
        delete.setBounds(450,370, 150,25);
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
              try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","igotocollegedaily");
                Statement stmt=con.createStatement();
                String cardno=tf.getText();
                String query1="DELETE FROM details WHERE CardNo='" + cardno +"'";
                stmt.executeUpdate(query1);
                ResultSet rs=stmt.executeQuery("select * from detail");
                while(rs.next())
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
                con.close();
              }
              catch(Exception t){
                System.out.println(t);
              }
              }

        });
    }
}