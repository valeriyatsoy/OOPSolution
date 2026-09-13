# Exercise 2 -- Private Fields, Getters, Constructors

**Objective:** hide some of `Product`'s fields and see why that forces you to
set them through a constructor instead of the dot operator.

**What changed:**
- `name`, `price` and `quantity` are now `private`; `inStock` and `grade`
  stay `public`.
- Added `getName()`, `getPrice()`, `getQuantity()`.
- Added a no-argument constructor (sensible defaults) and a parameterised
  constructor taking all five fields -- constructor overloading.
- `Main` now builds its `Product` with the parameterised constructor and
  reads the private fields through the getters.

**Run it:** run `Main.main()` -- same five values print, but `Product`'s
three private fields can no longer be reached with `product.name = ...;`
from `Main`.

**Discuss in tutorial:** try assigning `product.name` directly in `Main` --
it no longer compiles. That's the point.

**Next (Exercise 3):** setters with validation logic are added for the three
private fields.
