# Seminar 10, Exercise 2 -- Singleton: one order number generator

**Objective:** make sure there is exactly one object of a class in the whole
program, and that every part of the program gets that same object.

**New feature:** every new order gets a unique number automatically --
`ORD-006`, `ORD-007`, ... All numbers come from one shared generator, so two
orders can never get the same number.

**What changed:**
- New class `OrderNumberGenerator` (package `order`) with the three parts of a Singleton:
  - `private static OrderNumberGenerator instance` -- the only object;
  - a `private` constructor -- `new OrderNumberGenerator()` does not compile
    outside the class;
  - `public static getInstance()` -- creates the object the first time it
    is called (lazy initialization) and returns the same object after that.
- `nextOrderId()` starts after the five orders that `RunOrder` already
  creates (ORD-001 ... ORD-005): `ORD-006`, `ORD-007`, ...
  (`String.format("ORD-%03d", ...)`).
- `RunOrder` -- new section "Singleton: order numbers": two variables get the
  generator through `getInstance()`, `generator1 == generator2` is `true`, and
  two new orders get their numbers from it.

**Try it:** make the constructor `public` and give each order its own
`new OrderNumberGenerator()` -- both orders become `ORD-006`. That is the bug
the Singleton prevents. (Change it back afterwards.)

**Run it:** run `RunOrder.main()` -- the end of the output is

```
=== Singleton: order numbers ===
(OrderNumberGenerator created)
Same generator? true
New orders: ORD-006, ORD-007
```

**Next:** `seminarTen_ex3` -- Factory Method: notification channels.
