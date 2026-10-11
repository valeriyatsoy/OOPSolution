# Seminar 6, Exercise 3 -- Interface Payable and three payment options

**Objective:** write an interface and three classes that realize it, one of
which also extends a class.

**What changed:**
- New interface `Payable` with one method:
  `boolean processPayment(double amount);`
- Three realizations (`implements Payable`), each with its own rules:
  - `BankCard` -- `cardNumber`, `holderName`, `balance`; `getMaskedNumber()`
    shows `**** 9012`; a payment is declined when the card has not enough
    money.
  - `BonusBalance` -- `points`, `addPoints(double)`; pays with bonus points,
    declined when there are not enough points.
  - `GiftCard extends Product implements Payable` -- a gift card can be
    bought (it is a product) and can pay (it is payable). Because `Product`
    is abstract since Ex2, `GiftCard` must implement
    `calculateDeliveryCost()` (0.0, sent by e-mail). It also overrides
    `getPriceWithTax()` (no VAT on gift cards). Its `balance` starts at its
    price.
- `Customer` -- composition: it creates and owns its payment methods.
  - `private BonusBalance bonusBalance = new BonusBalance(0);` + getter
  - `private BankCard bankCard;` + getter and
    `addBankCard(String cardNumber, double balance)`, which creates the card
    with the customer's name as the holder.
- `RunOrder` -- new section "Payment options": Aziz gets a card and 50 bonus
  points, buys a gift card in ORD-003, and then pays through three variables
  of the interface type `Payable`.

**Run it:** run `RunOrder.main()` -- the end of the output is

```
=== Payment options ===
Order ORD-003 for Aziz Karimov
  1 x Gift Card 100 @ 100.0 = 100.0
...
Total to pay: 100.0
Paid 100.0 by bank card **** 9012. Money left on the card: 1400.0
Paid 30.0 with bonus points. Points left: 20.0
Payment declined: only 20.0 bonus points available.
Paid 45.5 with gift card GIFT-2026. Left on the card: 54.5
```

**Next:** `seminarSix_ex4` (optional) adds the `CashbackEligible` interface.
