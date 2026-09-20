# Seminar 3, Exercise 6 (optional) -- Overriding methods from the top of the hierarchy

**Objective:** override methods that were first declared in `Product`
(two levels up), and use `super.method()` to extend a parent's behaviour
instead of replacing it.

**What changed:**
- `EBook` overrides `getPriceWithTax()` (fully replaces it: reduced 6% rate,
  an assumption made just for this exercise) and `deliver()` (adds the book to
  an online library and e-mails the file link).
- `SoftwareLicense` overrides `getPriceWithTax()` by calling
  `super.getPriceWithTax()` and adding a flat 2.00 activation fee, and overrides
  `deliver()` to send the installer link together with the license key.
- Neither class overrides `calculateDeliveryCost()`: they inherit
  `DigitalProduct`'s version (0.0) -- inheritance saves us rewriting it.
- `Main` is unchanged; its existing calls now run the new versions.

**Run it:** run `Main.main()` -- e-book price with tax drops to 26.5, the
license's rises to 69.19, and both print their own `deliver()` messages.

**What's next:** Exercise 7 (optional) repeats the idea under `PhysicalProduct`.
