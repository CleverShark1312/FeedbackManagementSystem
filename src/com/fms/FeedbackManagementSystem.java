package com.fms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FeedbackManagementSystem extends JFrame {

    private JMenuBar menuBar;

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
    private MyLoginFrame loginFrame = null;
    private AddUserFrame addUserFrame = null;
    private void centerLoginFrame(MyLoginFrame loginFrame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - loginFrame.getWidth()) / 2;
        int centerY = (screenSize.height - loginFrame.getHeight()) / 2;
        loginFrame.setLocation(centerX, centerY);
    }
    private void centreAddUserFrame(AddUserFrame addUserFrame){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (screenSize.width - addUserFrame.getWidth()) / 2;
        int centerY = (screenSize.height - addUserFrame.getHeight()) / 2;
        addUserFrame.setLocation(centerX, centerY);
    }
    private void createMenuBar() {
        menuBar = new JMenuBar();
        JMenu loginMenu = new JMenu("Login");
        JMenu addUserMenu = new JMenu("AddUser");
        menuBar.add(loginMenu);
        menuBar.add(addUserMenu);
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
       addUserMenu.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               if (addUserFrame == null || !addUserFrame.isVisible()) {
                   addUserFrame = new AddUserFrame();
                   addUserFrame.setSize(500, 500);
                   centreAddUserFrame(addUserFrame);
               }
               addUserFrame.setVisible(true);
           }
       });
    }
}
