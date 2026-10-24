package com.seminar2.notification;

import com.seminar2.customer.Customer;

// A new product: sends the notification as a text message (SMS).
public class SmsNotification extends Notification {

    private String phoneNumber;

    public SmsNotification(Customer customer, String message, String phoneNumber) {
        super(customer, message);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void send() {
        System.out.println("SMS to " + phoneNumber + " for "
                + getCustomer().getName() + ": " + getMessage());
    }
}
