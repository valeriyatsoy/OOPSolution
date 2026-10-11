package com.seminar2;

// A gift card IS-A Product (it can be bought and presented to another person)
// and it CAN pay (Payable). A class extends only one class,
// but it can implement any number of interfaces.
public class GiftCard extends Product implements Payable {

    private String code;
    private double balance;

    public GiftCard(String name, double price, String code) {
        // a gift card is never out of stock; the money on it equals its price
        super(name, price, 1, true, 'A');
        this.code = code;
        this.balance = price;
    }

    public String getCode() {
        return code;
    }

    public double getBalance() {
        return Math.round(balance * 100.0) / 100.0;
    }

    // Product is abstract, so GiftCard MUST implement this method.
    @Override
    public double calculateDeliveryCost() {
        return 0.0; // the code is sent by e-mail
    }

    // No VAT on gift cards: you pay exactly the amount loaded on the card.
    @Override
    public double getPriceWithTax() {
        return getPrice();
    }

    // Required by the Payable interface.
    @Override
    public boolean processPayment(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive - payment was not made.");
            return false;
        }
        if (amount > balance) {
            System.out.println("Payment declined: gift card " + code + " has only " + getBalance() + " left.");
            return false;
        }
        balance -= amount;
        System.out.println("Paid " + amount + " with gift card " + code + ". Left on the card: " + getBalance());
        return true;
    }
}
