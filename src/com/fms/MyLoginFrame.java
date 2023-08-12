package com.fms;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

import static com.fms.HelloJDBC.*;

public class MyLoginFrame extends JFrame implements ActionListener {
    public static int admin_id=-1;
    Container container = getContentPane();
    JLabel userLabel;
    JLabel passwordLabel;
    JTextField userTextField;
    JPasswordField passwordField;
    JButton loginButton = new JButton("LOGIN");
    // JButton resetButton = new JButton("RESET");
    // JCheckBox showPassword = new JCheckBox("Show Password");
    public MyLoginFrame() {
        setTitle("Login Page");
//        setLayoutManager();
//        setLocationAndSize();
//        addComponentsToContainer();
//        setLocationRelativeTo(component);

        userTextField = new JTextField();
        userTextField.setColumns(35);
        userTextField.setBorder(new EmptyBorder(15, 0, 15, 0));

        passwordField = new JPasswordField(20);
        passwordField.setBorder(new EmptyBorder(15, 0, 15, 0));
        addActionEvent();

        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();

        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(new JLabel("EMAIL ID:-"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(userTextField, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("PASSWORD:-"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(passwordField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.CENTER;
        panel.add(loginButton, gbc);
        add(panel, BorderLayout.CENTER);

//        gbc.gridx = 3;
//        gbc.gridy = 2;
//        gbc.fill = GridBagConstraints.CENTER;
//        panel.add(resetButton,gbc);
//        add(panel, BorderLayout.CENTER);

        //Enter button functionality on Login button
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    performlogin();
                }
            }
        });
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);

        // showPassword.addActionListener(this);
        //  resetButton.addActionListener(this);
    }

    private void performlogin() {
        String emailText = userTextField.getText();
        String pswdText = passwordField.getText();

        boolean isValidUser = isValidUser(emailText, pswdText);
        if (isValidUser) {
            JOptionPane.showMessageDialog(this, "Login Successful");
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password");
            userTextField.setText("");
            passwordField.setText("");
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //login functionality
        if (e.getSource() == loginButton) {
            String emailText = userTextField.getText();
            String pswdText = passwordField.getText();

            boolean isValidUser = isValidUser(emailText, pswdText);
            if (isValidUser) {
                JOptionPane.showMessageDialog(this, "Login Successful");

            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
            }
        } else if (e.getSource() == loginButton) {
            performlogin();
        }

        //Add users functionality

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


    private  boolean isValidUser(String email, String password) {
        // TODO Replace hardcoded logic with actual DB check
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "SELECT * FROM users WHERE email = ? AND user_password = ?";
            System.out.println(" Email  = " + email + " " + "AND user_password = " + password);

            PreparedStatement pstmt = conn.prepareStatement(query);

            pstmt.setString(1, email);
            pstmt.setString(2, password);



            ResultSet rs = pstmt.executeQuery();
            // Check if a user with the given email and password exists in the database
            boolean isValidUser = rs.next();
            admin_id =rs.getInt("id");
            System.out.println("The admin is: "+admin_id);
            rs.close();
            pstmt.close();
            conn.close();
            return isValidUser;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

