package com.fms;

public class UserFeedback {
    int id;
    int user_id;
    String customer_name;
    String customer_email;
    String feedback_text;

    public UserFeedback(int id, int user_id, String customer_name, String customer_email, String feedback_text ){
        this.id= id;
        this.user_id=user_id;
        this.customer_name=customer_name;
        this.customer_email=customer_email;
        this.feedback_text=feedback_text;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return user_id;
    }

    public String getCustomerName() {
        return customer_name;
    }

    public String getCustomerEmail() {
        return customer_email;
    }

    public String getFeedbackText() {
        return feedback_text;
    }
}
