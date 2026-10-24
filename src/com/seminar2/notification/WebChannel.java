package com.seminar2.notification;

import com.seminar2.customer.Customer;

// A concrete creator: notifications in the customer's web browser.
public class WebChannel extends NotificationChannel {

    private String browser;

    public WebChannel(String browser) {
        this.browser = browser;
    }

    @Override
    public Notification createNotification(Customer customer, String message) {
        return new WebNotification(customer, message, browser);
    }
}
