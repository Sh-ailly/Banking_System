package User;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Deposit {
    public Deposit(){
         JFrame jf2=new JFrame();
                jf2.setSize(700, 500);
                jf2.setVisible(true);
                jf2.setLayout(null);
                jf2.getContentPane().setBackground(Color.CYAN);
                JLabel enteramount=new JLabel("Amount to deposit ?");
                jf2.add(enteramount);
                enteramount.setBounds(250, 100, 150, 30);
                JTextField tf1=new JTextField();
                jf2.add(tf1);
                tf1.setBounds(200, 150, 250, 40);
                JButton submit=new JButton("Submit");
                jf2.add(submit);
                submit.setBounds(450, 370, 150, 25);
                submit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        JLabel submitted=new JLabel();
                        jf2.add(submitted);
                        submitted.setBounds(495, 400, 150, 30);
                        submitted.setText("Submitted");
                    }
                });
                
                JButton previous=new JButton("<-Previous");
                jf2.add(previous);
                previous.setBounds(50, 370, 150, 25);
                previous.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        whattodo what=new whattodo();
                        jf2.dispose();
                    }
                });
}
    }
