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

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
