# Seminar 3, Exercise 5 -- Multi-level inheritance

**Objective:** add a third level to the hierarchy
(`Product` -> `DigitalProduct` -> `EBook` / `SoftwareLicense`) and override a
method from the immediate parent.

**What changed:**
- Added `EBook extends DigitalProduct`: own fields `author`, `pageCount`,
  `format`, a constructor calling `super(name, price, grade, fileSizeMb,
  downloadUrl)`, and getters/setters.
- Added `SoftwareLicense extends DigitalProduct`: own fields `licenseKey`,
  `durationMonths`, `maxDevices`, a constructor calling the same `super(...)`,
  and getters/setters.
- Both override `DigitalProduct.download()` to print details specific to
  their kind of product. They use `getName()` and `getFileSizeMb()` (inherited
  through two levels) because those fields are private in their parents.
- `Main` creates one object of each new type and calls `download()`,
  `deliver()` and `calculateDeliveryCost()` on them. `deliver()` and
  `calculateDeliveryCost()` are inherited unchanged from `DigitalProduct`
  for now.

**Run it:** run `Main.main()` -- `download()` prints the e-book's or license's
own details, while `deliver()` still prints the generic digital-product message.

**What's next:** Exercise 6 (optional) overrides `Product` methods in both new classes too.
