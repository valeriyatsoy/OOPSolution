package com.seminar2.adapter;

import com.seminar2.payment.Payable;

// Adapter: the ADAPTER (like StreamingToMp3Adapter in the handout).
// It IS a Payable (implements the TARGET interface our shop already uses) and
// HAS a QuickPayWallet (the ADAPTEE it wraps) - an object adapter.
// Customer.pay(Payable, amount) - the CLIENT - does not change at all and never
// knows that a QuickPayWallet is behind this object.
public class QuickPayAdapter implements Payable {

    private QuickPayWallet wallet;
    private String phoneNumber;

    public QuickPayAdapter(QuickPayWallet wallet, String phoneNumber) {
        this.wallet = wallet;
        this.phoneNumber = phoneNumber;
    }

    // Our call:      processPayment(127.04)                  -> boolean
    // Wallet's call: transfer("+998 ...", 12704)             -> "OK" / "DECLINED"
    @Override
    public boolean processPayment(double amount) {
        long amountInTiyin = Math.round(amount * 100);              // double -> whole tiyin
        String status = wallet.transfer(phoneNumber, amountInTiyin); // other name, extra argument
        boolean paid = status.equals("OK");                         // String status -> boolean
        if (paid) {
            System.out.println("Paid " + amount + " with QuickPay (" + phoneNumber + ").");
        } else {
            System.out.println("Payment declined by QuickPay.");
        }
        return paid;
    }
}
