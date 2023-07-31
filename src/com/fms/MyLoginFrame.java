package com.fms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyLoginFrame extends JFrame implements ActionListener {
    Container container = getContentPane();
    JLabel userLabel ;
    JLabel passwordLabel ;
    JTextField userTextField ;
    JPasswordField passwordField ;
    JButton loginButton = new JButton("LOGIN");
   // JButton resetButton = new JButton("RESET");
   // JCheckBox showPassword = new JCheckBox("Show Password");
    public MyLoginFrame() {
        super("LOGIN PAGE");
//        setLayoutManager();
//        setLocationAndSize();
//        addComponentsToContainer();
        userTextField = new JTextField(20);
        passwordField = new JPasswordField(20);
        addActionEvent();

        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();

        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(new JLabel("USERNAME:-"),gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(userTextField,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("PASSWORD:-"),gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(passwordField,gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(loginButton,gbc);
        add(panel, BorderLayout.CENTER);

//        gbc.gridx = 3;
//        gbc.gridy = 2;
//        gbc.fill = GridBagConstraints.CENTER;
//        panel.add(resetButton,gbc);
//        add(panel, BorderLayout.CENTER);



    }
    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
       // showPassword.addActionListener(this);
      //  resetButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //login functionality
        if (e.getSource() == loginButton) {
            String userText;
            String pswdText;
            userText = userTextField.getText();
            pswdText = passwordField.getText();
            if (userText.equals("Harshita") && pswdText.equals("345")) {
                JOptionPane.showMessageDialog(this, "Login Successful");

            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
            }
        }
        //show password functionality
//        if (e.getSource() == showPassword) {
//            if (showPassword.isSelected()) {
//                passwordField.setEchoChar((char) 0);
//            } else {
//                passwordField.setEchoChar('*');
//
//            }
        //reset functionality
//        if (e.getSource() == resetButton) {
//            userTextField.setText("");
//            passwordField.setText("");
//            //showPassword.setSelected(false);
//        }
    }





}

