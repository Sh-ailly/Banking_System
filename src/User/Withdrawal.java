package User;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class Withdrawal{
    String a,b;
    String value1;
    public Withdrawal(){
            JFrame jf1=new JFrame();
            jf1.setSize(700, 500);
            jf1.setVisible(true);
            jf1.setLayout(null);
            jf1.getContentPane().setBackground(Color.CYAN);
            JLabel enteramount=new JLabel("Amount to withdrawal ?");
            jf1.add(enteramount);
            enteramount.setBounds(250, 100, 150, 30);
            JTextField tf1=new JTextField();
            jf1.add(tf1);
            tf1.setBounds(200, 150, 250, 40);
            a=tf1.getText();
            JButton previous=new JButton("<-Previous");
            jf1.add(previous);
            previous.setBounds(50, 370, 150, 25);
            previous.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    whattodo obj=new whattodo();
                    jf1.dispose();
                }
            });
            JButton submit=new JButton("Submit");
            jf1.add(submit);
            submit.setBounds(450, 370, 150, 25);
            submit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){

                    JFrame jf11=new JFrame();
                    jf11.setSize(700, 500);
                    jf11.setVisible(true);
                    jf11.setLayout(null);
                    jf11.getContentPane().setBackground(Color.CYAN);
                    JLabel balamount=new JLabel("Balance Left =");
                    jf11.add(balamount);
                    balamount.setBounds(200, 100, 200, 40);
                    balamount.setFont(new Font("Arial", Font.PLAIN, 30));
                    JLabel balance=new JLabel();
                    jf11.add(balance);
                    balance.setBounds(350, 100, 600, 40);
                    balance.setFont(new Font("Arial", Font.PLAIN, 30));
                    JButton previous=new JButton("<-Previous");
                    jf11.add(previous);
                    previous.setBounds(50, 370, 150, 25);
                    previous.addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                            whattodo obj=new whattodo();
                            jf1.dispose();
                            jf11.dispose();
                        }
                    });
                }  
            });
    }
}