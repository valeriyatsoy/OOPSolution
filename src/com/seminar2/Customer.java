package com.seminar2;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Customer {

    private String name;
    private int loyaltyPoints;
    private double accountBalance;
    private ShippingAddress shippingAddress;
    // A Map stores label -> address pairs, e.g. "home" -> ..., "office" -> ...
    // Each label (key) is unique. LinkedHashMap also remembers the order of adding.
    private Map<String, ShippingAddress> deliveryAddresses = new LinkedHashMap<>();
    // Composition: the customer creates its own payment methods and owns them.
    private BonusBalance bonusBalance = new BonusBalance(0);
    private BankCard bankCard;

    public Customer(String name, int loyaltyPoints, double accountBalance) {
        this.name = name;
        this.loyaltyPoints = loyaltyPoints;
        this.accountBalance = accountBalance;
    }

    public Customer(String name, int loyaltyPoints, double accountBalance, ShippingAddress shippingAddress) {
        this(name, loyaltyPoints, accountBalance);
        this.shippingAddress = shippingAddress;
    }

    public String getName() {
        return name == null ? "Unknown" : name.trim();
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public double getAccountBalance() {
        return Math.round(accountBalance * 100.0) / 100.0;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public BonusBalance getBonusBalance() {
        return bonusBalance;
    }

    public BankCard getBankCard() {
        return bankCard;
    }

    // The customer creates the card itself (composition); the holder is the customer.
    public void addBankCard(String cardNumber, double balance) {
        bankCard = new BankCard(cardNumber, getName(), balance);
    }

    // Pays with any payment method. Only CashbackEligible methods earn cashback,
    // and the cashback goes to the customer's bonus balance.
    public boolean pay(Payable paymentMethod, double amount) {
        boolean paid = paymentMethod.processPayment(amount);
        if (paid && paymentMethod instanceof CashbackEligible eligible) {
            double cashback = eligible.calculateCashback(amount);
            bonusBalance.addPoints(cashback);
            System.out.println("Cashback " + cashback + " added. Bonus points: " + bonusBalance.getPoints());
        }
        return paid;
    }


    public void addDeliveryAddress(String label, ShippingAddress address) {
        if (deliveryAddresses.containsKey(label)) {
            System.out.println("Address \"" + label + "\" was replaced.");
        }
        deliveryAddresses.put(label, address);    // put() with an existing key replaces the old value
    }

    public boolean removeDeliveryAddress(String label) {
        if (deliveryAddresses.remove(label) == null) {
            System.out.println("There is no address called \"" + label + "\".");
            return false;
        }
        return true;
    }

    public ShippingAddress getDeliveryAddress(String label) {
        return deliveryAddresses.get(label);      // null if there is no such label
    }

    // Chooses one of the saved addresses as the shipping address for the next orders.
    public boolean useDeliveryAddress(String label) {
        ShippingAddress address = deliveryAddresses.get(label);
        if (address == null) {
            System.out.println("There is no address called \"" + label + "\" - shipping address was not changed.");
            return false;
        }
        shippingAddress = address;
        System.out.println("Orders will now be shipped to \"" + label + "\".");
        return true;
    }

    public Set<String> getAddressLabels() {
        return new LinkedHashSet<>(deliveryAddresses.keySet());
    }

    public void printDeliveryAddresses() {
        System.out.println(getName() + "'s delivery addresses (" + deliveryAddresses.size() + "):");
        for (Map.Entry<String, ShippingAddress> entry : deliveryAddresses.entrySet()) {
            String selected = entry.getValue() == shippingAddress ? "  <- selected" : "";
            System.out.println("  " + entry.getKey() + ": " + entry.getValue() + selected);
        }
    }
}
