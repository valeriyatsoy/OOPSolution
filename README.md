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

---

# Seminar 3 -- Inheritance (companion project)

Seminar 3 continues in this same project: the starter is the final Seminar 2
state (`seminarTwo_ex6`), and all new classes are added to the existing
`com.seminar2` package. As before, each exercise has its own branch holding the
project exactly as it should look at the end of that exercise, plus a
`docs/EXERCISE_NOTES.md` explaining what changed.

```
seminarTwo_ex6            starter: final state of Seminar 2
 |- seminarThree_ex1          Product: getPriceWithTax + default deliver / calculateDeliveryCost
     |- seminarThree_ex2          PhysicalProduct and DigitalProduct subtypes (own fields and methods)
         |- seminarThree_ex3          constructors with super(...) calls
             |- seminarThree_ex4          overriding deliver() / calculateDeliveryCost(); protected helper roundToTwoDecimals()
                 |- seminarThree_ex5          multi-level: EBook and SoftwareLicense under DigitalProduct
                     |- seminarThree_ex6          (optional) EBook / SoftwareLicense override Product methods too
                         |- seminarThree_ex7          (optional) ElectronicDevice and Clothing under PhysicalProduct
```

To see one exercise's solution: `git checkout seminarThree_ex3`.
To see exactly what an exercise added: `git diff seminarThree_ex2..seminarThree_ex3`.
