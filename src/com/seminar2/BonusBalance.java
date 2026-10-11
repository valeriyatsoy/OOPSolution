package com.seminar2;

// Bonus points collected by a customer; 1 point pays for 1 unit of money.
public class BonusBalance implements Payable {

    private double points;

    public BonusBalance(double points) {
        this.points = points;
    }

    public double getPoints() {
        return Math.round(points * 100.0) / 100.0;
    }

    public void addPoints(double amount) {
        if (amount <= 0) {
            System.out.println("Bonus amount must be positive - points were not added.");
            return;
        }
        points += amount;
    }

    @Override
    public boolean processPayment(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be positive - payment was not made.");
            return false;
        }
        if (amount > points) {
            System.out.println("Payment declined: only " + getPoints() + " bonus points available.");
            return false;
        }
        points -= amount;
        System.out.println("Paid " + amount + " with bonus points. Points left: " + getPoints());
        return true;
    }
}
