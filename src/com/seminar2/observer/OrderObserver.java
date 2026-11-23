package com.seminar2.observer;

import com.seminar2.order.Order;
import com.seminar2.order.OrderStatus;

// Observer: anything that wants to know when an order's status changes.
// Order does not know which classes implement it - it only knows this interface.
public interface OrderObserver {
    void onStatusChanged(Order order, OrderStatus newStatus);
}
