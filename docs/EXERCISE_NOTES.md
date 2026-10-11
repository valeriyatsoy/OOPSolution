# Seminar 6, Exercise 1 -- Abstract class Notification

**Objective:** write an abstract class with an abstract method and two
concrete subclasses that implement it.

**What changed:**
- New abstract class `Notification`: private fields `customer` and
  `message`, a constructor, getters, and the abstract method
  `public abstract void send();` -- no body, every subclass decides how the
  message is sent.
- New class `MobileNotification extends Notification` (extra field
  `deviceName`): `send()` prints a push message to the customer's phone.
- New class `WebNotification extends Notification` (extra field `browser`):
  `send()` prints a browser notification.
- `RunOrder` creates both notifications right after `order.printSummary()`.
  The variables have the type `Notification`; the objects are the concrete
  subclasses. A commented-out line shows that `new Notification(...)` does
  not compile.

**Run it:** run `RunOrder.main()` -- after the summary of ORD-001:

```
=== Notifications ===
Push notification to Aziz Karimov's iPhone 15: Order ORD-001 is waiting for payment: 2083.01
Browser notification in Chrome for Aziz Karimov: Order ORD-001 is waiting for payment: 2083.01
```

**Next:** `seminarSix_ex2` makes `Product` abstract.
