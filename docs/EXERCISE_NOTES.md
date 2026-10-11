# Seminar 6, Exercise 4 (optional) -- Interface CashbackEligible

**Objective:** let one class implement two interfaces, and check at run time
whether an object implements an interface.

**What changed:**
- New interface `CashbackEligible` with one method:
  `double calculateCashback(double amount);`
- `BankCard implements Payable, CashbackEligible` -- `calculateCashback()`
  returns 1% of the amount, rounded to two decimals. `BonusBalance` and
  `GiftCard` do not implement it: paying with points or a gift card gives no
  cashback.
- `Customer` -- new method `boolean pay(Payable paymentMethod, double amount)`.
  It calls `processPayment()`, and only if the payment succeeded **and**
  `paymentMethod instanceof CashbackEligible eligible`, it adds the cashback
  to the customer's `BonusBalance`. (`instanceof` with a variable name --
  pattern matching -- needs Java 16+; the project uses JDK 18.)
- `RunOrder` -- new section "Cashback": pays 250 by card (2.5 cashback),
  20 with the gift card (no cashback), and 12.5 with bonus points, which
  include the cashback just earned.

**Run it:** run `RunOrder.main()` -- the end of the output is

```
=== Cashback ===
Paid 250.0 by bank card **** 9012. Money left on the card: 1150.0
Cashback 2.5 added. Bonus points: 22.5
Paid 20.0 with gift card GIFT-2026. Left on the card: 34.5
Paid 12.5 with bonus points. Points left: 10.0
```

**This is the final branch** -- `seminarSix_ex1` through `seminarSix_ex4`
together walk through the whole of Seminar 6 (Abstraction).
