# Seminar 11, Exercise 2 -- Adapter: paying with an external wallet

**Objective:** the shop wants to accept payments from an external mobile
wallet. The wallet comes as a ready-made SDK class we cannot change, and its
API does not fit our `Payable` interface. Without changing the SDK or any of
our existing classes, we write an adapter so that the wallet can be used
anywhere a `Payable` is expected.

**Roles (same as in the Mp3Player / StreamingAudio handout):**
- Client -- the existing `Customer.pay(Payable, amount)` (like `AudioPlayerClient`)
- Target -- the existing interface `Payable` (like `AudioSource`)
- Adaptee -- `QuickPayWallet`, the external SDK (like `StreamingAudio`)
- Adapter -- `QuickPayAdapter` (like `StreamingToMp3Adapter`)

**What does not fit (what the adapter translates):**

| Our shop (`Payable`)            | QuickPay SDK (`QuickPayWallet`)          |
|---------------------------------|------------------------------------------|
| `processPayment(double amount)` | `transfer(String phoneNumber, long amountInTiyin)` |
| amount as a `double` (127.04)   | whole tiyin as a `long` (12704)          |
| no phone number                 | needs the customer's phone number        |
| returns `boolean`               | returns `"OK"` or `"DECLINED"`           |

**What changed:**
- New package `adapter`:
  - `QuickPayWallet` -- stands in for the external SDK; treat it as code we
    are not allowed to edit.
  - `QuickPayAdapter implements Payable` -- an *object adapter*: it HAS a
    `QuickPayWallet` (composition) and the phone number. `processPayment()`
    converts the amount to tiyin, calls `transfer()`, and turns the `String`
    status into a `boolean`.
- `RunOrder` -- new section "Adapter: paying with an external wallet": the
  customer pays the decorated order from Ex1 through `customer.pay(...)`, then
  a second payment is declined because the wallet has only 500.00.
- No existing class changed: not `Customer`, not `Payable`, not the SDK.

**Discussion:**
- Why can we not just write `Payable byWallet = wallet;`? `QuickPayWallet`
  does not implement `Payable`, and we are not allowed to change it.
- Decorator vs Adapter -- both wrap an object. The Decorator keeps the
  interface (`OrderCost` in, `OrderCost` out) and adds behaviour; the Adapter
  changes the interface (`QuickPayWallet` in, `Payable` out) and adds nothing.
- QuickPay pays no cashback, so `Customer.pay` prints no cashback line.
  (Advanced) If the wallet gave 2% cashback, what would `QuickPayAdapter`
  have to implement? (`Payable, CashbackEligible` -- a class can implement
  several interfaces.)

**Run it:** run `RunOrder.main()` -- the end of the output is

```
=== Adapter: paying with an external wallet ===
  [QuickPay] Transfer of 13704 tiyin from +998 90 123 45 67...
Paid 137.04 with QuickPay (+998 90 123 45 67).
  [QuickPay] Transfer of 102014 tiyin from +998 90 123 45 67...
Payment declined by QuickPay.
```
