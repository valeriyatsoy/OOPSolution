package com.seminar2.notification;

import com.seminar2.customer.Customer;

// A concrete creator: push messages to one of the customer's devices.
public class MobileChannel extends NotificationChannel {

    private String deviceName;

    public MobileChannel(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public Notification createNotification(Customer customer, String message) {
        return new MobileNotification(customer, message, deviceName);
    }
}
