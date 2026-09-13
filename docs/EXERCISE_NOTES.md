# Exercise 6 (Advanced) -- Composition with Address

**Objective:** practise composition by giving `Customer` a field whose type
is another class.

**What changed:**
- Added `Address`: `street`, `city`, `postalCode` (all `String`), a
  constructor, and getters/setters.
- `Customer` gained a private `Address` field, a second (overloaded)
  constructor that also accepts an `Address`, and a getter/setter for it.
- `Main` creates an `Address`, passes it into the `Customer` constructor,
  and prints `customer.getAddress().getCity()` to show the chained access.

**Run it:** run `Main.main()` -- the final line of the `Customer` block
prints the address's city via the nested getter call.

**This is the final branch** -- `ex1` through `ex6` together walk through
the whole of Seminar 2 (Encapsulation), each branch building cleanly on the
last.
