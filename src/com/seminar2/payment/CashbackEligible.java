package com.seminar2.payment;

// A second interface: only some payment methods give cashback.
public interface CashbackEligible {

    double calculateCashback(double amount);
}
