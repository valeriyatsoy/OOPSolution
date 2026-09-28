package com.seminar2;

// Composition: an OrderItem HAS-A Product and a quantity.
// It is not a kind of product (no "extends"), it only refers to one.
public class OrderItem {

    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    // Delegation: OrderItem does not know how tax is calculated, it asks its Product.
    public double getUnitPrice() {
        return product.getPriceWithTax();
    }

    @Override
    public String toString() {
        double lineTotal = Math.round(getUnitPrice() * quantity * 100.0) / 100.0;
        return quantity + " x " + product.getName() + " @ " + getUnitPrice() + " = " + lineTotal;
    }
}
