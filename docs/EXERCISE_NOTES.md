# Seminar 8, Exercise 5 (optional) -- Create your own exception

**Objective:** create a custom *checked* exception and see how the compiler
forces every caller to handle it.

**Business rule:** an order can be placed only if the customer has enough money
on the account; otherwise nothing is charged.

**What changed:**
- New class `InsufficientBalanceException extends Exception` with a
  constructor `(double needed, double available)` that builds the message.
- `Order.place()` -- declared `throws InsufficientBalanceException`; throws it
  when the balance is lower than the total, before charging.
- `RunOrder` -- both existing `place()` calls are wrapped in `try`/`catch`
  (they no longer compile without it), and a new section "Custom checked
  exception" tries to place ORD-005 (1 laptop, 1020.14) with only 370.52 on
  the account.

**Discussion:** why checked here and unchecked in Exercise 4? Not enough money
is a normal business situation every caller must plan for; a zero quantity is
a programming mistake.

**Run it:** run `RunOrder.main()` -- the end of the output is

```
=== Custom checked exception ===
Balance: 370.52, order total: 1020.14
Order was not placed: Not enough money on the account: needed 1020.14, available 370.52
Balance after the attempt: 370.52
```

**This is the final branch** -- `seminarEight_ex2` through `seminarEight_ex5`
together walk through the code of Seminar 8 (Exceptions).
