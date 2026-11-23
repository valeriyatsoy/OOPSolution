package com.seminar2.command;

import com.seminar2.order.Order;
import com.seminar2.product.Product;

// Concrete command: remove a product from the order.
public class RemoveItemCommand implements OrderCommand {

    private Order order;          // the receiver
    private Product product;

    public RemoveItemCommand(Order order, Product product) {
        this.order = order;
        this.product = product;
    }

    @Override
    public void execute() {
        order.removeItem(product);
    }

    @Override
    public String getDescription() {
        return "remove " + product.getName();
    }
}
