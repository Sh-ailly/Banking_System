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

public class Withdrawal {
    public Withdrawal() {
        JFrame jf1 = new JFrame();
        jf1.setSize(700, 500);
        jf1.setVisible(true);
        jf1.setLayout(null);
        jf1.getContentPane().setBackground(Color.CYAN);

        JLabel enteramount = new JLabel("Amount to withdraw?");
        jf1.add(enteramount);
        enteramount.setBounds(250, 100, 200, 30);

        JTextField tf1 = new JTextField();
        jf1.add(tf1);
        tf1.setBounds(200, 150, 250, 40);

        JLabel enterpin = new JLabel("Enter PIN");
        jf1.add(enterpin);
        enterpin.setBounds(250, 200, 150, 30);

        JTextField tf2 = new JTextField();
        jf1.add(tf2);
        tf2.setBounds(200, 250, 250, 40);

        JButton previous = new JButton("<-Previous");
        jf1.add(previous);
        previous.setBounds(50, 370, 150, 25);
        previous.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                whattodo obj = new whattodo();
                jf1.dispose();
            }
        });

        JButton submit = new JButton("Submit");
        jf1.add(submit);
        submit.setBounds(450, 370, 150, 25);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double withdrawAmount = Double.parseDouble(tf1.getText());
                    String pin = tf2.getText();

                    // Connect to the database
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "igotocollegedaily");

                    // 1. Get the current balance
                    String query1 = "SELECT Balance FROM details WHERE pin = ?";
                    PreparedStatement ps = con.prepareStatement(query1);
                    ps.setString(1, pin);
                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        double currentBalance = rs.getDouble("Balance");

                        // Check if enough balance is available
                        if (currentBalance >= withdrawAmount) {
                            // 2. Subtract the withdrawal amount and update the balance
                            double newBalance = currentBalance - withdrawAmount;

                            // 3. Update the new balance in the database
                            String query2 = "UPDATE details SET Balance = ? WHERE pin = ?";
                            PreparedStatement ps2 = con.prepareStatement(query2);
                            ps2.setDouble(1, newBalance);
                            ps2.setString(2, pin);
                            ps2.executeUpdate();

                            // Display the updated balance on the next page
                            JFrame jf11 = new JFrame();
                            jf11.setSize(700, 500);
                            jf11.setVisible(true);
                            jf11.setLayout(null);
                            jf11.getContentPane().setBackground(Color.CYAN);

                            JLabel balamount = new JLabel("Balance Left =");
                            jf11.add(balamount);
                            balamount.setBounds(200, 100, 200, 40);
                            balamount.setFont(new Font("Arial", Font.PLAIN, 30));

                            JLabel balance = new JLabel(Double.toString(newBalance));
                            jf11.add(balance);
                            balance.setBounds(400, 100, 200, 40);
                            balance.setFont(new Font("Arial", Font.PLAIN, 30));

                            JButton previousButton = new JButton("<-Previous");
                            jf11.add(previousButton);
                            previousButton.setBounds(50, 370, 150, 25);
                            previousButton.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    whattodo obj = new whattodo();
                                    jf1.dispose();
                                    jf11.dispose();
                                }
                            });

                        } else {
                            System.out.println("Insufficient balance.");
                        }
                    } else {
                        System.out.println("Invalid PIN.");
                    }

                    rs.close();
                    ps.close();
                    con.close();

                } catch (Exception ee) {
                    System.out.println("Error: " + ee.getMessage());
                }
            }
        });
    }
}
