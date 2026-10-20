# Seminar 8, Exercise 2 -- Find and fix a NullPointerException

**Objective:** read a stack trace, find the cause with the debugger, and fix
the bug instead of catching the exception.

**What changed:**
- `RunOrder` -- new section "NullPointerException" at the end of `main()`.
  The original line (kept as a comment)
  `customer.getDeliveryAddress("dacha").getCity()` crashes: there is no
  "dacha" label, `getDeliveryAddress()` returns `null`, and calling
  `getCity()` on `null` throws a `NullPointerException`.
- Fix: the result is stored in a `ShippingAddress` variable and `getCity()`
  is called only if it is not `null`.

**Discussion:** a `NullPointerException` is almost always a bug. Catching it
would hide the bug; checking for `null` (or not returning `null`) fixes it.

**Run it:** run `RunOrder.main()` -- the end of the output is

```
=== NullPointerException ===
There is no address called "dacha".
```

**Next:** `seminarEight_ex3` -- catching an exception thrown by Java.
