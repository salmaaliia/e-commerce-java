package services.order;

import model.product.Product;
import services.cart.Cart;
import services.cart.CartItem;
import services.shipping.ShippingService;

public class Checkout {

public static void checkout(Cart cart, double balance, ShippingService shippingCart){
        if(cart.isEmpty()) {
            System.out.println("Your cart is empty, add products to checkout.");
        }
        double subtotal = 0;
        double shipping = 30;
        double amount;
        double totalShippingWeight = 0;


        for (CartItem cartItem : cart.getCartItems()){
            Product product = cartItem.getProduct();
            if(product.isExpirable()) {
                if(product.isExpired()){
                    System.out.println("************ NOTICE ************");
                    System.out.println(product.getName() + " is expired, remove it from cart then checkout again.");
                    return;
                }
            }
            subtotal += (cartItem.getAmount() * cartItem.getProduct().getPrice());
        }
        amount = shipping + subtotal;
        if(amount > balance){
            System.out.println("************ NOTICE ************");
            System.out.println("Your balance is insufficient");
            return;
        }


        // Shipment notice
        System.out.println("\n** Shipment notice **");
        for (CartItem cartItem : cart.getCartItems()) {
            Product product = cartItem.getProduct();
            if(product.isShippable()){
                shippingCart.addToList(product);
                double productWeight = product.getWeightIfAvailable() * cartItem.getAmount();
                totalShippingWeight += productWeight;

                String pWeight = productWeight >= 1000.0 ? String.format("%.2f kg", productWeight / 1000.0) : String.format("%.0f g", productWeight);

                System.out.printf("%sx %-15s %s%n", cartItem.getAmount(), product.getName(), pWeight);
            }
        }
        String totalWeightString = totalShippingWeight >= 1000.0 ? String.format("%.2f kg", totalShippingWeight / 1000.0) : String.format("%.0f g", totalShippingWeight);
        System.out.printf("Total package weight %s%n", totalWeightString);

        // Checkout receipt
        System.out.println("\n** Checkout receipt **");
        for (CartItem cartItem : cart.getCartItems()) {
            Product product = cartItem.getProduct();
            double price = cartItem.getAmount() * product.getPrice();
            System.out.printf("%sx %-15s %.2f%n", cartItem.getAmount(), product.getName(), price);
            
        }
        System.out.println("----------------------");
        System.out.printf("%-20s %.2f%n", "Subtotal", subtotal);
        System.out.printf("%-20s %.2f%n", "Shipping", shipping);
        System.out.printf("%-20s %.2f%n", "Amount", amount);



    }
}
