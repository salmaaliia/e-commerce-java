# E-Commerce System - Java

A modular Java-based e-commerce system showcasing core object-oriented principles such as inheritance, abstraction, interfaces, and service layers. This project simulates a backend for an online store that manages various product types, shopping cart interactions, and checkout with shipping logic.

---

## Overview

This application models a small-scale e-commerce platform with the following capabilities:

- Define different product types (e.g., shippable, expirable)
- Manage a store inventory
- Add/remove products to/from a customer cart
- Perform checkout with:

  - Validation (balance, stock, expiration)
  - Subtotal and shipping calculation
  - Shipping service integration

Focus is on clean code, modular design, and clear simulation of real-world shopping behavior.

---

## Project Structure

```
src/
├── interfaces/
│   ├── cart/
│   │   └── CartInterface.java
│   └── product/
│       ├── Expirable.java
│       └── Shippable.java
│
├── model/
│   ├── product/
│   │   ├── Product.java
│   │   ├── AvailableProduct.java
│   │   ├── ExpirableProduct.java
│   │   ├── ShippableProduct.java
│   │   └── ShippableExpirableProduct.java
│   └── user/
│       └── Customer.java
│
├── services/
│   ├── cart/
│   │   ├── Cart.java
│   │   └── CartItem.java
│   ├── order/
│   │   └── Checkout.java
│   └── shipping/
│       ├── ShippableItem.java
│       └── ShippingService.java
│
└── App.java               # Main entry point
```

---

## Features

- Add/remove products to cart by name or object
- Product expiration handling
- Shipping support for weighted items
- Full checkout flow with:

  - Balance check
  - Subtotal and shipping fees
  - Receipt and shipping summary in console

- Modular class and interface design for flexibility

---

## Example Run

```java
// Store
AvailableProduct store = new AvailableProduct();
ShippableExpirableProduct Biscuits = new ShippableExpirableProduct("shato", 25, 1, 150, LocalDate.of(2026, 2, 1));
ShippableExpirableProduct cheese = new ShippableExpirableProduct("Cheese", 150, 100, 200, LocalDate.of(2027, 10, 1));
ShippableProduct TV =  new ShippableProduct("TV", 1000, 20, 5000);
Product mobileScratchCards = new Product("Mobile scratch cards", 10, 100);

store.addProductToStore(cheese);
store.addProductToStore(TV);
store.addProductToStore(mobileScratchCards);
store.addProductToStore(Biscuits);

// customer
Cart cart = new Cart(store);
Customer salma = new Customer(cart, 10000);

salma.addToMyCart("Cheese", 5);
salma.addToMyCart("TV", 1);
salma.addToMyCart("Shato", 2);
salma.addToMyCart("Cheese", 2);
salma.addToMyCart(Biscuits, 1);
salma.addToMyCart(cheese, 1);
salma.addToMyCart(mobileScratchCards, 2);

salma.removeFromMyCart(cheese, 2);

salma.checkout();
```

### Sample Output

```
** Shipment notice **
6x Cheese          1.20 kg
1x TV              5.00 kg
1x shato           150 g
Total package weight 6.35 kg

** Checkout receipt **
6x Cheese          900.00
1x TV              1000.00
1x shato           25.00
2x Mobile scratch cards 20.00
----------------------
Subtotal             1945.00
Shipping             30.00
Amount               1975.00
```
