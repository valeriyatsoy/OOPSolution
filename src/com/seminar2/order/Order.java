package com.seminar2.order;

import com.seminar2.customer.Customer;
import com.seminar2.exception.InsufficientBalanceException;
import com.seminar2.product.Product;

import com.seminar2.decorator.OrderCost;
import com.seminar2.observer.OrderObservable;
import com.seminar2.observer.OrderObserver;

import java.util.ArrayList;
import java.util.List;

// Decorator (Seminar 11): Order is the CONCRETE COMPONENT - the plain object that
// the extras (GiftWrap, ExpressDelivery, ScheduledDelivery) wrap.
// Order itself knows nothing about them.
// Observer (Seminar 12): Order is also the SUBJECT - it notifies its observers
// every time its status changes.
public class Order implements OrderCost, OrderObservable {

    private String orderId;
    // Aggregation: the customer exists before and after the order.
    private Customer customer;
    // Composition: the order creates its own OrderItem objects and owns them.
    private List<OrderItem> items = new ArrayList<>();
    private OrderStatus status = OrderStatus.NEW;
    // Observer: the subscribers. The element type is the interface.
    private List<OrderObserver> observers = new ArrayList<>();

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public OrderStatus getStatus() {
        return status;
    }

    @Override
    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.onStatusChanged(this, status);
        }
    }

    // Every status change is announced to all observers.
    public void setStatus(OrderStatus newStatus) {
        status = newStatus;
        notifyObservers();
    }

    public void addItem(Product product, int quantity) {
        if (quantity <= 0) {
            // Instead of printing a message and quietly returning, we throw:
            // the caller cannot miss the problem and decides what to do with it.
            throw new IllegalArgumentException("Quantity must be positive, but was " + quantity);
        }
        // Composition: the order creates its own OrderItem objects.
        items.add(new OrderItem(product, quantity));
    }

    public double getItemsTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getUnitPrice() * item.getQuantity();
        }
        return Math.round(total * 100.0) / 100.0;
    }

    // One delivery fee per order line; every product type calculates its own fee (Seminar 3).
    public double getDeliveryCost() {
        double cost = 0;
        for (OrderItem item : items) {
            cost += item.getProduct().calculateDeliveryCost();
        }
        return Math.round(cost * 100.0) / 100.0;
    }

    // Required by OrderCost: the plain order describes itself by its id.
    @Override
    public String getDescription() {
        return "Order " + orderId;
    }

    @Override
    public double getTotal() {
        return Math.round((getItemsTotal() + getDeliveryCost()) * 100.0) / 100.0;
    }

    // Business logic: placing the order charges the customer.
    // If the balance is too low, nothing is charged and the caller gets an exception.
    public void place() throws InsufficientBalanceException {
        double total = getTotal();
        if (customer.getAccountBalance() < total) {
            throw new InsufficientBalanceException(total, customer.getAccountBalance());
        }
        customer.setAccountBalance(customer.getAccountBalance() - total);
        System.out.println("Order " + orderId + " placed. " + total + " was charged.");
        setStatus(OrderStatus.PLACED);      // observers are notified
    }

    public void printSummary() {
        System.out.println("Order " + orderId + " for " + customer.getName());
        for (OrderItem item : items) {
            System.out.println("  " + item);
        }
        System.out.println("Items total: " + getItemsTotal());
        System.out.println("Delivery: " + getDeliveryCost());
        System.out.println("Total to pay: " + getTotal());
        System.out.println("Ship to: " + customer.getShippingAddress());
    }
}
