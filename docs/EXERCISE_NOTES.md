# Seminar 4, Exercise 1 -- Refactoring: Address becomes ShippingAddress

**Objective:** practise IntelliJ's safe refactorings on an existing
has-a relationship (`Customer` has an `Address`) before we build new ones.

**What changed:**
- Added a second main class, `RunOrder` (a class with its own `main` method),
  for the composition exercises; its `main` is still empty. `Main` keeps the
  Seminar 3 inheritance demos.
- `Address` renamed to `ShippingAddress` with **Shift+F6** (Refactor > Rename):
  the file, the class and every usage (`Customer`, `Main`) changed together.
- In `Customer`, the field `address` renamed to `shippingAddress` with
  **Shift+F6**; IntelliJ offered to rename the getter/setter as well, so they
  are now `getShippingAddress()` / `setShippingAddress(...)`.

**Run it:** run `Main.main()` -- the output is exactly the same as before:
a refactoring changes the structure of the code, not its behaviour.

**Next:** `seminarFour_ex2` -- the `OrderItem` class.
