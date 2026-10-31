package com.seminar2.decorator;

import java.time.LocalDate;

// Decorator: a CONCRETE DECORATOR with its own state - the customer picks the
// delivery day and time slot, for 20. Like the flavor in SyrupDecorator, the
// date and slot show that a decorator can be customised through its constructor.
public class ScheduledDelivery extends OrderDecorator {

    private static final double PRICE = 20.0;

    private LocalDate date;
    private String timeSlot;

    public ScheduledDelivery(OrderCost wrapped, LocalDate date, String timeSlot) {
        super(wrapped);
        this.date = date;
        this.timeSlot = timeSlot;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " + scheduled delivery on " + date
                + ", " + timeSlot + " (" + PRICE + ")";
    }

    @Override
    public double getTotal() {
        return roundToTwoDecimals(wrapped.getTotal() + PRICE);
    }
}
