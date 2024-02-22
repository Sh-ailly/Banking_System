package Admin;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

class Editdetail{
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8;

    Editdetail(){
        JFrame f8=new JFrame(); 
        f8.setSize(700,500);
        f8.setVisible(true);
        f8.getContentPane().setBackground(Color.CYAN);
        f8.setLayout(null);
        JLabel l1=new JLabel("Enter the cardno");
        f8.add(l1);
        l1.setBounds(250, 40, 150, 30);
        JTextField tf=new JTextField();
        f8.add(tf);
        tf.setBounds(200, 70, 200, 30);
        JButton b1=new JButton("Next");
        f8.add(b1);
        b1.setBounds(250, 150, 90, 30);
        b1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        JFrame f7=new JFrame();
        f8.dispose();
        f7.setSize(700,500);
        f7.setLayout(null);
        f7.setVisible(true);
        f7.getContentPane().setBackground(Color.CYAN);
        JLabel fn=new JLabel("FirstName->");
        f7.add(fn);
        fn.setBounds(20, 30, 150, 50);
        fn.setFont(new Font("Arial", Font.PLAIN, 20));
        fn.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                JFrame f11=new JFrame();
                f11.setSize(700, 500);
                f11.setVisible(true);
                f11.setLayout(null);
                f11.getContentPane().setBackground(Color.CYAN);
                JLabel newname=new JLabel("Enter Firstname");
                f11.add(newname);
                newname.setBounds(250, 40, 150, 30);
                JTextField tf1=new JTextField();
                f11.add(tf1);
                tf1.setBounds(200,80,250,40);
                JButton previous=new JButton("<-Previous");
                f11.add(previous);
                previous.setBounds(80,370,150,25);
                previous.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    f7.repaint();
                    f7.setVisible(true);
                    f11.dispose();
                }
            });
                f7.dispose();
                JButton submit=new JButton("Submit Edit->");
                f11.add(submit);
                submit.setBounds(450, 370, 150, 25);
                submit.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent r){
                        try{  
                            Class.forName("com.mysql.cj.jdbc.Driver");  
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","igotocollegedaily");  
                            //here sonoo is database name, root is username and password  
                            Statement stmt=con.createStatement();  
                            Long cardNumber =Long.valueOf(Integer.parseInt(tf.getText()));   
                            String newFirstName = tf1.getText();
                            String query1="UPDATE detail SET FirstName=? WHERE CardNo=?";
                            PreparedStatement ps=con.prepareStatement(query1);
                            ps.setString(1,newFirstName);
                            ps.setLong(2, cardNumber);
                            ps.executeUpdate();
                            con.close();  
                            }catch(Exception e){ System.out.println(e);}  
                    }
                });
            }
        });
        JLabel ln=new JLabel("LastName->");
        f7.add(ln);
        ln.setBounds(20, 70, 150, 50);
        ln.setFont(new Font("Arial", Font.PLAIN, 20));
        ln.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent p){
                JFrame f12=new JFrame();
                f12.setSize(700, 500);
                f12.setVisible(true);
                f12.setLayout(null);
                f12.getContentPane().setBackground(Color.CYAN);
                JLabel newname=new JLabel("Enter Lastname");
                f12.add(newname);
                newname.setBounds(250, 40, 150, 30);
                JTextField tf2=new JTextField();
                f12.add(tf2);
                tf2.setBounds(200,80,250,40);
                f7.dispose();
                 JButton previous=new JButton("<-Previous");
                f12.add(previous);
                previous.setBounds(80,370,150,25);
                previous.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    f7.repaint();
                    f7.setVisible(true);
                    f12.dispose();
                }
            });
              f7.dispose();
                JButton submit=new JButton("Submit Edit->");
                f12.add(submit);
                submit.setBounds(450, 370, 150, 25);
                submit.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent r){
                        try{  
                            Class.forName("com.mysql.cj.jdbc.Driver");  
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","igotocollegedaily");  
                            //here sonoo is database name, root is username and password  
                            Statement stmt=con.createStatement();  
                            Long cardNumber =Long.valueOf(Integer.parseInt(tf.getText()));   
                            String newLastName = tf2.getText();
                            String query1="UPDATE detail SET LastName=? WHERE CardNo=?";
                            PreparedStatement ps=con.prepareStatement(query1);
                            ps.setString(1,newLastName);
                            ps.setLong(2, cardNumber);
                            ps.executeUpdate();
                            con.close();  
                            }catch(Exception e){ System.out.println(e);}  
                    }
                });
            }
              public void mouseEntered(MouseEvent p){

            }
            public void mouseExited(MouseEvent p){

            }
            public void mousePressed(MouseEvent p){

            }
            public void mouseReleased(MouseEvent p){
                
            }
        });
        JLabel address=new JLabel("Address->");
        f7.add(address);
        address.setBounds(20, 110, 150, 50);
        address.setFont(new Font("Arial", Font.PLAIN, 20));
        address.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent p){
                JFrame f13=new JFrame();
                f13.setSize(700, 500);
                f13.setVisible(true);
                f13.setLayout(null);
                f13.getContentPane().setBackground(Color.CYAN);
                JLabel newname=new JLabel("Enter Address");
                f13.add(newname);
                newname.setBounds(250, 40, 150, 30);
                JTextField tf3=new JTextField();
                f13.add(tf3);
                tf3.setBounds(200,80,250,40);
                JButton previous=new JButton("<-Previous");
                f13.add(previous);
                previous.setBounds(80,370,150,25);
                previous.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    f7.repaint();
                    f7.setVisible(true);
                    f13.dispose();
                }
            });
                f7.dispose();
                JButton submit=new JButton("Submit Edit->");
                f13.add(submit);
                submit.setBounds(450, 370, 150, 25);
                
                submit.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent r){
                        try{  
                            Class.forName("com.mysql.cj.jdbc.Driver");  
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","igotocollegedaily");  
                            //here sonoo is database name, root is username and password  
                            Statement stmt=con.createStatement();  
                            Long cardNumber =Long.valueOf(Integer.parseInt(tf.getText()));   
                            String newAddress = tf3.getText();
                            String query1="UPDATE detail SET Address=? WHERE CardNo=?";
                            PreparedStatement ps=con.prepareStatement(query1);
                            ps.setString(1,newAddress);
                            ps.setLong(2, cardNumber);
                            ps.executeUpdate();
                            con.close();  
                            }catch(Exception e){ System.out.println(e);}  
                    }
                });
            }
            public void mouseEntered(MouseEvent p){

            }
            public void mouseExited(MouseEvent p){

            }
            public void mousePressed(MouseEvent p){

            }
            public void mouseReleased(MouseEvent p){
                
            }
        });
         JLabel city=new JLabel("City->");
        f7.add(city);
        city.setBounds(20, 150, 150, 50);
        city.setFont(new Font("Arial", Font.PLAIN, 20));
        city.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent p){
                JFrame f14=new JFrame();
                f14.setSize(700, 500);
                f14.setVisible(true);
                f14.setLayout(null);
                f14.getContentPane().setBackground(Color.CYAN);
                 JLabel newname=new JLabel("Enter City");
                f14.add(newname);
                newname.setBounds(250, 40, 150, 30);
                JTextField tf4=new JTextField();
                f14.add(tf4);
                tf4.setBounds(200,80,250,40);
                 JButton previous=new JButton("<-Previous");
                f14.add(previous);
                previous.setBounds(80,370,150,25);
                previous.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    f7.repaint();
                    f7.setVisible(true);
                    f14.dispose();
                }
            });
                f7.dispose();
                JButton submit=new JButton("Submit Edit->");
                f14.add(submit);
                submit.setBounds(450, 370, 150, 25);
                submit.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent r){
                        try{  
                            Class.forName("com.mysql.cj.jdbc.Driver");  
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","igotocollegedaily");  
                            //here sonoo is database name, root is username and password  
                            Statement stmt=con.createStatement();  
                            Long cardNumber =Long.valueOf(Integer.parseInt(tf.getText()));   
                            String newCity = tf4.getText();
                            String query1="UPDATE detail SET City=? WHERE CardNo=?";
                            PreparedStatement ps=con.prepareStatement(query1);
                            ps.setString(1,newCity);
                            ps.setLong(2, cardNumber);
                            ps.executeUpdate();
                            con.close();  
                            }catch(Exception e){ System.out.println(e);}  
                    }
                });
            }
            public void mouseEntered(MouseEvent p){

            }
            public void mouseExited(MouseEvent p){

            }
            public void mousePressed(MouseEvent p){

            }
            public void mouseReleased(MouseEvent p){
                
            }
        });
        JLabel pn=new JLabel("PhoneNo->");
        f7.add(pn);
        pn.setBounds(20, 190, 150, 50);
        pn.setFont(new Font("Arial", Font.PLAIN, 20));
        pn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent p){
               JFrame f15=new JFrame();
                f15.setSize(700, 500);
                f15.setVisible(true);
                f15.setLayout(null);
                f15.getContentPane().setBackground(Color.CYAN);
                 JLabel newname=new JLabel("Enter Phoneno");
                f15.add(newname);
                newname.setBounds(250, 40, 150, 30);
                JTextField tf5=new JTextField();
                f15.add(tf5);
                tf5.setBounds(200,80,250,40);
                 JButton previous=new JButton("<-Previous");
                f15.add(previous);
                previous.setBounds(80,370,150,25);
                previous.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    f7.repaint();
                    f7.setVisible(true);
                    f15.dispose();
                }
            });
                f7.dispose(); 
                JButton submit=new JButton("Submit Edit->");
                f15.add(submit);
                submit.setBounds(450, 370, 150, 25);
                submit.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent r){
                        try{  
                            Class.forName("com.mysql.cj.jdbc.Driver");  
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","igotocollegedaily");  
                            //here sonoo is database name, root is username and password  
                            Statement stmt=con.createStatement();  
                            Long cardNumber =Long.valueOf(Integer.parseInt(tf.getText()));   
                            String newphoneno = tf5.getText();
                            String query1="UPDATE detail SET PhoneNo=? WHERE CardNo=?";
                            PreparedStatement ps=con.prepareStatement(query1);
                            ps.setString(1,newphoneno);
                            ps.setLong(2, cardNumber);
                            ps.executeUpdate();
                            con.close();  
                            }catch(Exception e){ System.out.println(e);}  
                    }
                });

            }
              public void mouseEntered(MouseEvent p){

            }
            public void mouseExited(MouseEvent p){

            }
            public void mousePressed(MouseEvent p){

            }
            public void mouseReleased(MouseEvent p){
                
            }
        });
        JLabel pin=new JLabel("Pin->");
        f7.add(pin);
        pin.setBounds(20, 230, 150, 50);
        pin.setFont(new Font("Arial", Font.PLAIN, 20));
        pin.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent p){
                JFrame f16=new JFrame();
                f16.setSize(700, 500);
                f16.setVisible(true);
                f16.setLayout(null);
                f16.getContentPane().setBackground(Color.CYAN);
                 JLabel newname=new JLabel("Enter Pin");
                f16.add(newname);
                newname.setBounds(250, 40, 150, 30);
                JTextField tf6=new JTextField();
                f16.add(tf6);
                tf6.setBounds(200,80,250,40);
                 JButton previous=new JButton("<-Previous");
                f16.add(previous);
                previous.setBounds(80,370,150,25);
                previous.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    f7.repaint();
                    f7.setVisible(true);
                    f16.dispose();
                }
            });
                f7.dispose();
                JButton submit=new JButton("Submit Edit->");
                f16.add(submit);
                submit.setBounds(450, 370, 150, 25);
                submit.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent r){
                        try{  
                            Class.forName("com.mysql.cj.jdbc.Driver");  
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","igotocollegedaily");  
                            //here sonoo is database name, root is username and password  
                            Statement stmt=con.createStatement();  
                            Long cardNumber =Long.valueOf(Integer.parseInt(tf.getText()));   
                            String newpin = tf6.getText();
                            String query1="UPDATE detail SET Pin=? WHERE CardNo=?";
                            PreparedStatement ps=con.prepareStatement(query1);
                            ps.setString(1,newpin);
                            ps.setLong(2, cardNumber);
                            ps.executeUpdate();
                            con.close();  
                            }catch(Exception e){ System.out.println(e);}  
                    }
                });
            }
            public void mouseEntered(MouseEvent p){

            }
            public void mouseExited(MouseEvent p){

            }
            public void mousePressed(MouseEvent p){

            }
            public void mouseReleased(MouseEvent p){
                
            }
        });
        JLabel cn=new JLabel("CardNo->");
        f7.add(cn);
        cn.setBounds(20, 270, 150, 50);
        cn.setFont(new Font("Arial", Font.PLAIN, 20));
        cn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent p){
                JFrame f17=new JFrame();
                f17.setSize(700, 500);
                f17.setVisible(true);
                f17.setLayout(null);
                f17.getContentPane().setBackground(Color.CYAN);
                JLabel newname=new JLabel("Enter Cardno");
                f17.add(newname);
                newname.setBounds(250, 40, 150, 30);
                JTextField tf7=new JTextField();
                f17.add(tf7);
                tf7.setBounds(200,80,250,40);
                 JButton previous=new JButton("<-Previous");
                f17.add(previous);
                previous.setBounds(80,370,150,25);
                previous.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    f7.repaint();
                    f7.setVisible(true);
                    f17.dispose();
                }
            });
                f7.dispose();
                JButton submit=new JButton("Submit Edit->");
                f17.add(submit);
                submit.setBounds(450, 370, 150, 25);
                submit.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent r){
                        try{  
                            Class.forName("com.mysql.cj.jdbc.Driver");  
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","igotocollegedaily");  
                            //here sonoo is database name, root is username and password  
                            Statement stmt=con.createStatement();  
                            Long cardNumber =Long.valueOf(Integer.parseInt(tf.getText()));   
                            String newcardno = tf7.getText();
                            String query1="UPDATE detail SET CardNo=? WHERE CardNo=?";
                            PreparedStatement ps=con.prepareStatement(query1);
                            ps.setString(1,newcardno);
                            ps.setLong(2, cardNumber);
                            ps.executeUpdate();
                            con.close();  
                            }catch(Exception e){ System.out.println(e);}  
                    }
                });
            }
            public void mouseEntered(MouseEvent p){

            }
            public void mouseExited(MouseEvent p){

            }
            public void mousePressed(MouseEvent p){

            }
            public void mouseReleased(MouseEvent p){
                
            }
        });
        JLabel balance=new JLabel("Balance->");
        f7.add(balance);
        balance.setBounds(20, 310, 150, 50);
        balance.setFont(new Font("Arial", Font.PLAIN, 20));
        balance.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent p){
                JFrame f18=new JFrame();
                f18.setSize(700, 500);
                f18.setVisible(true);
                f18.setLayout(null);
                f18.getContentPane().setBackground(Color.CYAN);
                JLabel newname=new JLabel("Enter Balance");
                f18.add(newname);
                newname.setBounds(250, 40, 150, 30);
                JTextField tf8=new JTextField();
                f18.add(tf8);
                tf8.setBounds(200,80,250,40);
                 JButton previous=new JButton("<-Previous");
                f18.add(previous);
                previous.setBounds(80,370,150,25);
                previous.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    f7.repaint();
                    f7.setVisible(true);
                    f18.dispose();
                }
            });
                f7.dispose();
                JButton submit=new JButton("Submit Edit->");
                f18.add(submit);
                submit.setBounds(450, 370, 150, 25);
                submit.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent r){
                        try{  
                            Class.forName("com.mysql.cj.jdbc.Driver");  
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","igotocollegedaily");  
                            //here sonoo is database name, root is username and password  
                            Statement stmt=con.createStatement();  
                            Long cardNumber =Long.valueOf(Integer.parseInt(tf.getText()));   
                            String newbalance = tf8.getText();
                            String query1="UPDATE detail SET Balance=? WHERE CardNo=?";
                            PreparedStatement ps=con.prepareStatement(query1);
                            ps.setString(1,newbalance);
                            ps.setLong(2, cardNumber);
                            ps.executeUpdate();
                            con.close();  
                            }catch(Exception e){ System.out.println(e);}  
                    }
                });
            }
            public void mouseEntered(MouseEvent p){

            }
            public void mouseExited(MouseEvent p){

            }
            public void mousePressed(MouseEvent p){

            }
            public void mouseReleased(MouseEvent p){
                
            }
        });
        JButton submit=new JButton("Submit Edit->");
        f7.add(submit);
        submit.setBounds(450, 370, 150, 25);
            
        JButton previous=new JButton("<-Previous");
        f7.add(previous);
        previous.setBounds(80,370,150,25);
        previous.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            whattodoAdmin what=new whattodoAdmin();
            f7.dispose();
        }
    });
            }
        });
    }
}