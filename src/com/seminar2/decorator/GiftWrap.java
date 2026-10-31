package com.seminar2.decorator;

// Decorator: a CONCRETE DECORATOR - the order is gift-wrapped for 15.
public class GiftWrap extends OrderDecorator {

    private static final double PRICE = 15.0;

    public GiftWrap(OrderCost wrapped) {
        super(wrapped);
    }

    // First ask the wrapped object, then add our own part on top.
    @Override
    public String getDescription() {
        return wrapped.getDescription() + " + gift wrap (" + PRICE + ")";
    }

    @Override
    public double getTotal() {
        return roundToTwoDecimals(wrapped.getTotal() + PRICE);
    }
}
