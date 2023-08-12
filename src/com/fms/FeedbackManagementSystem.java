package com.fms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static com.fms.HelloJDBC.*;

public class FeedbackManagementSystem extends JFrame {

    private JMenuBar menuBar;
    private MyLoginFrame loginFrame = null;
    private AddUserFeedbackFrame userFeedBackFrame = null;

    public FeedbackManagementSystem() {
        super("Feedback Management System");
        createMenuBar();
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
    private void centerLoginFrame(MyLoginFrame loginFrame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - loginFrame.getWidth()) / 2;
        int centerY = (screenSize.height - loginFrame.getHeight()) / 2;
        loginFrame.setLocation(centerX, centerY);
    }
    private void centreAddUserFrame(AddUserFeedbackFrame userFeedBackFrame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - userFeedBackFrame.getWidth()) / 2;
        int centerY = (screenSize.height - userFeedBackFrame.getHeight()) / 2;
        userFeedBackFrame.setLocation(centerX, centerY);
    }
    private void createMenuBar() {
        menuBar = new JMenuBar();
        JMenu loginMenu = new JMenu("Login");
        JMenu addFeedbackMenu = new JMenu("Add Feedback");
        menuBar.add(loginMenu);
        menuBar.add(addFeedbackMenu);
        setJMenuBar(menuBar);
        loginMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (loginFrame == null || !loginFrame.isVisible()) {
                    loginFrame = new MyLoginFrame();
                    loginFrame.setSize(500, 500);
                    centerLoginFrame(loginFrame);
                }
                loginFrame.setVisible(true);
            }
        });
        addFeedbackMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (userFeedBackFrame == null || !userFeedBackFrame.isVisible()) {
                    userFeedBackFrame = new AddUserFeedbackFrame();
                    userFeedBackFrame.setSize(500, 500);
                    centreAddUserFrame(userFeedBackFrame);
                }
                userFeedBackFrame.setVisible(true);
            }
        });
    }
}
