# Seminar 7, Exercise 2 -- Method overloading: sending at a given time

**Objective:** write several methods with the same name and different
parameter lists, and see the compiler choose one by the arguments.

**Business rule:** a normal notification respects the channel's quiet hours
(Exercise 1). An urgent one -- for example "suspicious payment on your
card" -- must be delivered immediately, even at night.

**What changed:**
- `Notification` -- two new overloads of `send`, so the class now has three:
  - `abstract void send()` -- sends right now (unchanged).
  - `boolean send(LocalTime now)` -- a normal, non-urgent notification:
    just calls `send(now, false)`.
  - `boolean send(LocalTime now, boolean urgent)` -- if `urgent` or
    `canSendAt(now)`, calls `send()` and returns `true`; otherwise prints
    "Postponed" and returns `false`.
- The overloads are written once, in the abstract class, but they call
  `canSendAt()` and `send()`, which are overridden -- so each subclass's own
  rules still apply.
- The overloads are in `Notification`, not in the subclasses: a method that
  exists only in `MobileNotification` cannot be called through a
  `Notification` variable.
- `RunOrder` -- new section "Sending with a time (overloading)" with a new
  urgent `fraudAlert`.

**Overloading vs overriding:** `send()` and `send(LocalTime)` in the same
class = overloading (same name, different parameters). `send()` in
`Notification` and in `MobileNotification` = overriding (same signature,
subclass). A different return type alone is not enough to overload.

**Run it:** run `RunOrder.main()` -- the end of the output is

```
=== Sending with a time (overloading) ===
Push notification to Aziz Karimov's iPhone 15: Order ORD-001 is waiting for payment: 2083.01
Postponed (quiet hours at 23:30): notification for Aziz Karimov
Browser notification in Chrome for Aziz Karimov: Order ORD-001 is waiting for payment: 2083.01
Push notification to Aziz Karimov's iPhone 15: Order ORD-001 is waiting for payment: 2083.01
Push notification to Aziz Karimov's iPhone 15: Suspicious payment of 999.0 on card **** 9012. Was it you?
```
