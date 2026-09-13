package com.seminar2;

public class Main {
    public static void main(String[] args) {
        Product product = new Product();

        product.name = "Wireless Mouse";
        product.price = 19.99;
        product.quantity = 50;
        product.inStock = true;
        product.grade = 'A';

        System.out.println("Name: " + product.name);
        System.out.println("Price: " + product.price);
        System.out.println("Quantity: " + product.quantity);
        System.out.println("In stock: " + product.inStock);
        System.out.println("Grade: " + product.grade);
    }
}
