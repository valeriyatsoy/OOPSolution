package com.seminar2;

// Our own exception type. It extends Exception (not RuntimeException), so it is
// CHECKED: every method that throws it must say "throws InsufficientBalanceException",
// and every caller must catch it or pass it on - the compiler makes sure.
public class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(double needed, double available) {
        super("Not enough money on the account: needed " + needed + ", available " + available);
    }
}
