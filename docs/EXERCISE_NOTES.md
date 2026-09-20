# Seminar 3, Exercise 3 -- Constructors in subclasses

**Objective:** understand how constructors work across an inheritance
relationship and write subclass constructors that call `super(...)`.

**What changed:**
- `PhysicalProduct` gained a constructor taking all five `Product` values plus
  its own `weightKg` and `fragile`. Its first line is
  `super(name, price, quantity, inStock, grade)`, which runs the `Product`
  constructor; only then does it set its own fields.
- `DigitalProduct` gained a constructor taking `name`, `price`, `grade`,
  `fileSizeMb`, `downloadUrl`. A subclass constructor does not have to mirror
  the parent's parameters: digital goods never sell out, so it passes the
  constants `0` and `true` for quantity and inStock inside `super(...)`.
- Once a class declares any constructor, Java no longer supplies the
  no-argument one -- so `new PhysicalProduct()` / `new DigitalProduct()` no
  longer compile, and `Main` now creates both objects through the new
  constructors (no more setter lines needed to fill the objects in).

**Run it:** run `Main.main()` -- same output as Exercise 2 (the delivery methods still
behave like `Product`'s general versions).

**Experiment (not part of the solution):** delete the `super(...)` line from one
constructor -- it still compiles because Java silently inserts `super()`, but
the object now has `Product`'s default values ("Unnamed product"). Then comment
out `Product`'s no-argument constructor and watch that same line stop compiling.

**What's next:** Exercise 4 overrides `deliver()` and `calculateDeliveryCost()` in both subtypes.
