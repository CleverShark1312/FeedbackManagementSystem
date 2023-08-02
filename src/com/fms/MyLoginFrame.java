package com.fms;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;

import static com.fms.HelloJDBC.*;

public class MyLoginFrame extends JFrame implements ActionListener, KeyListener {
    Container container = getContentPane();
    JLabel userLabel;
    JLabel passwordLabel;
    JTextField userTextField;
    JPasswordField passwordField;
    JButton loginButton = new JButton("LOGIN");

    // JButton resetButton = new JButton("RESET");
    // JCheckBox showPassword = new JCheckBox("Show Password");
    public MyLoginFrame(Component component) {
        setTitle("Login Page");
//        setLayoutManager();
//        setLocationAndSize();
//        addComponentsToContainer();
        setLocationRelativeTo(component);

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
        panel.add(new JLabel("USERNAME:-"), gbc);

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
        loginButton.addKeyListener(this);

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        // showPassword.addActionListener(this);
        //  resetButton.addActionListener(this);
        loginButton.addKeyListener(this);
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

    private boolean isValidUser(String email, String password) {
        //TODO Replace hardcoded logic with actual DB check
        String query = "SELECT * FROM users WHERE email = '"+email+"' AND user_password='"+password+"'";
        System.out.println(query);
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return (email.equals("Harshita") && password.equals("345"));
    }


    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            String emailText = userTextField.getText();
            String pswdText = passwordField.getText();

            boolean isValidUser = isValidUser(emailText, pswdText);
            if (isValidUser) {
                JOptionPane.showMessageDialog(this, "Login Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}

