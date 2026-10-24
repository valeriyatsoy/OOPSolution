package com.seminar2.notification;

import com.seminar2.customer.Customer;

// A new creator for the new product. No existing class had to change.
public class SmsChannel extends NotificationChannel {

    private String phoneNumber;

    public SmsChannel(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public Notification createNotification(Customer customer, String message) {
        return new SmsNotification(customer, message, phoneNumber);
    }
}
