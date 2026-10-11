package com.seminar2;

// A class can implement several interfaces, separated by commas.
public class BankCard implements Payable, CashbackEligible {

    private String cardNumber;
    private String holderName;
    private double balance;

    public BankCard(String cardNumber, String holderName, double balance) {
        this.cardNumber = cardNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Only the last four digits are shown, e.g. **** 9012
    public String getMaskedNumber() {
        return "**** " + cardNumber.substring(cardNumber.length() - 4);
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return Math.round(balance * 100.0) / 100.0;
    }

    @Override
    public boolean processPayment(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive - payment was not made.");
            return false;
        }
        if (amount > balance) {
            System.out.println("Payment declined: not enough money on card " + getMaskedNumber() + ".");
            return false;
        }
        balance -= amount;
        System.out.println("Paid " + amount + " by bank card " + getMaskedNumber()
                + ". Money left on the card: " + getBalance());
        return true;
    }

    // Required by the CashbackEligible interface: 1% of every card payment
    @Override
    public double calculateCashback(double amount) {
        return Math.round(amount * 0.01 * 100.0) / 100.0;
    }
}
