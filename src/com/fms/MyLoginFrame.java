package com.fms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyLoginFrame extends JFrame implements ActionListener {
    JPanel loginPanel = new JPanel();
    JTextField textField = new JTextField(20);
    JPasswordField pswdField = new JPasswordField(20);
    JButton loginButton = new JButton("LOGIN");
    JLabel userName = new JLabel("Name");
    JLabel password = new JLabel("Password");
    JLabel success = new JLabel();
    private void loginUi(){
      add(loginPanel);

        loginPanel.add(userName);
        loginPanel.add(textField);
        loginPanel.add(password);
        loginPanel.add(pswdField);
        loginPanel.add(loginButton);
        loginPanel.add(success);
        loginButton.addActionListener(this);
    }
    public MyLoginFrame() {
        super("Login Page");
        loginUi();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = textField.getText();
        String password = pswdField.getText();
        System.out.println(name+" "+ password);
        if(name.equals("Harshita")&& password.equals("345")){
            success.setText("Login Successful!");
        }else{
            success.setText("Access denied");
        }

    }
}
