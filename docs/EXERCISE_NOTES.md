# Seminar 7, Exercise 4 (optional) -- instanceof for a subclass-only field

**Objective:** use `instanceof` when you really need something that exists
only in one subclass -- and see why overriding is the better tool for
everything else.

**Business rule:** for each postponed notification, tell the customer which
device it will be delivered to and when.

**What changed:**
- `RunOrder` -- in the "Order update to every channel" section, a loop over
  `postponed`: `if (notification instanceof MobileNotification mobile)` prints
  `mobile.getDeviceName()`. `getDeviceName()` does not exist in
  `Notification`, so it cannot be called through a `Notification` variable
  without the check. (`instanceof` with a variable name -- pattern matching --
  needs Java 16+; the project uses JDK 18.)
- `instanceof` is an operator, not a method.

**Discussion:** why not check the quiet hours in the loop with `instanceof`
(`if (n instanceof MobileNotification && ...)`) instead of overriding
`canSendAt()`? Every new kind of notification (SMS, email, Telegram) would mean
editing every such loop. With overriding, the new class brings its own rule and
the loop stays the same. Use `instanceof` only for things that really belong
to one subclass.

**Run it:** run `RunOrder.main()` -- the end of the output is

```
Sent: 2, postponed: 2
Will be delivered to iPhone 15 at 08:00
Will be delivered to iPad Air at 08:00
--- 08:00: resending postponed notifications ---
Push notification to Aziz Karimov's iPhone 15: Order ORD-002 has been shipped
Push notification to Aziz Karimov's iPad Air: Order ORD-002 has been shipped
```

**This is the final branch** -- `seminarSeven_ex1` through `seminarSeven_ex4`
together walk through the whole of Seminar 7 (Overriding and Overloading).
