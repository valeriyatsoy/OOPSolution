# Exercise 4 -- A Second Class, Generated

**Objective:** practise building a class the way you normally would in
IntelliJ -- generating the constructor, getters and setters instead of
typing them by hand.

**What changed:**
- Added `Customer`: three private fields of different types (`name` --
  String, `loyaltyPoints` -- int, `accountBalance` -- double), a generated
  constructor, and generated getters/setters for all three.
- `Main` creates a `Customer`, prints its details via the getters, updates
  `loyaltyPoints` with the setter, and prints again.

**Run it:** run `Main.main()` -- `Product` output is unchanged, followed by
the new `Customer` output.

**Next (Exercise 5, optional):** a getter gets extra logic instead of just
returning the raw field.
