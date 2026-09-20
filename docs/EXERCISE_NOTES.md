# Seminar 3, Exercise 4 -- Method overriding

**Objective:** replace the inherited `deliver()` and `calculateDeliveryCost()`
with versions written for each subtype and see that the same method call
behaves differently for different objects.

**What changed:**
- `PhysicalProduct.deliver()` prints a shipping message including the
  packaging note, and an extra line for heavy items.
- `PhysicalProduct.calculateDeliveryCost()` returns a base fee of 5.00 plus
  1.50 per kg, plus a 4.00 surcharge for fragile items, rounded to two decimals.
- `DigitalProduct.deliver()` "e-mails" the download link.
- `DigitalProduct.calculateDeliveryCost()` returns `0.0` -- nothing to ship.
- Both classes mark these methods with `@Override`, which makes the compiler
  check that the method really matches one in a parent class.
- `Product` gained a `protected double roundToTwoDecimals(double)` helper
  (the `Math.round(value * 100.0) / 100.0` trick in one place). `protected`
  means only `Product` and its subclasses can use it; `Product.getPriceWithTax()`
  and `PhysicalProduct.calculateDeliveryCost()` now call it instead of repeating
  the rounding. Java's `protected` also includes the same package, so `Main`
  (same package) could call it too -- the hiding shows when a subclass lives in
  another package. Later exercises use the helper wherever they round a price.
- `Main` is unchanged: it already called `deliver()` and
  `calculateDeliveryCost()` on both objects, but they now run the new versions.

**Run it:** run `Main.main()` -- laptop delivery cost is 12.15 (it was 5.0
before), the video course's is 0.0, and each object prints its own kind of
delivery message.

**What's next:** Exercise 5 adds a third level of inheritance under `DigitalProduct`.
