package com.fms;

import javax.swing.*;
import java.awt.*;

public class MyLoginFrame extends JFrame {
    JPanel loginPanel = new JPanel();
    JTextField textField = new JTextField(20);
    JPasswordField pswdField = new JPasswordField(20);
    JButton loginButton = new JButton("LOGIN");
    JLabel userName = new JLabel("Name");
    
    JLabel password = new JLabel("Password");
    private void loginUi(){
        getContentPane().add(loginPanel);

        loginPanel.add(userName);
        loginPanel.add(textField);
        loginPanel.add(password);
        loginPanel.add(pswdField);
        loginPanel.add(loginButton);


    }
    public MyLoginFrame() {
        super("Login Page");
        loginUi();

    }
}
