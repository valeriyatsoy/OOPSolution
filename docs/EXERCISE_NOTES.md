# Seminar 8, Exercise 4 (optional) -- Throw an exception on purpose

**Objective:** replace a silent failure (print + return) with `throw`, and use
`try` / `catch` / `finally`.

**What changed:**
- `Order.addItem()` -- for `quantity <= 0` it now throws
  `IllegalArgumentException("Quantity must be positive, but was " + quantity)`
  instead of printing a message and returning. The caller cannot miss it.
- `RunOrder` -- `order.addItem(course, 0)` is wrapped in `try` / `catch`;
  `order.printSummary()` moved into `finally`, so it runs whether the item
  was added or not.

**Discussion:** `NumberFormatException` (Exercise 3) is a subclass of
`IllegalArgumentException`, so `catch (IllegalArgumentException e)` would
catch it too.

**Run it:** run `RunOrder.main()` -- the "Order" section prints

```
=== Order ===
Item was not added: Quantity must be positive, but was 0
Order ORD-001 for Aziz Karimov
  2 x Laptop @ 1007.99 = 2015.98
  1 x Java Basics Video Course @ 54.88 = 54.88
...
```

**Next:** `seminarEight_ex5` (optional) -- our own checked exception.
