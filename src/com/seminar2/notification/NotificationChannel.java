package com.seminar2.notification;

import com.seminar2.customer.Customer;
import com.seminar2.observer.OrderObserver;
import com.seminar2.order.Order;
import com.seminar2.order.OrderStatus;

import java.time.LocalTime;

// Factory Method: the CREATOR.
// A channel knows HOW to reach the customer, so it decides WHICH kind of
// Notification (the PRODUCT) to create. This class does not decide it -
// every subclass does, by overriding createNotification().
// Observer (Seminar 12): every channel is also an OBSERVER of orders.
public abstract class NotificationChannel implements OrderObserver {

    // The factory method: no body here, every channel creates its own Notification subclass.
    public abstract Notification createNotification(Customer customer, String message);

    // Common logic for every channel. It works only with the abstract Notification,
    // so it never needs to know which subclass was created.
    public boolean notifyCustomer(Customer customer, String message, LocalTime now) {
        Notification notification = createNotification(customer, message);
        return notification.send(now);      // quiet hours from Seminar 7 still apply
    }

    // Observer: called by the Order whenever its status changes.
    @Override
    public void onStatusChanged(Order order, OrderStatus newStatus) {
        String message = "Order " + order.getOrderId() + " is now " + newStatus;
        createNotification(order.getCustomer(), message).send();
    }
}
