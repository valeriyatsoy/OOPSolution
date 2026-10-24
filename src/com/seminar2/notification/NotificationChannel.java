package com.seminar2.notification;

import com.seminar2.customer.Customer;

import java.time.LocalTime;

// Factory Method: the CREATOR.
// A channel knows HOW to reach the customer, so it decides WHICH kind of
// Notification (the PRODUCT) to create. This class does not decide it -
// every subclass does, by overriding createNotification().
public abstract class NotificationChannel {

    // The factory method: no body here, every channel creates its own Notification subclass.
    public abstract Notification createNotification(Customer customer, String message);

    // Common logic for every channel. It works only with the abstract Notification,
    // so it never needs to know which subclass was created.
    public boolean notifyCustomer(Customer customer, String message, LocalTime now) {
        Notification notification = createNotification(customer, message);
        return notification.send(now);      // quiet hours from Seminar 7 still apply
    }
}
