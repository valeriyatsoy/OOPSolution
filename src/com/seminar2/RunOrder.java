package com.seminar2;

// A second class with a main method (a second entry point of the program):
// Main keeps the inheritance demos from Seminar 3, RunOrder is where we
// practise composition -- building and placing an order.
public class RunOrder {
    public static void main(String[] args) {
        System.out.println("=== Customer ===");
        ShippingAddress home = new ShippingAddress("12 Amir Temur St", "Tashkent", "100000");
        Customer customer = new Customer("Aziz Karimov", 120, 45.567, home);

        System.out.println("Name: " + customer.getName());
        System.out.println("Ships to: " + customer.getShippingAddress());

        System.out.println();
        System.out.println("=== Order items ===");
        PhysicalProduct laptop = new PhysicalProduct("Laptop", 899.99, 10, true, 'A', 2.1, true);
        DigitalProduct course = new DigitalProduct("Java Basics Video Course", 49.0, 'A',
                1500, "https://example.com/downloads/java-basics");

        OrderItem laptopItem = new OrderItem(laptop, 2);
        OrderItem courseItem = new OrderItem(course, 1);
        System.out.println(laptopItem);
        System.out.println(courseItem);

        System.out.println("Product inside the item: " + laptopItem.getProduct().getName());
    }
}
