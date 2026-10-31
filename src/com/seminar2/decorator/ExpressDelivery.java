package com.seminar2.decorator;

// Decorator: a CONCRETE DECORATOR - next-day delivery for 30.
public class ExpressDelivery extends OrderDecorator {

    private static final double PRICE = 30.0;

    public ExpressDelivery(OrderCost wrapped) {
        super(wrapped);
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " + express delivery (" + PRICE + ")";
    }

    @Override
    public double getTotal() {
        return roundToTwoDecimals(wrapped.getTotal() + PRICE);
    }
}
