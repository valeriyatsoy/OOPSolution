# Seminar 7, Exercise 3 -- A collection of notifications

**Objective:** store objects of different subclasses in one
`List<Notification>` and process them in one loop, without knowing which
subclass each element is.

**Business rule:** when an order is shipped, the customer gets the update on
every channel they use. Push messages that fall into quiet hours are kept and
resent when quiet hours end (08:00).

**What changed:**
- `RunOrder` -- new section "Order update to every channel (collection)":
  - `List<Notification> channels` with two `MobileNotification` and two
    `WebNotification` objects for the same customer and the same message.
  - A for-each loop calls `send(lateNight)` on each element. Every element
    uses its own `canSendAt()` (overriding, Ex1) through the same overloaded
    `send(LocalTime)` (Ex2). The ones that return `false` go into a second
    list, `postponed`.
  - A second loop resends the postponed notifications at 08:00. 08:00 is
    allowed because quiet hours are "before 08:00".
- No class files changed: a new kind of notification would work in this loop
  without changing the loop.

**Run it:** run `RunOrder.main()` -- the end of the output is

```
=== Order update to every channel (collection) ===
Postponed (quiet hours at 23:30): notification for Aziz Karimov
Browser notification in Chrome for Aziz Karimov: Order ORD-002 has been shipped
Postponed (quiet hours at 23:30): notification for Aziz Karimov
Browser notification in Safari for Aziz Karimov: Order ORD-002 has been shipped
Sent: 2, postponed: 2
--- 08:00: resending postponed notifications ---
Push notification to Aziz Karimov's iPhone 15: Order ORD-002 has been shipped
Push notification to Aziz Karimov's iPad Air: Order ORD-002 has been shipped
```
