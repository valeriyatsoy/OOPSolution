# Seminar 3, Exercise 7 (optional) -- Multi-level inheritance under PhysicalProduct

**Objective:** repeat the multi-level pattern on the physical side of the
hierarchy (`Product` -> `PhysicalProduct` -> `ElectronicDevice` / `Clothing`),
overriding methods from both the immediate parent and the top-level `Product`.

**What changed:**
- Added `ElectronicDevice extends PhysicalProduct`: own fields `brand`,
  `warrantyMonths`; its constructor passes `true` for `fragile` and computes
  `inStock` as `quantity > 0` inside `super(...)`.
- Added `Clothing extends PhysicalProduct`: own fields `size`, `material`;
  its constructor passes `false` for `fragile`.
- Both override `PhysicalProduct.getPackagingNote()` (parent's own method)
  and `deliver()` / `calculateDeliveryCost()` (declared in `Product`).
- `ElectronicDevice.calculateDeliveryCost()` calls
  `super.calculateDeliveryCost()` and adds a 2.50 insurance fee (extends the
  parent's version); `Clothing.calculateDeliveryCost()` returns a flat 3.00
  (replaces the parent's version).
- `Main` creates one object of each new type.

**Run it:** run `Main.main()` -- the smartphone's delivery cost is 11.8
(5.00 + 0.30 + 4.00 fragile + 2.50 insurance), the jacket's is a flat 3.0.

**This is the final branch** -- `seminarThree_ex1` through `seminarThree_ex7`
together walk through the whole of Seminar 3 (Inheritance).
