package com.seminar2.command;

import com.seminar2.order.Order;
import com.seminar2.product.Product;

// Concrete command: add a product to the order.
public class AddItemCommand implements OrderCommand {

    private Order order;          // the receiver
    private Product product;
    private int quantity;

    public AddItemCommand(Order order, Product product, int quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public void execute() {
        order.addItem(product, quantity);
    }

    @Override
    public String getDescription() {
        return "add " + quantity + " x " + product.getName();
    }
}
