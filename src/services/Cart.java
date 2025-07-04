package services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import interfaces.*;
import products.AvailableProducts;
import products.Product;

public class Cart implements cartInterface{
    private List<CartItem> cartItems;
    private AvailableProducts storeProducts;

    public Cart(AvailableProducts storeProducts){
        this.cartItems = new ArrayList<>();
        this.storeProducts = storeProducts;
    }

    public boolean addToCart(String productName, int amount){
        // Loop over store products
        for (Product product : storeProducts.getProductList()) {
            // check to find the product
            if(product.getName().equalsIgnoreCase(productName)){
                // if the product in the store is enough
                if(product.getQuantity() >= amount){
                    // check if the item in the cart
                    for (CartItem item : cartItems) {
                        if(item.getProduct().equals(product)){
                            item.changeAmount(amount);
                            product.decreaseQuantity(amount);
                            return true;
                        }
                    }
                    // Not in cart
                    cartItems.add(new CartItem(product, amount));
                    product.decreaseQuantity(amount);
                    return true;
                }
            }
            
        }
        return false;
    }
    public boolean removeFromCart(String productName, int amount){
        // Loop over cart items 
        for (CartItem item : cartItems) {
            Product product = item.getProduct();
            // product found 
            if(product.getName().equalsIgnoreCase(productName)){
                // amount in cart >= amount
                if(item.getAmount() >= amount){                
                item.changeAmount(-amount);
                product.increaseQuantity(amount);
                if(item.getAmount() == 0){
                    cartItems.remove(item);
                }
                return true;
            }
            else return false;

            }
        }
        return false;
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    public List<CartItem> getCartItems(){
        return Collections.unmodifiableList(cartItems);
    }


    public void viewCart() {
        System.out.println("Cart Contents:");
        for (CartItem item : cartItems) {
            item.displayItem();
            System.out.println();
        }
    }
}
