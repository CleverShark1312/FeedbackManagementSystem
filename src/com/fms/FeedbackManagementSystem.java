package com.fms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;

import static com.fms.HelloJDBC.*;
public class FeedbackManagementSystem extends JFrame {
    //ArrayList
    ArrayList<UserFeedback> userFeedbacks = new ArrayList<UserFeedback>();
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
//                ArrayList<UserFeedback> userFeedbacks = feedbackManagementSystem.getUserFeedbacks("priyansh", "priyansh12@gmail.com", "Nice product!");
//                feedbackManagementSystem.printUserFeedbacks();
//                feedbackManagementSystem.setVisible(true);
//                UserFeedback fd = new UserFeedback(0,0,"","","");
                ArrayList<UserFeedback> userFeedbacks =  feedbackManagementSystem.getUserFeedbacks();
                feedbackManagementSystem.printUserFeedbacks(userFeedbacks);
                feedbackManagementSystem.setVisible(true);

            }
        });
    }
    public ArrayList<UserFeedback> getUserFeedbacks() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
//            String userQuery= "SELECT * FROM user_feedbacks WHERE customer_name = ? AND customer_email = ? AND feedback_text = ?";
            String userQuery= "SELECT * FROM user_feedbacks;";
            PreparedStatement pst = connection.prepareStatement(userQuery);

//            pst.setString(1,customer_name);
//            pst.setString(2,customer_email);
//            pst.setString(3,feedback_text);

            ResultSet resultSet = pst.executeQuery();

            // userFeedbacks.clear();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int user_id = resultSet.getInt("user_id");
                String name = resultSet.getString("customer_name");
                String email = resultSet.getString("customer_email");
                String feedbackText = resultSet.getString("feedback_text");

                userFeedbacks.add(new UserFeedback(id, user_id, name, email, feedbackText));
            }
            resultSet.close();
            pst.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userFeedbacks;
    }public void printUserFeedbacks(ArrayList<UserFeedback> userFeedbacks) {
        for (UserFeedback feedback : userFeedbacks) {
            System.out.println("ID: " + feedback.getId());
              System.out.println("User ID: " + feedback.getUserId());
            System.out.println("Customer Name: " + feedback.getCustomerName());
            System.out.println("Customer Email: " + feedback.getCustomerEmail());
            System.out.println("Feedback Text: " + feedback.getFeedbackText());
            System.out.println("----------------------------------------");
        }
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
