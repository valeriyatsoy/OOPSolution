# Exercise 3 -- Setters and Validation

**Objective:** add controlled, validated write-access back to the private
fields.

**What changed:**
- Added `setName`, `setPrice`, `setQuantity`, each rejecting an invalid
  value (blank name, negative price, negative quantity) with a printed
  message instead of applying it.
- `Main` now calls the setters -- once with a valid price, once with an
  invalid quantity -- to show the validation in action.

**Run it:** run `Main.main()`. The price update is applied; the negative
quantity is rejected and the quantity is left unchanged, without stopping
the program.

**Next (Exercise 4):** a second class, `Customer`, is built from scratch
using IntelliJ's constructor/getter/setter generator.
