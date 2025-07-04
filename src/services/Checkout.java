package services;

import java.util.ArrayList;
import java.util.List;

import interfaces.Expirable;
import interfaces.Shippable;
import products.Product;

public class Checkout {
    private Customer customer;
    private Cart cart;

    public Checkout(Customer customer, Cart cart){
        this.customer = customer;
        this.cart = cart;
    }
    public static void processCheckout(Customer customer) {
        Cart cart = customer.getCart();

        if (cart.isEmpty()) {
            System.out.println("Checkout failed: Cart is empty.");
            return;
        }

        List<CartItem> items = cart.getCartItems();
        List<Shippable> toShip = new ArrayList<>();
        double subtotal = 0;
        double shipping = 0;

        for (CartItem item : items) {
            Product product = item.getProduct();

            if (product instanceof Expirable expirable && expirable.isExpired()) {
                System.out.println("Checkout failed: " + product.getName() + " is expired.");
                return;
            }

            if (product.getQuantity() < 0) {
                System.out.println("Checkout failed: " + product.getName() + " is out of stock.");
                return;
            }

            subtotal += product.getPrice() * item.getAmount();

            if (product instanceof Shippable shippable) {
                for (int i = 0; i < item.getAmount(); i++) {
                    toShip.add(shippable);
                    shipping += shippable.getWeight() * 10; // 10 per kg
                }
            }
        }

        double total = subtotal + shipping;

        if (customer.getBalance() < total) {
            System.out.printf("Insufficient balance. Required: %.0f, Available: %.0f%n", total, customer.getBalance());
            return;
        }

        if (!toShip.isEmpty()) {
            ShippingService.shipping(toShip);
        }

        System.out.println("** Checkout receipt **");
        for (CartItem item : items) {
            double lineTotal = item.getProduct().getPrice() * item.getAmount();
            System.out.printf("%dx %s %.0f%n", item.getAmount(), item.getProduct().getName(), lineTotal);
        }

        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f%n", subtotal);
        System.out.printf("Shipping %.0f%n", shipping);
        System.out.printf("Amount %.0f%n", total);

        customer.setBalance(customer.getBalance() - total);
        System.out.printf("Remaining Balance: %.0f%n", customer.getBalance());
    }


}
