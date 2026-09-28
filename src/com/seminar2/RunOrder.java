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
        System.out.println("=== Products ===");
        PhysicalProduct laptop = new PhysicalProduct("Laptop", 899.99, 10, true, 'A', 2.1, true);
        DigitalProduct course = new DigitalProduct("Java Basics Video Course", 49.0, 'A',
                1500, "https://example.com/downloads/java-basics");
        System.out.println(laptop.getName() + ", " + course.getName());

        System.out.println();
        System.out.println("=== Order ===");
        Order order = new Order("ORD-001", customer);
        order.addItem(laptop, 2);
        order.addItem(course, 1);
        order.addItem(course, 0);      // rejected
        order.printSummary();
    }
}
