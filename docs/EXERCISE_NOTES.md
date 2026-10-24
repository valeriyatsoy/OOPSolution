# Seminar 10, Exercise 1 -- Organise the project into packages

**Objective:** group related classes into packages (folders) before the
project grows further -- the same structure you will want in the coursework.

**What changed:** no code logic changed; the classes were moved from
`com.seminar2` into sub-packages (in IntelliJ: right-click `com.seminar2` ->
New -> Package, then drag the classes in or use Refactor -> Move, F6).

```
com.seminar2                Main, RunOrder (entry points stay at the top)
 |- customer                Customer, ShippingAddress
 |- exception               InsufficientBalanceException
 |- notification            Notification, MobileNotification, WebNotification
 |- order                   Order, OrderItem
 |- payment                 Payable, CashbackEligible, BankCard, BonusBalance
 |- product                 Product, PhysicalProduct, DigitalProduct, EBook,
                            SoftwareLicense, ElectronicDevice, Clothing, GiftCard
```

- The first line of every moved class is now its new package, e.g.
  `package com.seminar2.product;`.
- Classes that use a class from another package got `import` lines, e.g.
  `Order` imports `com.seminar2.customer.Customer`,
  `com.seminar2.product.Product` and
  `com.seminar2.exception.InsufficientBalanceException`.

**Discussion:** nothing broke because every class, constructor and method used
from another package is `public`. A member without an access modifier is
visible only inside its own package. `protected` (e.g.
`Product.roundToTwoDecimals()`) still works in the subclasses.

**Run it:** run `RunOrder.main()` and `Main.main()` -- the output is exactly
the same as on `seminarEight_ex5`.

**Next:** `seminarTen_ex2` -- Singleton: one order number generator.
