package com.seminar2.adapter;

// Adapter: the ADAPTEE (like StreamingAudio in the handout).
// A ready-made SDK from an external mobile wallet. We CANNOT change it, and it
// does not fit our shop:
//   - the method is called transfer(), not processPayment();
//   - it needs the customer's phone number;
//   - amounts are whole tiyin (1/100 of the main unit) in a long, not a double;
//   - it answers with a String status ("OK" / "DECLINED"), not a boolean.
public class QuickPayWallet {

    private long balanceInTiyin;

    public QuickPayWallet(long balanceInTiyin) {
        this.balanceInTiyin = balanceInTiyin;
    }

    public String transfer(String phoneNumber, long amountInTiyin) {
        System.out.println("  [QuickPay] Transfer of " + amountInTiyin + " tiyin from " + phoneNumber + "...");
        if (amountInTiyin <= 0 || amountInTiyin > balanceInTiyin) {
            return "DECLINED";
        }
        balanceInTiyin -= amountInTiyin;
        return "OK";
    }
}
