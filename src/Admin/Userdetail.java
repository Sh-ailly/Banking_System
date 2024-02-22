package Admin;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class Userdetail {
    public Userdetail()
    {
    JFrame f4=new JFrame();
    f4.setSize(700, 500);   
    f4.setLayout(null);
    f4.setVisible(true);
    f4.getContentPane().setBackground(Color.CYAN);

    JLabel form=new JLabel("Form To Add Account");
    f4.add(form);
    form.setBounds(240, 10, 350, 50);
    form.setFont(new Font("Arial", Font.BOLD, 20));
    JLabel firstname=new JLabel("FirstName");
    f4.add(firstname);
    firstname.setBounds(30, 50, 150, 30);
    JTextField fn=new JTextField();
    f4.add(fn);
    fn.setBounds(30,80,250,30);
    JLabel lastname=new JLabel("LastName");
    f4.add(lastname);
    lastname.setBounds(400,50,150,30);
    JTextField ln=new JTextField();
    f4.add(ln);
    ln.setBounds(400,80,250,30);

    JLabel address=new JLabel("Address");
    f4.add(address);
    address.setBounds(30,120,150,30);
    JTextField adrs=new JTextField();
    f4.add(adrs);
    adrs.setBounds(30,150,250,30);

    JLabel city=new JLabel("City");
    f4.add(city);
    city.setBounds(400, 120, 150,30);
    JTextField cty=new JTextField();
    f4.add(cty);
    cty.setBounds(400,150,250,30);

    JLabel phoneno=new JLabel("PhoneNo");
    f4.add(phoneno);
    phoneno.setBounds(30,190,150,30);
    JTextField pn=new JTextField();
    f4.add(pn);
    pn.setBounds(30,220,250,30);

    JLabel pin=new JLabel("PinNo");
    f4.add(pin);
    pin.setBounds(400,190,150,30);
    JTextField pen=new JTextField();
    f4.add(pen);
    pen.setBounds(400,220,250,30);

    JLabel cardno=new JLabel("CardNo");
    f4.add(cardno);
    cardno.setBounds(30,260,150,30);
    JTextField cn=new JTextField();
    f4.add(cn);
    cn.setBounds(30, 290, 250, 30);

    JLabel balance=new JLabel("Account Balance");
    f4.add(balance);
    balance.setBounds(400, 260,150,30);
    JTextField blnc=new JTextField();
    f4.add(blnc);
    blnc.setBounds(400,290,250,30);

    
    JButton addaccount=new JButton("ADD ACCOUNT");
    f4.add(addaccount);
    addaccount.setBounds(450,370,150,25);
    addaccount.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
    try{  
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection(  
        "jdbc:mysql://localhost:3306/atm","root","igotocollegedaily");  
        Statement stmt=con.createStatement();  
        String query1= "INSERT INTO detail (FirstName, LastName, Address, City, PhoneNo, Pin, CardNo, Balance) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = con.prepareStatement(query1);
        preparedStatement.setString(1, fn.getText());
        preparedStatement.setString(2, ln.getText());
        preparedStatement.setString(3, adrs.getText());
        preparedStatement.setString(4, cty.getText());
        preparedStatement.setLong(5, Long.parseLong(pn.getText()));
        preparedStatement.setInt(6, Integer.parseInt(pen.getText()));
        preparedStatement.setLong(7, Long.parseLong(cn.getText())); 
        preparedStatement.setLong(8, Long.parseLong(blnc.getText()));

        preparedStatement.executeUpdate();    
        ResultSet rs=stmt.executeQuery("select * from detail");  
        while(rs.next())  
        System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
        con.close();  
        }
        catch(Exception t){
             System.out.println(t);
            } 
        }
        });
        JButton previous=new JButton("<-Previous");
        f4.add(previous);
        previous.setBounds(80,370,150,25);
        previous.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            whattodoAdmin what=new whattodoAdmin();
            f4.dispose();
        }
    });
    }
}