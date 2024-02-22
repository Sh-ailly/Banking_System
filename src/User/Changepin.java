package User;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.mysql.cj.xdevapi.Statement;
public class Changepin {
      public String value;
      String newpin;

    public Changepin(){
      
         JFrame jf4=new JFrame();
                jf4.setSize(700, 500);
                jf4.setVisible(true);
                jf4.setLayout(null);
                jf4.getContentPane().setBackground(Color.CYAN);
                JLabel enterpin=new JLabel("Enter new Pin");
                jf4.add(enterpin);
                enterpin.setBounds(250, 100, 150, 30);
                JTextField tf1=new JTextField();
                jf4.add(tf1);
                tf1.setBounds(200, 150, 250, 40);
                newpin=tf1.getText();
                JButton submit=new JButton("Submit Edit->");
                jf4.add(submit);
                submit.setBounds(450, 370, 150, 25);
                submit.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent r){
                        try{  
                            Class.forName("com.mysql.cj.jdbc.Driver");  
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","igotocollegedaily");  
                        
                            //Statement stmt=con.createStatement();  
                            Long cardNumber =Long.valueOf(Integer.parseInt(value));   
                            int peen=Integer.parseInt((newpin));
                            String query1="UPDATE detail SET Pin=? WHERE CardNo=?";
                            PreparedStatement ps=con.prepareStatement(query1);
                            ps.setInt(1, peen);
                            ps.setLong(2, cardNumber);
                            ps.executeUpdate();
                            con.close();  
                            }catch(Exception e){ System.out.println(e);}  
                    }
                });
                JButton previous=new JButton("<-Previous");
                jf4.add(previous);
                previous.setBounds(50, 370, 150, 25);
                previous.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        whattodo what=new whattodo();
                        jf4.dispose();
                    }
                });
    }
}
