package com.fms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyLoginFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME:-");
    JLabel passwordLabel = new JLabel("PASSWORD:-");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(200, 300, 100, 30);
      //  resetButton.setBounds(200, 300, 100, 30);


    }
    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }

    public void addActionEvent(){
        loginButton.addActionListener(this);
    }

    public  MyLoginFrame(){
        super("LOGIN PAGE");
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton){
            String userText;
            String pswdText;
            userText = userTextField.getText();
            pswdText = passwordField.getText();
            if(userText.equals("Harshita") && pswdText.equals("345")){
                JOptionPane.showMessageDialog(this,"Login Successful");
            }else{
                JOptionPane.showMessageDialog(this, "Invalid username or password");
            }
        }


    }
}

