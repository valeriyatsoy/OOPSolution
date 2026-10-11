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
        out.println("=== Notifications ===");
        String text = "Order " + order.getOrderId() + " is waiting for payment: " + order.getTotal();
        // The variable type is the abstract class, the object is a concrete subclass.
        Notification push = new MobileNotification(customer, text, "iPhone 15");
        Notification web = new WebNotification(customer, text, "Chrome");
        push.send();
        web.send();
        // Notification notification = new Notification(customer, text);   // error: Notification is abstract

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

        out.println();
        out.println("=== Payment options ===");
        customer.addBankCard("8600 1234 5678 9012", 1500);
        customer.getBonusBalance().addPoints(50);
        GiftCard giftCard = new GiftCard("Gift Card 100", 100.0, "GIFT-2026");

        // A GiftCard is a Product, so it can be bought like any other product
        Order giftCardOrder = new Order("ORD-003", customer);
        giftCardOrder.addItem(giftCard, 1);
        giftCardOrder.printSummary();

        // The variable type is the interface: it can hold ANY object that implements Payable
        Payable byCard = customer.getBankCard();
        Payable byBonus = customer.getBonusBalance();
        Payable byGiftCard = giftCard;

        byCard.processPayment(giftCardOrder.getTotal());
        byBonus.processPayment(30);
        byBonus.processPayment(500);                                   // declined
        byGiftCard.processPayment(45.5);

        out.println();
        out.println("=== Cashback ===");
        customer.pay(byCard, 250);         // BankCard is CashbackEligible: 1% cashback
        customer.pay(byGiftCard, 20);      // GiftCard is not: no cashback
        customer.pay(byBonus, 12.5);       // pays with points, including the cashback just earned
    }
}
