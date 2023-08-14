package com.fms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


import static com.fms.HelloJDBC.*;

public class AddUserFeedbackFrame extends JFrame {

    public AddUserFeedbackFrame() {
        setTitle("Collect Feedback");
        createUI();
    }

    private void createUI() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));

        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(inputPanel, BorderLayout.CENTER);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);

        inputPanel.add(new JLabel("Name:"), constraints);

        constraints.gridx = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;
        JTextField nameField = new JTextField(20);
        inputPanel.add(nameField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.weightx = 0.0;
        inputPanel.add(new JLabel("Email:"), constraints);

        constraints.gridx = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;
        JTextField emailField = new JTextField(20);
        inputPanel.add(emailField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.weightx = 0.0;
        inputPanel.add(new JLabel("Feedback:"), constraints);

        constraints.gridx = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        JTextArea feedbackArea = new JTextArea(5, 20);
        feedbackArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(feedbackArea);
        inputPanel.add(scrollPane, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.fill = GridBagConstraints.NONE;
        constraints.weightx = 0.0;
        //inputPanel.add(new JLabel("Rating:"), constraints);

        constraints.gridx = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;
        JPanel ratingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        ButtonGroup ratingButtonGroup = new ButtonGroup();
//        for (int i = 1; i <= 5; i++) {
//            JRadioButton radioButton = new JRadioButton(i + " stars");
//            ratingButtonGroup.add(radioButton);
//            ratingPanel.add(radioButton);
//        }
        inputPanel.add(ratingPanel, constraints);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        JButton submitButton = new JButton("Add");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get user input data
                String customer_name = nameField.getText();
                String customer_email = emailField.getText();
                String customer_feedback = feedbackArea.getText();


                //insert data into database
                addFeedbackIntoDatabase(customer_name, customer_email, customer_feedback);

                JOptionPane.showMessageDialog(AddUserFeedbackFrame.this,
                        "Feedback added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        buttonPanel.add(submitButton);

        add(mainPanel);
    }

    private void addFeedbackIntoDatabase(String customer_name, String customer_email, String customer_feedback) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String insertQuery = "INSERT INTO user_feedbacks (user_id,customer_name, customer_email, feedback_text) VALUES (?,?, ?, ?)";
            System.out.println("User_id: " + MyLoginFrame.admin_id + " Name: " + customer_name + " email: " + customer_email + " feedback: " + customer_feedback);
            PreparedStatement pstmt = connection.prepareStatement(insertQuery);
            pstmt.setInt(1, MyLoginFrame.admin_id);
            pstmt.setString(2, customer_name);
            pstmt.setString(3, customer_email);
            pstmt.setString(4, customer_feedback);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
