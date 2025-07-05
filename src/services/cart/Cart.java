package services.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import interfaces.*;
import interfaces.cart.CartInterface;
import model.product.AvailableProduct;
import model.product.Product;

public class Cart implements CartInterface{
    private List<CartItem> cartItems;
    private AvailableProduct store;

    public Cart(AvailableProduct store){
        this.cartItems = new ArrayList<>();
        this.store = store;
    }

    @Override
    public boolean addToCart(Product product, int amount){
        if(!store.getProductList().contains(product)) return false;
        int amountTobeAdded = Math.min(amount, product.getQuantity());
        if (amountTobeAdded == 0) {
            System.out.println(product.getName() + " is out of stock!");
            return false;
        }
        // check if the item is in the cart
        for (CartItem cartItem : cartItems) {
            if(cartItem.getProduct().equals(product)){
                cartItem.changeAmount(amountTobeAdded);
                product.decreaseQuantity(amountTobeAdded);
                return true;
            }
        }
        cartItems.add(new CartItem(product, amountTobeAdded));
        product.decreaseQuantity(amountTobeAdded);
        return true;
    }

    @Override
    public boolean addToCart(String productName, int amount){
        // Loop over store products
        for (Product product : store.getProductList()) {
            // check to find the product
            if(product.getName().equalsIgnoreCase(productName)){
                return addToCart(product, amount);
            }
            
        }
        return false;
    }

    @Override
    public boolean removeFromCart(Product product, int amount){
        Iterator<CartItem> iterator = cartItems.iterator();
        while (iterator.hasNext()) {
            CartItem cartItem = iterator.next();
            if(product.equals(cartItem.getProduct())){
                if(cartItem.getAmount() >= amount){
                    cartItem.changeAmount(-amount);
                    product.increaseQuantity(amount);
                    if(cartItem.getAmount() == 0) iterator.remove();
                    return true;
                }
            } 
        }

        return false;
    }

    @Override
    public boolean removeFromCart(String productName, int amount){
        Iterator<CartItem> iterator = cartItems.iterator();
        while (iterator.hasNext()) {
            CartItem item = iterator.next();
            Product product = item.getProduct();
            if (product.getName().equalsIgnoreCase(productName)) {
                if (item.getAmount() >= amount) {
                    item.changeAmount(-amount);
                    product.increaseQuantity(amount);
                    if (item.getAmount() == 0) {
                        iterator.remove();
                    }
                    return true;
                }
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
        System.out.println("\nCart Contents:\n");
        for (CartItem item : cartItems) {
            item.displayItem();
            System.out.println();
        }
    }
}
