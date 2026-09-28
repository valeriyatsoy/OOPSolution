# Seminar 4, Exercise 2 -- Composition: the OrderItem class

**Objective:** build a class that is made of another object (has-a),
instead of extending it (is-a).

**What changed:**
- Added `OrderItem` with two private fields: `Product product` and
  `int quantity`. It does **not** extend `Product` -- an order line is not a
  kind of product, it refers to one.
- Constructor `OrderItem(Product product, int quantity)` assigns both fields.
- Getters `getProduct()` and `getQuantity()`; no setters -- an order line is
  fixed once it has been created.
- `getUnitPrice()` delegates to `product.getPriceWithTax()`.
- `toString()` prints e.g. `2 x Laptop @ 1007.99 = 2015.98`; the line total
  is unit price x quantity, rounded to two decimals.
- `RunOrder` creates the customer (with a `ShippingAddress`), a laptop and a
  course, wraps each product in an `OrderItem` and prints them.

**Run it:** run `RunOrder.main()` -- `2 x Laptop @ 1007.99 = 2015.98` and
`1 x Java Basics Video Course @ 54.88 = 54.88`.

**Next:** `seminarFour_ex3` -- the `Order` class with a `List<OrderItem>`.
