package com.seminar2;

public class Product {

    private String name;
    private double price;
    private int quantity;
    public boolean inStock;
    public char grade;

    public Product() {
        this.name = "Unnamed product";
        this.price = 0.0;
        this.quantity = 0;
    }

    public Product(String name, double price, int quantity, boolean inStock, char grade) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.inStock = inStock;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            System.out.println("Invalid name - name was not changed.");
            return;
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("Price cannot be negative - price was not changed.");
            return;
        }
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            System.out.println("Quantity cannot be negative - quantity was not changed.");
            return;
        }
        this.quantity = quantity;
    }

    public double getPriceWithTax() {
        // 12% VAT, rounded to two decimal places
        return Math.round(price * 1.12 * 100.0) / 100.0;
    }

    public void deliver() {
        System.out.println("Delivering " + name + " to the customer.");
    }

    public double calculateDeliveryCost() {
        return 5.0; // standard flat delivery fee
    }
}
