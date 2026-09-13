# Exercise 1 -- Public Fields

**Objective:** see how a class with plain public fields is created and used,
before any encapsulation is introduced.

**What's here:** `Product` with five public fields of different types
(`name`, `price`, `quantity`, `inStock`, `grade`) and no methods. `Main`
creates one `Product` with the no-argument constructor Java supplies
automatically, sets each field with the dot operator, then prints them the
same way.

**Run it:** run `Main.main()` -- you should see the five values printed back.

**Next (Exercise 2):** `name`, `price` and `quantity` become `private`, with
getters added -- and `product.name = ...;` style code stops compiling.
