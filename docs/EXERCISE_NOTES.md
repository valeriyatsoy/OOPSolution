# Seminar 11, Exercise 1 -- Decorator: order extras

**Objective:** let the customer add optional extras to an order (gift wrap,
express delivery, scheduled delivery) in any combination, without writing a
class for every combination (`GiftWrappedExpressOrder`, ...) and without
putting the extra fees inside `Order`.

**Roles (same as ICoffee / CoffeeDecorator in the handout):**
- Component -- interface `OrderCost` (like `ICoffee`): `getDescription()`, `getTotal()`
- Concrete component -- the existing `Order` (like `SimpleCoffee`)
- Base decorator -- abstract `OrderDecorator` (like `CoffeeDecorator`)
- Concrete decorators -- `GiftWrap` (+15), `ExpressDelivery` (+30),
  `ScheduledDelivery` (+20, with a date and a time slot -- like the flavor
  in `SyrupDecorator`)

**What changed:**
- New package `decorator` with `OrderCost`, `OrderDecorator`, `GiftWrap`,
  `ExpressDelivery` and `ScheduledDelivery`.
- `OrderDecorator` IS an `OrderCost` (implements it) and HAS an `OrderCost`
  (the protected field `wrapped`). By default it passes both calls on to the
  wrapped object; each concrete decorator first asks the wrapped object, then
  adds its own price and label on top.
- `Order` now `implements OrderCost`: it already had `getTotal()`, so only
  `getDescription()` ("Order ORD-008") was added. Nothing else in `Order`
  changed, and `Order` knows nothing about the decorators.
- `RunOrder` -- new section "Decorator: order extras": one order is wrapped
  in different extras while the program runs, and the customer pays the
  decorated total with `customer.pay(customer.getBankCard(), ...)`.

**Discussion:**
- Why does `birthdayOrder.place()` not charge the extras? `Order` only knows
  its own total -- the extras exist only in the wrappers. That is why the
  decorated total is paid through `customer.pay(...)`.
- Adding a new extra (for example insurance) = one new class extending
  `OrderDecorator`; no existing class changes (Open/Closed principle).
- `new ExpressDelivery(new ScheduledDelivery(...))` compiles. Does it make
  sense? The pattern allows any combination -- checking which ones are
  sensible is a business rule, not part of the Decorator.

**Run it:** run `RunOrder.main()` -- the end of the output is

```
=== Decorator: order extras ===
Order ORD-008: 92.04
Order ORD-008 + gift wrap (15.0): 107.04
Order ORD-008 + gift wrap (15.0) + express delivery (30.0): 137.04
Order ORD-008 + gift wrap (15.0) + scheduled delivery on 2026-11-14, 10:00-12:00 (20.0): 127.04
Paid 127.04 by bank card **** 9012. Money left on the card: 1022.96
Cashback 1.27 added. Bonus points: 11.27
```
