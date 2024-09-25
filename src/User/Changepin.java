package User;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Changepin {
    String value; // Card number should be passed or initialized properly.
    String new_pin;

    public Changepin() {
        JFrame jf4 = new JFrame();
        jf4.setSize(700, 500);
        jf4.setVisible(true);
        jf4.setLayout(null);
        jf4.getContentPane().setBackground(Color.CYAN);

        JLabel enterpin = new JLabel("Enter new Pin");
        jf4.add(enterpin);
        enterpin.setBounds(250, 100, 150, 30);

        JTextField tf1 = new JTextField();
        jf4.add(tf1);
        tf1.setBounds(200, 150, 250, 40);

        JLabel cardno = new JLabel("Enter CardNo");
        jf4.add(cardno);
        cardno.setBounds(250, 200, 150, 30);

        JTextField tf2 = new JTextField();
        jf4.add(tf2);
        tf2.setBounds(200, 250, 250, 40);

        JButton submit = new JButton("Submit Edit->");
        jf4.add(submit);
        submit.setBounds(450, 370, 150, 25);

        // ActionListener for the submit button
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent r) {
                try {
                    // Fetch new pin from the text field when the button is clicked
                    new_pin = tf1.getText();
                    value=tf2.getText();
                    // Ensure new_pin and value are valid before attempting to update
                    if (new_pin == null || new_pin.isEmpty()) {
                        System.out.println("New PIN cannot be empty.");
                        return;
                    }
                    if (value == null || value.isEmpty()) {
                        System.out.println("Card number is not set.");
                        return;
                    }

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "igotocollegedaily");

                    Long cardNumber = Long.valueOf(value); // Assuming value is set correctly
                    int peen = Integer.parseInt(new_pin);  // Convert new_pin to integer

                    String query1 = "UPDATE details SET Pin=? WHERE CardNo=?";
                    PreparedStatement ps = con.prepareStatement(query1);
                    ps.setInt(1, peen); // Correct type: int
                    ps.setLong(2, cardNumber);

                    // Check if any rows were updated
                    int rowsAffected = ps.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Pin updated successfully!");
                    } else {
                        System.out.println("No matching record found. Pin update failed.");
                    }

                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });

        JButton previous = new JButton("<-Previous");
        jf4.add(previous);
        previous.setBounds(50, 370, 150, 25);
        previous.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                whattodo what = new whattodo();
                jf4.dispose();
            }
        });
    }
}
