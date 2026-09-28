# Seminar 4, Exercise 4 -- Placing the order (business logic); import static

**Objective:** write business logic that works across several connected
objects (`Order` -> `OrderItem` -> `Product`, `Order` -> `Customer`), and
shorten console output with a static import.

**What changed:**
- `Order.place()` charges the customer: it subtracts `getTotal()` from the
  balance with `setAccountBalance(...)` and prints how much was charged. It works only through `Customer`'s public
  methods.
- `RunOrder` now starts with `import static java.lang.System.out;` and every
  `System.out.println(...)` became `out.println(...)`. The static import only
  affects `RunOrder`; `Order` keeps `System.out.println`.
- `RunOrder` tops up the customer's balance and places ORD-001.

**Run it:** run `RunOrder.main()` -- "Order ORD-001 placed. 2083.01 was
charged.", balance 2545.57 -> 462.56.

**Next:** `seminarFour_ex5` (optional) -- several delivery addresses with a `Map`.
