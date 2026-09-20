package com.seminar2;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== PhysicalProduct ===");
        PhysicalProduct laptop = new PhysicalProduct("Laptop", 899.99, 10, true, 'A', 2.1, true);

        System.out.println("Name: " + laptop.getName());
        System.out.println("Price with tax: " + laptop.getPriceWithTax());
        System.out.println("Heavy: " + laptop.isHeavy());
        System.out.println("Packaging: " + laptop.getPackagingNote());
        laptop.reduceStock(3);
        System.out.println("Quantity after selling 3: " + laptop.getQuantity());
        laptop.deliver();
        System.out.println("Delivery cost: " + laptop.calculateDeliveryCost());

        System.out.println();
        System.out.println("=== DigitalProduct ===");
        DigitalProduct course = new DigitalProduct("Java Basics Video Course", 49.0, 'A',
                1500, "https://example.com/downloads/java-basics");

        System.out.println("Name: " + course.getName());
        System.out.println("Price with tax: " + course.getPriceWithTax());
        course.download();
        System.out.println("Estimated download time at 50 Mbps: " + course.estimateDownloadSeconds(50) + " seconds");
        course.deliver();
        System.out.println("Delivery cost: " + course.calculateDeliveryCost());

        System.out.println();
        System.out.println("=== Customer ===");
        Address address = new Address("12 Amir Temur St", "Tashkent", "100000");
        Customer customer = new Customer("Aziz Karimov", 120, 45.567, address);
        System.out.println("Name: " + customer.getName());
        System.out.println("Loyalty points: " + customer.getLoyaltyPoints());
        System.out.println("Account balance: " + customer.getAccountBalance());
        System.out.println("City: " + customer.getAddress().getCity());

        customer.setLoyaltyPoints(150);
        System.out.println("Updated loyalty points: " + customer.getLoyaltyPoints());
    }
}
