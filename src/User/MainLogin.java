package User;
//import Admin.AdminLogin;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;

import javax.swing.*;
import Admin.AdminLogin;
public class MainLogin {
    private JTextField tf;
    public JTextField getTextField() {
        return tf;
    }
    public void first(){
        JFrame f=new JFrame();
        f.setSize(400, 500);
        f.setLayout(null);
        f.getContentPane().setBackground(Color.CYAN);
        f.setVisible(true);

        JLabel atm=new JLabel("ATM");
        f.add(atm);
        atm.setBounds(110, 40, 300, 100);
        atm.setFont(new Font("Arial", Font.BOLD, 80));
        JLabel mgmtsystem=new JLabel("MANAGEMENT   SYSTEM");
        f.add(mgmtsystem);
        mgmtsystem.setBounds(130, 105, 300, 50 );
        mgmtsystem.setFont(new Font("Arial", Font.BOLD, 10));
        JLabel entercardno=new JLabel("ENTER YOUR CARD NUMBER");
        f.add(entercardno);
        entercardno.setBounds(45,195, 200, 25);
        tf=new JTextField();
        f.add(tf);
        tf.setBounds(45, 220, 300, 40);
        JLabel failed=new JLabel();
        f.add(failed);
        failed.setBounds(140, 350, 250, 40);
        failed.setFont(new Font("Arial", Font.BOLD, 10));
        JButton b=new JButton("Login");
        f.add(b);
        b.setBounds(140, 300, 100, 40);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                int flag=0;
                String b=tf.getText();
                Long c=Long.parseLong(b);
                char[] a=b.toCharArray();
                if(tf.getText().length()<16 || tf.getText().length()>16){
                    flag++;
                }
                else if(tf.getText().contains(" ")){
                    flag++;
                }

                else if(flag==0)
                {
                  for(int i=0;i<b.length();i++)
                  {
                    if(Character.isLetter(a[i])){
                        flag++;
                    }
                    else if (Pattern.compile("[^a-zA-Z0-9]").matcher(b).find()) {
                    flag++;
                }
                  }
                }
                
                if(flag==0){
                    whattodo what=new whattodo();
                    f.dispose();
                }
                else {
                    failed.setText("Wrong Card Number");
                    tf.setText(null);
                }
            }
        });
       
        JLabel adminlogin=new JLabel("ADMIN LOGIN >");
        f.add(adminlogin);
        adminlogin.setBounds(290, 415, 200, 30);
        adminlogin.setFont(new Font("Arial", Font.BOLD, 10));
        adminlogin.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                AdminLogin admin=new AdminLogin();
                f.dispose();
            }
        });
    }
}