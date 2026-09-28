# Seminar 4, Exercise 3 -- The Order class: a Customer and a List<OrderItem>

**Objective:** combine several objects into one (composition and
aggregation) and use a `List` to hold a variable number of parts.

**What changed:**
- Added `Order` with fields `String orderId`, `Customer customer` and
  `List<OrderItem> items = new ArrayList<>()`.
  - `customer` is **aggregation**: the customer existed before the order and
    lives on after it.
  - `items` is **composition**: the order creates its `OrderItem` objects
    itself (`addItem`) and they make no sense without it.
- `addItem(Product, int)`: rejects a quantity <= 0; otherwise the order
  creates the item itself: `items.add(new OrderItem(...))`.
- `getItemsTotal()`, `getDeliveryCost()` (one fee per line, each product type
  uses its own `calculateDeliveryCost()` from Seminar 3) and `getTotal()`.
- `printSummary()` prints the lines, the totals and the customer's shipping
  address.
- `RunOrder`: the separate `OrderItem` demo from Ex2 is replaced by an
  `Order` that creates the items itself.

**Run it:** run `RunOrder.main()` -- with laptop x2 and course x1 the total
is 2083.01 (items 2070.86 + delivery 12.15); adding the course with quantity
0 is rejected.

**Next:** `seminarFour_ex4` -- placing the order; `import static` in `RunOrder`.
