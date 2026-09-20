# Seminar 3, Exercise 2 -- Subtypes of Product

**Objective:** create the first two subclasses with `extends`, give each its own
fields and methods, and see what a subclass inherits from its parent.

**What changed:**
- Added `PhysicalProduct extends Product`: own fields `weightKg`, `fragile`;
  own methods `isHeavy()`, `reduceStock(int)`, `getPackagingNote()` plus
  getters/setters for its fields.
- Added `DigitalProduct extends Product`: own fields `fileSizeMb`,
  `downloadUrl`; own methods `download()`, `estimateDownloadSeconds(double)`
  plus getters/setters for its fields.
- Both classes also inherit `getPriceWithTax()`, `deliver()` and
  `calculateDeliveryCost()` from `Product` without declaring them. For now
  they behave like a plain `Product` (generic delivery message, cost 5.0) --
  Exercise 4 overrides the two delivery methods.
- Subclasses reach the parent's private fields only through the inherited
  public getters/setters (see `reduceStock`); the parent's public `inStock`
  field is directly accessible.
- `Main` builds each object with the (still available) no-argument constructor
  and fills it in with setters.

**Run it:** run `Main.main()` -- the inherited `getName()`, `getPriceWithTax()`,
`deliver()` etc. work on the new types without being written again.

**What's next:** Exercise 3 adds constructors that call `super(...)`.
