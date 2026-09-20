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
        System.out.println("=== EBook ===");
        EBook book = new EBook("Clean Code", 25.0, 'A', 4.5, "https://example.com/downloads/clean-code",
                "Robert C. Martin", 464, "PDF");
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Price with tax: " + book.getPriceWithTax());
        book.download();
        book.deliver();
        System.out.println("Delivery cost: " + book.calculateDeliveryCost());

        System.out.println();
        System.out.println("=== SoftwareLicense ===");
        SoftwareLicense editor = new SoftwareLicense("PhotoEditor Pro", 59.99, 'A', 850,
                "https://example.com/downloads/photoeditor", "ABCD-1234-EFGH-5678", 12, 3);
        System.out.println("License key: " + editor.getLicenseKey());
        System.out.println("Price with tax: " + editor.getPriceWithTax());
        editor.download();
        editor.deliver();
        System.out.println("Delivery cost: " + editor.calculateDeliveryCost());

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
