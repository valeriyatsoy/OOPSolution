package com.seminar2.order;

// An enum is a type with a fixed list of values.
// A typo like OrderStatus.SHIPED does not compile - a String "SHIPED" would.
public enum OrderStatus {
    NEW,
    PLACED,
    SHIPPED,
    DELIVERED
}
