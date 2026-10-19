# Seminar 7, Exercise 1 -- Method overriding: quiet hours

**Objective:** override a concrete (non-abstract) method inherited from a
superclass, and see that the object -- not the variable type -- decides which
version runs.

**Business rule:** a push message must not wake the customer up at night
(22:00-08:00). A browser notification only appears while the customer has the
shop open, so it can be shown at any time.

**What changed:**
- `Notification` -- new concrete method `boolean canSendAt(LocalTime time)`.
  The default rule: it returns `true` (send at any time).
- `MobileNotification` -- overrides `canSendAt()` with `@Override`: returns
  `false` during quiet hours. The interval crosses midnight, so the check is
  `!time.isBefore(22:00) || time.isBefore(08:00)` -- with `&&` it would never be
  true.
- `WebNotification` -- unchanged: it inherits the default `canSendAt()`.
  Overriding a concrete method is optional; implementing an abstract method
  (`send()`) is not.
- `RunOrder` -- new section "Quiet hours (overriding)".

**Try it:** in `MobileNotification`, remove `@Override` and rename the method
to `canSendAT`. It still compiles, but now nothing is overridden and the push
notification can be sent at 23:30. Put `@Override` back: the compiler reports
an error. That is what the annotation is for.

**Run it:** run `RunOrder.main()` -- the end of the output is

```
=== Quiet hours (overriding) ===
Push at 23:30: false
Web at 23:30: true
Push at 09:15: true
```
