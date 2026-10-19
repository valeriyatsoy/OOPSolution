package com.seminar2;

import java.time.LocalTime;

// An abstract class describes what every notification has in common.
// We can never create a "plain" Notification - only a concrete kind of it
// (MobileNotification or WebNotification).
public abstract class Notification {

    private Customer customer;
    private String message;

    // Abstract classes can have constructors: the subclasses call them with super(...)
    public Notification(Customer customer, String message) {
        this.customer = customer;
        this.message = message;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getMessage() {
        return message;
    }

    // An abstract method has no body: every subclass must decide HOW to send.
    public abstract void send();

    // A concrete method with a default rule: subclasses MAY override it
    // (unlike send(), which they MUST implement).
    // By default a notification can be sent at any time of the day.
    public boolean canSendAt(LocalTime time) {
        return true;
    }
}
