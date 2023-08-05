package com.fms;

import java.sql.*;

public class HelloJDBC {

    static final String DB_URL = "jdbc:mysql://localhost/feedback_system";
    static final String USER = "root";
    static final String PASS = "sqlshark123";

    public HelloJDBC() {

    }

    void addDataIntoDatabase() {
        String name = "Vishal Vyas";
        String email = "vishal@gmail.com";
        String feedbackText = "";
        int rating = 1;

        String query =
                String.format("INSERT INTO user_feedbacks " +
                        "(user_id, customer_name, customer_email, feedback_text, is_deleted)" +
                        "VALUES (%d, '%s', '%s', '%s', %d)", 1, name, email, feedbackText, 1);
        System.out.println(query);


        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            boolean rs = stmt.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        HelloJDBC helloJDBC = new HelloJDBC();
        for (int i = 0; i < 10; i++) {
            helloJDBC.addDataIntoDatabase();
        }
    }

}
