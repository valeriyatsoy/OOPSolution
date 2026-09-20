# Seminar 3, Exercise 1 -- Enhance the Product class

**Objective:** prepare `Product` to be a parent class by giving it shared
behaviour that its future subtypes will inherit.

**What changed:**
- Added `public double getPriceWithTax()` -- price + 12% VAT, rounded to two
  decimals. Every subtype will inherit it as it is.
- Added `public void deliver()` -- prints a general "Delivering <name> to the
  customer." message.
- Added `public double calculateDeliveryCost()` -- returns a standard flat fee
  of 5.0.
- `deliver()` and `calculateDeliveryCost()` are ordinary methods with default
  behaviour; subtypes will replace ("override") them with more specific
  versions in Exercise 4.
- `Main` calls the three new methods on the existing `Product` object.

**Run it:** run `Main.main()` -- the Product block now also prints the price
with tax (22.39), the delivery message and the delivery cost (5.0).

**What's next:** Exercise 2 creates `PhysicalProduct` and `DigitalProduct`.
