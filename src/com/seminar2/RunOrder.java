package com.seminar2;

import static java.lang.System.out;

// A second class with a main method (a second entry point of the program):
// Main keeps the inheritance demos from Seminar 3, RunOrder is where we
// practise composition -- building and placing an order.
public class RunOrder {
    public static void main(String[] args) {
        out.println("=== Customer ===");
        ShippingAddress home = new ShippingAddress("12 Amir Temur St", "Tashkent", "100000");
        Customer customer = new Customer("Aziz Karimov", 120, 45.567, home);

        out.println("Name: " + customer.getName());
        out.println("Ships to: " + customer.getShippingAddress());

        out.println();
        out.println("=== Products ===");
        PhysicalProduct laptop = new PhysicalProduct("Laptop", 899.99, 10, true, 'A', 2.1, true);
        DigitalProduct course = new DigitalProduct("Java Basics Video Course", 49.0, 'A',
                1500, "https://example.com/downloads/java-basics");
        out.println(laptop.getName() + ", " + course.getName());

        out.println();
        out.println("=== Order ===");
        Order order = new Order("ORD-001", customer);
        order.addItem(laptop, 2);
        order.addItem(course, 1);
        order.addItem(course, 0);      // rejected
        order.printSummary();

        out.println();
        out.println("=== Placing the order ===");
        customer.setAccountBalance(customer.getAccountBalance() + 2500); // the customer tops up
        out.println("Balance before paying: " + customer.getAccountBalance());
        order.place();
        out.println("Balance after paying: " + customer.getAccountBalance());

        out.println();
        out.println("=== Delivery addresses ===");
        Clothing jacket = new Clothing("Winter Jacket", 79.5, 40, 'B', 1.2, "M", "Polyester");
        customer.addDeliveryAddress("home", home);
        customer.addDeliveryAddress("office", new ShippingAddress("5 Mustaqillik Ave", "Tashkent", "100017"));
        customer.addDeliveryAddress("parents", new ShippingAddress("24 Registan St", "Samarkand", "140100"));
        customer.addDeliveryAddress("office",                          // same key: the old office address is replaced
                new ShippingAddress("8 Shota Rustaveli St", "Tashkent", "100070"));
        customer.printDeliveryAddresses();

        customer.useDeliveryAddress("dacha");                            // no such label
        customer.useDeliveryAddress("office");
        out.println("Parents' city: " + customer.getDeliveryAddress("parents").getCity());

        Order giftOrder = new Order("ORD-002", customer);
        giftOrder.addItem(jacket, 1);
        giftOrder.place();
        giftOrder.printSummary();                                        // ships to the office

        customer.removeDeliveryAddress("parents");
        customer.removeDeliveryAddress("parents");                       // already removed
        out.println("Saved labels: " + customer.getAddressLabels());
        customer.printDeliveryAddresses();
    }
}
