package model.user;

import model.product.Product;
import services.cart.Cart;
import services.order.Checkout;
import services.shipping.ShippingService;

public class Customer {
    private Cart cart;
    private double balance;
    ShippingService shippingCart;
    
    public Customer(Cart cart, double balance){
        this.cart = cart;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }

    public Cart getCart(){
        return cart;
    }
    
    public boolean addToMyCart(Product product, int amount) {
        return cart.addToCart(product, amount);
    }
    public boolean addToMyCart(String productName, int amount) {
        return cart.addToCart(productName, amount);
    }

    public void removeFromMyCart(Product product, int amount){
        cart.removeFromCart(product, amount);
    }

    public void removeFromMyCart(String productName, int amount){
        cart.removeFromCart(productName, amount);
    }

    public void checkout(){
        shippingCart = new ShippingService();
        Checkout.checkout(cart, balance, shippingCart);
    }

    public void displayShippingList(){
        shippingCart.displayShippingList();
    }

    public void viewMyCart(){
        cart.viewCart();
    }
}
