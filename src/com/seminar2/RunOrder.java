package com.seminar2;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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
    
        out.println();
        out.println("=== Quiet hours (overriding) ===");
        LocalTime lateNight = LocalTime.of(23, 30);
        LocalTime morning = LocalTime.of(9, 15);
        // Same call on two Notification variables - the object decides which version runs.
        out.println("Push at " + lateNight + ": " + push.canSendAt(lateNight));   // MobileNotification's rule
        out.println("Web at " + lateNight + ": " + web.canSendAt(lateNight));     // inherited default
        out.println("Push at " + morning + ": " + push.canSendAt(morning));

        out.println();
        out.println("=== Sending with a time (overloading) ===");
        push.send();                    // send(): no time given, sends right away
        push.send(lateNight);           // send(LocalTime): postponed - quiet hours
        web.send(lateNight);            // send(LocalTime): browser is fine at night
        push.send(morning);             // send(LocalTime): sent

        Notification fraudAlert = new MobileNotification(customer,
                "Suspicious payment of 999.0 on card **** 9012. Was it you?", "iPhone 15");
        fraudAlert.send(lateNight, true);   // send(LocalTime, boolean): urgent - ignores quiet hours

        out.println();
        out.println("=== Order update to every channel (collection) ===");
        String update = "Order " + giftOrder.getOrderId() + " has been shipped";
        // One list for all channels: the element type is the abstract class.
        List<Notification> channels = new ArrayList<>();
        channels.add(new MobileNotification(customer, update, "iPhone 15"));
        channels.add(new WebNotification(customer, update, "Chrome"));
        channels.add(new MobileNotification(customer, update, "iPad Air"));
        channels.add(new WebNotification(customer, update, "Safari"));

        List<Notification> postponed = new ArrayList<>();
        // The loop does not know which subclass each element is - polymorphism.
        for (Notification notification : channels) {
            boolean sent = notification.send(lateNight);
            if (!sent) {
                postponed.add(notification);
            }
        }
        out.println("Sent: " + (channels.size() - postponed.size()) + ", postponed: " + postponed.size());

        LocalTime quietHoursEnd = LocalTime.of(8, 0);
        // deviceName exists only in MobileNotification, so we check the type
        // and get a MobileNotification variable (pattern matching, Java 16+).
        for (Notification notification : postponed) {
            if (notification instanceof MobileNotification mobile) {
                out.println("Will be delivered to " + mobile.getDeviceName() + " at " + quietHoursEnd);
            } else {
                out.println("Will be delivered at " + quietHoursEnd);
            }
        }
        out.println("--- " + quietHoursEnd + ": resending postponed notifications ---");
        for (Notification notification : postponed) {
            notification.send(quietHoursEnd);
        }

        out.println();
        out.println("=== NullPointerException ===");
        // out.println("Dacha city: " + customer.getDeliveryAddress("dacha").getCity());
        // ^ crashes: there is no "dacha" address, getDeliveryAddress() returns null,
        //   and calling getCity() on null throws a NullPointerException.
        // This is a bug to FIX (check for null first), not an exception to catch.
        ShippingAddress dacha = customer.getDeliveryAddress("dacha");
        if (dacha != null) {
            out.println("Dacha city: " + dacha.getCity());
        } else {
            out.println("There is no address called \"dacha\".");
        }

        out.println();
        out.println("=== Catching an exception ===");
        // Quantities often arrive as text (a form field, a file), and not every text is a number.
        List<String> quantityInputs = List.of("2", "two");
        Order textOrder = new Order("ORD-004", customer);
        for (String input : quantityInputs) {
            try {
                int quantity = Integer.parseInt(input);   // throws NumberFormatException for "two"
                textOrder.addItem(jacket, quantity);
                out.println("Added " + quantity + " x " + jacket.getName());
            } catch (NumberFormatException e) {
                out.println("\"" + input + "\" is not a number - item was not added.");
                out.println("Exception message: " + e.getMessage());
            }
        }
        textOrder.printSummary();
    }
}
