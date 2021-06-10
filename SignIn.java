package chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.*;

import chat.chat_client;
import chat.chat_server;

import java.awt.*;
import java.util.*;

public class SignIn extends JFrame implements Serializable{
    JFrame frame;
        JLabel l1,l2;
        JTextField t1;
        JPasswordField jpf;
        JButton b1,b2;
        
        private static int index;
        public static int getIndex()
        {
            return index;
        }
        public SignIn()
        {
            index=0;
            

            frame = new JFrame("Login");
            frame.setSize(500,500);
            frame.setLayout(null);
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            l1 = new JLabel ("Enter Name");
            l2 = new JLabel ("Enter Password");
            
            l1.setBounds(58, 97, 120, 23);
            frame.getContentPane().add(l1);
            l2.setBounds(58, 187, 120, 23);
            frame.getContentPane().add(l2);
            
            t1 = new JTextField(20);
            t1.setBounds(214, 98, 154, 23);
            frame.getContentPane().add(t1);
            
            jpf = new JPasswordField(20);
            jpf.setBounds(214, 188, 154, 23);
            frame.getContentPane().add(jpf);
            
            b1 = new JButton("Login");
            b1.setBounds(100, 350, 89, 30);
            b2 = new JButton("Home");
            b2.setBounds(200, 350, 89, 30);
            
            frame.getContentPane().add(b1);
            frame.getContentPane().add(b2);
            
            b1.addActionListener(new MyListener());
            b2.addActionListener(new MyListener());
            frame.setVisible(true);
        }
        public class MyListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()== b1)
                {
                        if (checkLogin())
                            {   
                                frame.dispose();
                                
                                chat_server s = new chat_server();
                                s.setVisible(true);
                                
                                chat_client c = new chat_client();
                                c.setVisible(true);
                                
                                //afterSellerSignIn a = new afterSellerSignIn();
                            }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Invalid Username or Passowrd");
                        }        
                    
                }
                    
                if(e.getSource()== b2)
                {
                    frame.dispose();
                    Start s = new Start();
                }
            }
        }

        private boolean checkLogin(){
            ArrayList<user> list = user.readFromFile1();
            try {
                for(int i=0; i<list.size(); i++) {
                    if(list.get(i).getUserName().equals(t1.getText()) && list.get(i).getPassword().equals(jpf.getText())){
                        return true;
                    }
                    index++;
                    if(index>=list.size()){
                        index=0;
                        throw new IndexOutOfBoundsException(); 
                    }
                }
                
            } catch (IndexOutOfBoundsException e) {
                return false;
            }
            return false;
        }
        
        
        public static void main(String[] args) {
            SignIn s = new SignIn(); 
        }    
    }
    
