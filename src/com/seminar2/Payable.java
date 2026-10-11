package com.seminar2;

// An interface is a contract: "whoever implements me can pay".
// It says WHAT can be done, not HOW - every class writes its own processPayment().
public interface Payable {

    // Interface methods are public and abstract by default.
    boolean processPayment(double amount);
}
