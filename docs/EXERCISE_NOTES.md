# Seminar 10, Exercise 3 -- Factory Method: notification channels

**Objective:** stop writing `new MobileNotification(...)` / `new
WebNotification(...)` all over `RunOrder`. A *creator* class decides which
notification to create, and the code that sends works only with abstract types.

**Roles (same as Logistics / Transport in the lecture):**
- Creator -- abstract `NotificationChannel` (like `Logistics`)
- Concrete creators -- `MobileChannel`, `WebChannel`, `SmsChannel`
  (like `RoadLogistics`, `SeaLogistics`)
- Factory Product -- the existing abstract `Notification` (like `Transport`).
  Careful: the Factory Product is not our `Product` class.
- Concrete Factory Products -- `MobileNotification`, `WebNotification`, `SmsNotification`

**What changed:**
- New abstract class `NotificationChannel` (package `notification`, like all
  the new classes of this exercise):
  - `createNotification(Customer, String)` -- the factory method (abstract);
  - `notifyCustomer(customer, message, now)` -- common logic: creates the
    notification through the factory method and calls `send(now)`, so the
    quiet hours from Seminar 7 still apply.
- `MobileChannel(deviceName)` and `WebChannel(browser)` override
  `createNotification()` and return `MobileNotification` / `WebNotification`.
- `RunOrder` -- new section "Factory Method: notification channels": a
  `List<NotificationChannel>` sends "Order ORD-006 has been shipped" in one
  loop that never names a concrete notification class.
- Last step -- a new channel: `SmsNotification extends Notification` and
  `SmsChannel extends NotificationChannel`, plus one `add(...)` line in
  `RunOrder`.

**Discussion:** which existing classes had to change to add SMS? None --
only new classes and one new line in `RunOrder` (Open/Closed principle).

**Run it:** run `RunOrder.main()` -- the end of the output is

```
=== Factory Method: notification channels ===
Push notification to Aziz Karimov's iPhone 15: Order ORD-006 has been shipped
Browser notification in Chrome for Aziz Karimov: Order ORD-006 has been shipped
SMS to +998 90 123 45 67 for Aziz Karimov: Order ORD-006 has been shipped
```

**This is the final branch** -- `seminarTen_ex1` to `seminarTen_ex3`
together walk through the code of Seminar 10 (packages, Singleton and
Factory Method).
