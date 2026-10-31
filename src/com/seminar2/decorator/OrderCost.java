package com.seminar2.decorator;

// Decorator: the COMPONENT (like ICoffee in the coffee example).
// Everything that has a description and a total to pay: a plain Order, or
// an Order wrapped in one or more extras (GiftWrap, ExpressDelivery,
// ScheduledDelivery). The code that pays only ever talks to OrderCost, so it
// does not care how many extras were added.
public interface OrderCost {
    String getDescription();

    double getTotal();
}
