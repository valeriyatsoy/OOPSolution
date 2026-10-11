# Seminar 6, Exercise 2 -- Product becomes abstract

**Objective:** turn an existing parent class into an abstract class and one
of its methods into an abstract method.

**What changed:**
- `public abstract class Product` -- nobody sells "just a product": every
  product in the shop is a `PhysicalProduct` or a `DigitalProduct` (or one of
  their subclasses). `new Product(...)` no longer compiles; nothing in the
  project created a plain `Product`, so nothing breaks.
- `public abstract double calculateDeliveryCost();` -- the flat 5.0 fee is
  gone: there is no sensible default, so each subclass must give its own.
- The rest of `Product` (fields, both constructors, getters/setters,
  `getPriceWithTax()`, `deliver()`, `roundToTwoDecimals()`) stays exactly the
  same: an abstract class can mix normal and abstract methods.
- No other file changed. `PhysicalProduct` and `DigitalProduct` already
  override `calculateDeliveryCost()` (Seminar 3), so they compile. `EBook`,
  `SoftwareLicense`, `ElectronicDevice` and `Clothing` inherit an
  implementation from their parents.

**Try it:** comment out `calculateDeliveryCost()` in `DigitalProduct` --
the compiler reports *DigitalProduct is not abstract and does not override
abstract method calculateDeliveryCost() in Product*. Put the method back.

**Run it:** `RunOrder.main()` and `Main.main()` print exactly the same output
as on `seminarSix_ex1`.

**Next:** `seminarSix_ex3` adds the `Payable` interface.
