# Seminar 8, Exercise 3 -- Catch an exception thrown by Java

**Objective:** catch an exception that a library method throws for bad input,
and let the program continue.

**Business rule:** quantities arrive as text (a form field, a file). Text that
is not a number must not stop the program -- the item is simply not added.

**What changed:**
- `RunOrder` -- new section "Catching an exception": a `List<String>` of
  inputs `"2"` and `"two"`, and order ORD-004. In the loop,
  `Integer.parseInt(input)` throws `NumberFormatException` for `"two"`; the
  `try`/`catch` prints a message and `e.getMessage()` and the loop goes on.

**Run it:** run `RunOrder.main()` -- the end of the output is

```
=== Catching an exception ===
Added 2 x Winter Jacket
"two" is not a number - item was not added.
Exception message: For input string: "two"
Order ORD-004 for Aziz Karimov
  2 x Winter Jacket @ 89.04 = 178.08
Items total: 178.08
Delivery: 3.0
Total to pay: 181.08
Ship to: 8 Shota Rustaveli St, Tashkent 100070
```

**Next:** `seminarEight_ex4` (optional) -- throwing an exception on purpose.
