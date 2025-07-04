package services;


public class Customer {
    private Cart cart;
    private double balance;
    
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
    
    public void addToCart(String productName, int amount) {
        cart.addToCart(productName, amount);
    }

    public void removeFromCart(String productName, int amount){
        cart.removeFromCart(productName, amount);
    }
}
