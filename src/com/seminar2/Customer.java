package com.seminar2;

public class Customer {

    private String name;
    private int loyaltyPoints;
    private double accountBalance;

    public Customer(String name, int loyaltyPoints, double accountBalance) {
        this.name = name;
        this.loyaltyPoints = loyaltyPoints;
        this.accountBalance = accountBalance;
    }

    public String getName() {
        return name == null ? "Unknown" : name.trim();
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public double getAccountBalance() {
        return Math.round(accountBalance * 100.0) / 100.0;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
