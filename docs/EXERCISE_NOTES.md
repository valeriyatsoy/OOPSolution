# Exercise 5 (Optional) -- Extra Logic in a Getter

**Objective:** see that a getter is a normal method -- it can compute, not
just return, a value.

**What changed:**
- `Customer.getName()` now trims the stored name before returning it.
- `Customer.getAccountBalance()` now rounds the balance to two decimal
  places before returning it.
- `Main` passes an unrounded balance (`45.567`) into the `Customer`
  constructor to make the rounding visible in the printed output.

**Run it:** run `Main.main()` -- `Account balance:` prints `45.57`, not
`45.567`, even though nothing changed about how the getter is called.

**Next (Exercise 6, advanced):** composition -- `Customer` gets an
`Address`.
