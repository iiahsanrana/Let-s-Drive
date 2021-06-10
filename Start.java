package chat;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Start extends JFrame {
    
JLabel l1;
    JButton b1, b2, b3, b4, b5;
    JPanel p1;
    Start()
    {
        p1 = new JPanel();

        JPanel p2 = new JPanel(); 
        l1 = new JLabel("WELCOME TO LET'S DRIVE");
        setSize(500,500);
        setLayout(new BorderLayout());
        b1= new JButton(" USER SIGN UP ");
        b2= new JButton("USER SIGN IN ");
        b3= new JButton("EXIT");
       
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);

        p2.add(l1);


        p1.setLayout(new FlowLayout());
        
        add(p2,BorderLayout.NORTH);
        add(p1,BorderLayout.CENTER);
        
        setVisible(true);
        
        MyActionListener m = new MyActionListener();
        
        b1.addActionListener(m);
        b2.addActionListener(m);
        b3.addActionListener(m);
    }
    public class MyActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource()== b1)
            {
                dispose();
                SignUp user = new SignUp();
            }
            if (e.getSource()== b2)
            {
                dispose();
                SignIn user1 = new SignIn();
            }
             
            if (e.getSource() == b3)
            {
                dispose();
                System.exit(0);
            }
        }
    }
    public static void main(String[] args) {
        Start app = new Start();
    }
}

