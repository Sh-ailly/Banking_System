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

public class Deposit {
    public Deposit() {
        JFrame jf2 = new JFrame();
        jf2.setSize(700, 500);
        jf2.setVisible(true);
        jf2.setLayout(null);
        jf2.getContentPane().setBackground(Color.CYAN);

        JLabel enteramount = new JLabel("Amount to deposit?");
        jf2.add(enteramount);
        enteramount.setBounds(250, 100, 150, 30);

        JTextField tf1 = new JTextField(); // For deposit amount
        jf2.add(tf1);
        tf1.setBounds(200, 150, 250, 40);

        JLabel enterCardNo = new JLabel("Enter Card Number:");
        jf2.add(enterCardNo);
        enterCardNo.setBounds(250, 200, 150, 30);

        JTextField tf2 = new JTextField(); // For Card Number
        jf2.add(tf2);
        tf2.setBounds(200, 250, 250, 40);

        JButton submit = new JButton("Submit");
        jf2.add(submit);
        submit.setBounds(450, 370, 150, 25);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String depositAmountText = tf1.getText();
                    String cardNumber = tf2.getText();

                    if (depositAmountText.isEmpty() || cardNumber.isEmpty()) {
                        System.out.println("Please enter both the deposit amount and card number.");
                        return;
                    }

                    double depositAmount = Double.parseDouble(depositAmountText); // Parse the deposit amount

                    // Step 1: Establish connection to the database
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "igotocollegedaily");

                    // Step 2: Retrieve the current balance
                    String query1 = "SELECT Balance FROM details WHERE CardNo = ?";
                    PreparedStatement ps1 = con.prepareStatement(query1);
                    ps1.setString(1, cardNumber);
                    ResultSet rs = ps1.executeQuery();

                    double currentBalance = 0;
                    if (rs.next()) { // If a result is found
                        currentBalance = rs.getDouble("Balance");
                    } else {
                        System.out.println("No account found with the provided card number.");
                        return;
                    }

                    // Step 3: Calculate the new balance
                    double newBalance = currentBalance + depositAmount;

                    // Step 4: Update the new balance in the database
                    String updateBalanceQuery = "UPDATE details SET Balance = ? WHERE CardNo = ?";
                    PreparedStatement ps2 = con.prepareStatement(updateBalanceQuery);
                    ps2.setDouble(1, newBalance);
                    ps2.setString(2, cardNumber);
                    ps2.executeUpdate();

                    // Close resources
                    rs.close();
                    ps1.close();
                    ps2.close();
                    con.close();

                    // Display confirmation
                    JLabel submitted = new JLabel();
                    jf2.add(submitted);
                    submitted.setBounds(495, 400, 150, 30);
                    submitted.setText("Deposit Submitted");

                } catch (Exception ee) {
                    System.out.println("Error: " + ee.getMessage());
                }
            }
        });

        JButton previous = new JButton("<-Previous");
        jf2.add(previous);
        previous.setBounds(50, 370, 150, 25);
        previous.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                whattodo what = new whattodo();
                jf2.dispose();
            }
        });
    }
}
