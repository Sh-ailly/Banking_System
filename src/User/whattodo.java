package User;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
public class whattodo {
    public whattodo(){
        JFrame f2=new JFrame();
        f2.setSize(400, 550);
        f2.setLayout(null);
        f2.setVisible(true);
        f2.getContentPane().setBackground(Color.CYAN);
        JLabel atm=new JLabel("ATM");
        f2.add(atm);
        atm.setBounds(110, 40, 300, 100);
        atm.setFont(new Font("Arial", Font.BOLD, 80));
        JLabel mgmtsystem=new JLabel("MANAGEMENT   SYSTEM");
        f2.add(mgmtsystem);
        mgmtsystem.setBounds(130, 105, 300, 50 );
        mgmtsystem.setFont(new Font("Arial", Font.BOLD, 10));
        JLabel withdrawal=new JLabel("Withdrawal >");
        f2.add(withdrawal);
        withdrawal.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
               Withdrawal obj1=new Withdrawal();
                f2.dispose();
            }
        });
        withdrawal.setBounds(250, 160, 150, 50);
        withdrawal.setFont(new Font("Arial", Font.BOLD, 20));
        JLabel deposit=new JLabel("Deposit >");
        f2.add(deposit);
        deposit.setBounds(283, 210, 150, 50);
        deposit.setFont(new Font("Arial", Font.BOLD, 20));
        deposit.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
               Deposit obj2=new Deposit();
               f2.dispose();
            }
        });
        JLabel viewbalance=new JLabel("View Balance >");
        f2.add(viewbalance);
        viewbalance.setBounds(227, 260, 150, 50);
        viewbalance.setFont(new Font("Arial", Font.BOLD, 20));
        viewbalance.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
               Viewbalance obj3=new Viewbalance();
               f2.dispose();
            }
        });
        JLabel changepin=new JLabel("Change Pin >");
        f2.add(changepin);
        changepin.setBounds(244, 310, 150, 50);
        changepin.setFont(new Font("Arial", Font.BOLD, 20));
        changepin.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
               Changepin obj4=new Changepin();
               f2.dispose();
            }
        });
        JLabel transfer=new JLabel("Transfer >");
        f2.add(transfer);
        transfer.setBounds(274, 360, 150, 50);
        transfer.setFont(new Font("Arial", Font.BOLD, 20));
        transfer.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                Transfermoney obj5=new Transfermoney();
                f2.dispose();
            }
        });
        JButton previous=new JButton("<-Previous");
        f2.add(previous);
        previous.setBounds(50, 420, 150, 25);
        previous.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                MainLogin mainlogin=new MainLogin();
                mainlogin.first();
                f2.dispose();
            }
        });

    }
}