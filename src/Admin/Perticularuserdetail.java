package Admin;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Perticularuserdetail {
   public JTextField tf;
    public Perticularuserdetail(){
        JFrame f6=new JFrame();
        f6.setSize(700, 500);
        f6.setVisible(true);
        f6.setLayout(null);
        f6.getContentPane().setBackground(Color.CYAN);
        JLabel entercardno=new JLabel("Enter cardno");
        f6.add(entercardno);
        entercardno.setBounds(250, 150, 300, 50);
        entercardno.setFont(new Font("Arial", Font.PLAIN, 30));
        tf=new JTextField();
        f6.add(tf);
        tf.setBounds(200, 200, 270, 36);
        JButton previous=new JButton("<-Previous");
        f6.add(previous);
        previous.setBounds(80,370,150,25);
        previous.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        whattodoAdmin what=new whattodoAdmin();
        f6.dispose();
        }
    });
        JButton show=new JButton("Display Table->");
        f6.add(show);
        show.setBounds(450,370, 150,25);
        show.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        String cardnumber= tf.getText();
        JFrame f8=new JFrame();
        f8.setSize(700, 500);
        f8.setLayout(null);
        f8.setVisible(true);
        f8.getContentPane().setBackground(Color.LIGHT_GRAY);
        JLabel fn=new JLabel("FirstName");
        f8.add(fn);
        fn.setBounds(200,30,100,30);
        JTextField tf1=new JTextField();
        f8.add(tf1);
        tf1.setBounds(300,30,200,30);
         JLabel ln=new JLabel("LastName");
        f8.add(ln);
        ln.setBounds(200,80,100,30);
        JTextField tf2=new JTextField();
        f8.add(tf2);
        tf2.setBounds(300, 80, 200, 30);
         JLabel addr=new JLabel("Address");
        f8.add(addr);
        addr.setBounds(200,130,100,30);
        JTextField tf3=new JTextField();
        f8.add(tf3);
        tf3.setBounds(300,130,200,30);
        JLabel city=new JLabel("City");
        f8.add(city);
        city.setBounds(200,180,100,30);
        JTextField tf4=new JTextField();
        f8.add(tf4);
        tf4.setBounds(300,180,200,30);
        JLabel pn=new JLabel("PhoneNo");
        f8.add(pn);
        pn.setBounds(200,230,100,30);
        JTextField tf5=new JTextField();
        f8.add(tf5);
        tf5.setBounds(300,230,200,30);
        JLabel pin=new JLabel("Pin");
        f8.add(pin);
        pin.setBounds(200,280,100,30);
        JTextField tf6=new JTextField();
        f8.add(tf6);
        tf6.setBounds(300,280,200,30);
        JLabel cn=new JLabel("CardNo");
        f8.add(cn);
        cn.setBounds(200,330,100,30);
        JTextField tf7=new JTextField();
        f8.add(tf7);
        tf7.setBounds(300,330,200,30);
        JLabel blnc=new JLabel("Balance");
        f8.add(blnc);
        blnc.setBounds(200,380,100,30);
        JTextField tf8=new JTextField();
        f8.add(tf8);
        tf8.setBounds(300, 380,200,30);
        try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","igotocollegedaily");
         String query = "SELECT * FROM detail WHERE CardNo=?";
         PreparedStatement pstmt = con.prepareStatement(query);
         pstmt.setString(1, cardnumber);
        ResultSet rs = pstmt.executeQuery();   
        while(rs.next()){
        tf1.setText(rs.getString("FirstName"));
        tf2.setText(rs.getString("LastName"));
        tf3.setText(rs.getString("Address"));
        tf4.setText(rs.getString("City"));
        tf5.setText(rs.getString("PhoneNo"));
        tf6.setText(rs.getString("Pin"));
        tf7.setText(rs.getString("CardNo"));
        tf8.setText(rs.getString("Balance"));
        }
         con.close();
        }
        catch(Exception p){
         System.out.println(p);
        }
                f6.dispose();
            }
        });
    }
}