# Seminar 2 -- Encapsulation (companion project)

Console-only Java project (package `com.seminar2`) built alongside the Seminar 2
handout. Each exercise in the handout has its own git branch, and each branch
contains the project exactly as it should look at the end of that exercise,
plus a `docs/EXERCISE_NOTES.md` explaining what changed.

```
main            blank IntelliJ starter (JDK 18 template)
 |- ex1         Product: five public fields, no methods
     |- ex2         Product: name/price/quantity private, getters, constructors
         |- ex3         Product: setters with validation
             |- ex4         Customer: generated constructor/getters/setters
                 |- ex5         Customer: extra logic in a getter (optional)
                     |- ex6         Composition: Address nested inside Customer (advanced)
```

Branches build on one another in exercise order, so `ex4` already contains
everything from `ex1`-`ex3`. Checkout a branch to see that exercise's solution:

```
git checkout ex3
```

To see exactly what an exercise added, diff it against its parent:

```
git diff ex2..ex3
```
