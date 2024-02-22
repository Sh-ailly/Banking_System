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

public class Viewbalance {
    JTextField tf1;
    public Viewbalance(){
         JFrame jf3=new JFrame();
                jf3.setSize(700, 500);
                jf3.setVisible(true);
                jf3.setLayout(null);
                jf3.getContentPane().setBackground(Color.CYAN);
                JLabel pin=new JLabel("Enter pin");
                jf3.add(pin);
                pin.setBounds(250, 100, 150, 30);
                tf1=new JTextField();
                jf3.add(tf1);
                tf1.setBounds(200, 150, 250, 40);

                JButton previous=new JButton("<-Previous");
                jf3.add(previous);
                previous.setBounds(50, 370, 150, 25);
                previous.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        whattodo what=new whattodo();
                        jf3.dispose();
                    }
                });
        
                JButton submit=new JButton("View->");
                jf3.add(submit);
                submit.setBounds(450, 370, 150, 25);
                submit.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        String a=tf1.getText();
                        JFrame jf31=new JFrame();
                        jf31.setSize(700, 500);
                        jf31.setVisible(true);
                        jf31.setLayout(null);
                        jf31.getContentPane().setBackground(Color.CYAN);
                        JLabel bal=new JLabel("Balance =");
                        jf31.add(bal);
                        bal.setBounds(200, 100, 150, 40);
                        bal.setFont(new Font("Arial", Font.PLAIN, 30));
                        JLabel balance=new JLabel();
                        jf31.add(balance);
                        balance.setBounds(350, 100, 600, 40);
                        balance.setFont(new Font("Arial", Font.PLAIN, 30));
                                jf3.dispose();

                                JButton previous=new JButton("<-Previous");
                                jf31.add(previous);
                                previous.setBounds(50, 370, 150, 25);
                                previous.addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent e){
                                        Viewbalance what=new Viewbalance();
                                        jf31.dispose();
                                    }
                                });
                                JButton cancel=new JButton("Cancel");
                                jf31.add(cancel);
                                cancel.setBounds(450, 370, 150, 25);
                                cancel.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e){
                                        jf31.dispose();
                                        jf3.dispose();
                                    }
                                });
                    }
                });
}
}