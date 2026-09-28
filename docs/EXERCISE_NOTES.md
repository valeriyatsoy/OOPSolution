# Seminar 4, Exercise 5 (optional) -- Several delivery addresses with Map<String, ShippingAddress>

**Objective:** use a `Map` when every value is looked up by a unique key.

**What changed:**
- `Customer` has a new field
  `private Map<String, ShippingAddress> deliveryAddresses = new LinkedHashMap<>();`
  -- the key is a label such as `"home"` or `"office"`, the value is the
  address. (`LinkedHashMap` keeps the order of adding; `HashMap` would also
  work, `TreeMap` would sort the labels alphabetically.)
- The existing `shippingAddress` field stays: it is the address the next
  orders are shipped to, so `Order` did not have to change.
- New methods:
  - `addDeliveryAddress(String label, ShippingAddress address)` -- `put()`;
    prints a message when an existing label is replaced;
  - `boolean removeDeliveryAddress(String label)` -- `remove()` returns the
    old value or `null`;
  - `ShippingAddress getDeliveryAddress(String label)` -- `get()`, `null` if
    the label is unknown;
  - `boolean useDeliveryAddress(String label)` -- makes the chosen address
    the shipping address;
  - `Set<String> getAddressLabels()` -- a copy of `keySet()`;
  - `printDeliveryAddresses()` -- loop over `entrySet()` with
    `Map.Entry<String, ShippingAddress>`.
- `RunOrder` saves home/office/parents, replaces the office address, selects
  "office", and places ORD-002 for a winter jacket, which is shipped to the
  office.

**Run it:** run `RunOrder.main()` -- `Address "office" was replaced.`, the
jacket order (92.04 = 89.04 + 3.0) ships to 8 Shota Rustaveli St, and after
removing "parents" the labels are `[home, office]`.

**This is the final branch** -- `seminarFour_ex1` through `seminarFour_ex5`
together walk through the whole of Seminar 4 (Composition and Collections).
