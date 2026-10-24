package com.seminar2.order;

// Singleton: the whole shop must have exactly ONE order number generator.
// With two generators, two orders could get the same number.
public class OrderNumberGenerator {

    // 1. The only instance is kept in a private static field.
    private static OrderNumberGenerator instance;

    // ORD-001 ... ORD-005 are already used in RunOrder, so we continue from 5.
    private int lastNumber = 5;

    // 2. The constructor is private: nobody outside can write new OrderNumberGenerator().
    private OrderNumberGenerator() {
        System.out.println("(OrderNumberGenerator created)");
    }

    // 3. The only way to get the object. It is created the first time it is needed
    //    (lazy initialization); after that the same object is returned every time.
    public static OrderNumberGenerator getInstance() {
        if (instance == null) {
            instance = new OrderNumberGenerator();
        }
        return instance;
    }

    public String nextOrderId() {
        lastNumber++;
        return String.format("ORD-%03d", lastNumber);   // 6 -> "ORD-006"
    }
}
