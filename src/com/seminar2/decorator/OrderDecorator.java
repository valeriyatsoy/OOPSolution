package com.seminar2.decorator;

// Decorator: the BASE DECORATOR (like CoffeeDecorator).
// It IS an OrderCost (implements the interface) and HAS an OrderCost (the
// field it wraps). By default it simply passes every call on to the wrapped
// object. It is abstract because a decorator that adds nothing is not useful.
public abstract class OrderDecorator implements OrderCost {

    // protected: the concrete decorators (subclasses) use it directly.
    // The wrapped object can be a plain Order or another decorator.
    protected OrderCost wrapped;

    public OrderDecorator(OrderCost wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription();
    }

    @Override
    public double getTotal() {
        return wrapped.getTotal();
    }

    // protected: a helper for the decorator family only (like Product.roundToTwoDecimals)
    protected double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
