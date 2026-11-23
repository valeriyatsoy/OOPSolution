# Seminar 12, Exercise 1 -- Observer: order status updates

**Objective:** when an order's status changes, the customer should be told
automatically through the channels they use. The order announces the change;
it does not know who is listening.

**Roles (same as WeatherStation / PhoneDisplay in the lecture):**
- Subject -- `Order` (like `WeatherStation`); it implements the new interface
  `OrderObservable` (like `Observable` in the handout)
- Observer -- new interface `OrderObserver` (like `Observer`)
- Concrete observers -- the existing `MobileChannel`, `WebChannel`, `SmsChannel`
  (like `PhoneDisplay`, `TVDisplay`)

**What changed:**
- New enum `OrderStatus` (package `order`): `NEW`, `PLACED`, `SHIPPED`, `DELIVERED`.
- New interfaces in package `observer`:
  - `OrderObserver` -- `onStatusChanged(Order order, OrderStatus newStatus)`;
  - `OrderObservable` -- `addObserver()`, `removeObserver()`, `notifyObservers()`.
- `Order implements OrderCost, OrderObservable` -- new fields `status`
  (starts as `NEW`) and `List<OrderObserver> observers`; it implements
  `addObserver()`, `removeObserver()` and `notifyObservers()`; new methods
  `getStatus()` and `setStatus()`, which saves the status and calls
  `notifyObservers()`.
  `place()` calls `setStatus(OrderStatus.PLACED)` after charging.
- `NotificationChannel implements OrderObserver` -- `onStatusChanged()` creates
  the notification with the factory method (Seminar 10) and sends it. So every
  channel is an observer without changing `MobileChannel`, `WebChannel` or
  `SmsChannel`.
- `RunOrder` -- new section "Observer: order status updates": a push channel
  and an SMS channel subscribe to a new order; the order is placed and shipped;
  the customer turns SMS off; the order is delivered.

**Discussion:** what would we need to change to also send an e-mail? Only a
new channel class -- `Order` stays the same (Open/Closed principle).

**Run it:** run `RunOrder.main()` -- the end of the output is

```
=== Observer: order status updates ===
Order ORD-009 placed. 92.04 was charged.
Push notification to Aziz Karimov's iPhone 15: Order ORD-009 is now PLACED
SMS to +998 90 123 45 67 for Aziz Karimov: Order ORD-009 is now PLACED
Push notification to Aziz Karimov's iPhone 15: Order ORD-009 is now SHIPPED
SMS to +998 90 123 45 67 for Aziz Karimov: Order ORD-009 is now SHIPPED
Push notification to Aziz Karimov's iPhone 15: Order ORD-009 is now DELIVERED
```
