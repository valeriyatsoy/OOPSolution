package com.seminar2;

public class Main {
    public static void main(String[] args) {
        Product product = new Product("Wireless Mouse", 19.99, 50, true, 'A');

        System.out.println("Name: " + product.getName());
        System.out.println("Price: " + product.getPrice());
        System.out.println("Quantity: " + product.getQuantity());
        System.out.println("In stock: " + product.inStock);
        System.out.println("Grade: " + product.grade);

        System.out.println();
        System.out.println("Using the setters:");
        product.setPrice(24.99);
        System.out.println("Updated price: " + product.getPrice());

        product.setQuantity(-5);
        System.out.println("Quantity after invalid update attempt: " + product.getQuantity());
    }
}
