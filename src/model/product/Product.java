package model.product;

import interfaces.product.Expirable;
import interfaces.product.Shippable;

public class Product {
    private String name;
    private double price;
    private int quantity;

    public Shippable shippable;
    public Expirable expirable;

    public Product(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {return name;}
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public Shippable getShippable() { return shippable; }
    public Expirable getExpirable() {return expirable; }

    public double getWeightIfAvailable() {
        return shippable != null ? shippable.getWeight() : -1; 
    }

    public boolean isShippable() {
        return shippable != null;
    }
    
    public boolean isExpirable(){
        return expirable != null;
    }

    public boolean isExpired(){
        if(expirable == null) {
            return false;
        }
        return expirable.isExpired();
    }


    public void decreaseQuantity(int amount){
        if(quantity >= amount) quantity -= amount;
        else System.out.println("Not enough stock to decrease.");
    }
    public void increaseQuantity(int amount){
        quantity += amount;
    }

    public void displayProduct(){
        System.out.println("Product: " + name);
        System.out.println("Price: EGP " + price);
        System.out.println("Quantity: " + quantity);
    }

}

