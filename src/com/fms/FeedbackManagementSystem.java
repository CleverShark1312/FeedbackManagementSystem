package com.fms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FeedbackManagementSystem extends JFrame {
    private JTextField nameField;
    private JTextField emailField;
    private JTextArea feedbackArea;
    private ButtonGroup ratingButtonGroup;
    private JButton submitButton;
    private JMenuBar menuBar;

    public FeedbackManagementSystem() {
        super("Feedback Management System");
        createMenuBar();
        createUI();
        pack();
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                FeedbackManagementSystem feedbackManagementSystem = new FeedbackManagementSystem();
                feedbackManagementSystem.setVisible(true);
            }
        });
    }

    private void createMenuBar() {
        menuBar = new JMenuBar();
        JMenu loginMenu = new JMenu("Login");
        menuBar.add(loginMenu);
        setJMenuBar(menuBar);

        // Add MouseActionListener to the login menu
        loginMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame loginFrame = new JFrame("LOGIN PAGE");
                loginFrame.setSize(500, 500);
                loginFrame.setVisible(true);
            }
        });
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
        nameField = new JTextField(20);
        inputPanel.add(nameField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.NONE;
        constraints.weightx = 0.0;
        inputPanel.add(new JLabel("Email:"), constraints);

        constraints.gridx = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;
        emailField = new JTextField(20);
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
        feedbackArea = new JTextArea(5, 20);
        feedbackArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(feedbackArea);
        inputPanel.add(scrollPane, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.fill = GridBagConstraints.NONE;
        constraints.weightx = 0.0;
        inputPanel.add(new JLabel("Rating:"), constraints);

        constraints.gridx = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;
        JPanel ratingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ratingButtonGroup = new ButtonGroup();
        for (int i = 1; i <= 5; i++) {
            JRadioButton radioButton = new JRadioButton(i + " stars");
            ratingButtonGroup.add(radioButton);
            ratingPanel.add(radioButton);
        }
        inputPanel.add(ratingPanel, constraints);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        submitButton = new JButton("Submit Feedback");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(FeedbackManagementSystem.this,
                        "Feedback submitted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        buttonPanel.add(submitButton);

        add(mainPanel);
    }

}
