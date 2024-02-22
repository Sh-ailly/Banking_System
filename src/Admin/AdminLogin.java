package Admin;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import User.MainLogin;
public class AdminLogin {
    public AdminLogin()
    {
    JFrame f1=new JFrame();
    f1.setSize(400, 550);
    f1.setLayout(null);
    f1.getContentPane().setBackground(Color.CYAN);
    f1.setVisible(true);

    JLabel atm=new JLabel("ATM");
    f1.add(atm);
    atm.setBounds(110, 40, 300, 100);
    atm.setFont(new Font("Arial", Font.BOLD, 80));
    JLabel mgmtsystem=new JLabel("MANAGEMENT   SYSTEM");
    f1.add(mgmtsystem);
    mgmtsystem.setBounds(130, 105, 300, 50 );
    mgmtsystem.setFont(new Font("Arial", Font.BOLD, 10));
    JTextField username=new JTextField("Enter your username");
    f1.add(username);
    username.setBounds(50, 200, 300, 50);
    username.addFocusListener(new FocusAdapter() {
        public void focusLost(FocusEvent e)
        {
            if(username.getText().isEmpty())
            {
                username.setText("Enter your username");
            
            }
        }
    });
    username.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e)
        {
            username.setText(null);
        }
        public void mouseEntered(){

        }
        public void mouseExited(){

        }
        public void mousePressed(){

        }
        public void mouseReleased(){

        }
    });
    JTextField password=new JTextField("Enter your password");
    f1.add(password);
    password.setBounds(50, 270, 300, 50);
    password.addFocusListener(new FocusAdapter(){
        public void focusLost(FocusEvent e)
        {
            if(password.getText().isEmpty())
            {
                password.setText("Enter your password");
            }
        }
    });
    password.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e)
        {
            password.setText(null);
        }
        public void mouseEntered(){

        }
        public void mouseExited(){

        }
        public void mousePressed(){

        }
        public void mouseReleased(){

        }
    });
    JLabel wrong=new JLabel();
    f1.add(wrong);
    wrong.setBounds(147, 397, 200, 20);
    wrong.setFont(new Font("Arial", Font.PLAIN, 10));

    String a1=username.getText();
    String a2=password.getText();
    JButton b=new JButton("Login");
        f1.add(b);
        b.setBounds(155, 350, 100, 40);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(username.getText().equals("Shailly")&&password.getText().equals("1234"))
                {
                    Admin.whattodoAdmin what=new Admin.whattodoAdmin();
                    f1.dispose();
                }
                else
                    wrong.setText("Wrong username or password");
            }
        });
    JButton previous=new JButton("<-Previous");
    f1.add(previous);
    previous.setBounds(50, 420, 150, 25);
    previous.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            MainLogin mainlogin=new MainLogin();//here constructor is called but we have not made any constructor we have made a method
            mainlogin.first();//as we have made the method in mainlogin instead of a constructor
            f1.dispose();
        }
    });
}
}