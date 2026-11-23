# Seminar 12, Exercise 2 -- Command: a menu of order commands (Scanner)

**Objective:** the customer edits an order by typing menu choices in the
console. Every menu key holds a command object, like the buttons of a remote
control, so the menu runs actions without knowing what they do.

**Roles (same as RemoteControl / TV in the lecture):**
- Command -- new interface `OrderCommand` (like `Command`)
- Concrete commands -- `AddItemCommand`, `RemoveItemCommand`
  (like `TurnOnTVCommand`)
- Receiver -- the existing `Order` (like `TV`)
- Invoker -- `OrderMenu` (like `RemoteControl`)
- Client -- the new main class `OrderConsole`

**What changed:**
- `Order` -- new method `removeItem(Product)`: removes the last order line
  with that product (nothing happens if it is not in the order).
- New package `command`:
  - `OrderCommand` -- `execute()`, `getDescription()`;
  - `AddItemCommand(order, product, quantity)` and
    `RemoveItemCommand(order, product)`;
  - `OrderMenu` -- `Map<String, OrderCommand> options`; `addOption(key,
    command)` assigns a command to a key; `select(key)` runs that key's
    command and prints "Done: ...", or "Unknown choice: ...".
- New class `OrderConsole` with a `main` method: assigns four commands to the
  keys 1-4, then a `Scanner` reads the user's choice in a loop and passes it to
  `menu.select()`; `0` prints the summary and places the order.

**Discussion:** to add the option "5 - add 2 jackets", which classes must
change? Only `OrderConsole` (one `addOption` line and one menu line) --
`OrderMenu` works with any `OrderCommand` (Open/Closed principle).

**Run it:** run `OrderConsole.main()` and type `2`, `1`, `3`, `0`:

```
Your choice: 2
Done: add 1 x Winter Jacket
Order total: 92.04
Your choice: 1
Done: add 1 x Laptop
Order total: 1112.18
Your choice: 3
Done: remove Laptop
Order total: 92.04
Your choice: 0
Order ORD-006 for Aziz Karimov
...
Order ORD-006 placed. 92.04 was charged.
```
(The menu lines between the choices are not shown here.)
