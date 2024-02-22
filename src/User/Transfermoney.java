package User;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
public class Transfermoney {
    public Transfermoney(){
        JFrame jf5=new JFrame();
        jf5.setSize(700, 500);
        jf5.setVisible(true);
        jf5.setLayout(null);
        jf5.getContentPane().setBackground(Color.CYAN);
        JButton previous=new JButton("<-Previous");
        jf5.add(previous);
        previous.setBounds(50, 370, 150, 25);
        previous.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            whattodo what=new whattodo();
            jf5.dispose();
        }
    });
    }
}
