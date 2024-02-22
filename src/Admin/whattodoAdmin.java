package Admin;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class whattodoAdmin {
    public whattodoAdmin(){
        JFrame f3=new JFrame();
        f3.setSize(400, 550);
        f3.setLayout(null);
        f3.setVisible(true);
        f3.getContentPane().setBackground(Color.CYAN);
        JLabel atm=new JLabel("ATM");
        f3.add(atm);
        atm.setBounds(110, 40, 300, 100);
        atm.setFont(new Font("Arial", Font.BOLD, 80));
        JLabel mgmtsystem=new JLabel("MANAGEMENT   SYSTEM");
        f3.add(mgmtsystem);
        mgmtsystem.setBounds(130, 105, 300, 50 );
        mgmtsystem.setFont(new Font("Arial", Font.BOLD, 10));
        JLabel adduser=new JLabel("ADD USER");
        f3.add(adduser);
        adduser.setBounds(20, 180, 200, 50);
        adduser.setFont(new Font("Arial", Font.BOLD, 15));
        adduser.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                Userdetail userdetailform=new Userdetail();
                f3.dispose();
            }
        });
        JLabel deleteuser=new JLabel("DELETE USER");
        f3.add(deleteuser);
        deleteuser.setBounds(20, 270, 200, 50);
        deleteuser.setFont(new Font("Arial", Font.BOLD, 15));
        deleteuser.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                PrimarykeyDeleteUser primarykey=new PrimarykeyDeleteUser();
                f3.dispose();
            }
        });
        JLabel viewalluser=new JLabel("VIEW USER DETAIL");
        f3.add(viewalluser);
        viewalluser.setBounds(230, 180, 200, 50);
        viewalluser.setFont(new Font("Arial", Font.BOLD, 15));
        viewalluser.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                Perticularuserdetail peruserdetail=new Perticularuserdetail();
                f3.dispose();
            }
        });
         JLabel edituserdetail=new JLabel("EDIT USER DETAIL");
        f3.add(edituserdetail);
        edituserdetail.setBounds(230, 270, 200, 50);
        edituserdetail.setFont(new Font("Arial", Font.BOLD, 15));
        edituserdetail.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent l){
                Editdetail edit=new Editdetail();
                f3.dispose();
            }
        });

        JButton previous=new JButton("<-Previous");
        f3.add(previous);
        previous.setBounds(20, 420, 150, 25);
        previous.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                AdminLogin adminLogin=new AdminLogin();
                f3.dispose();
            }
        });
    }
}