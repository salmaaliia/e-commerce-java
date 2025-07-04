package products;

import java.time.LocalDate;

import interfaces.Expirable;
import interfaces.Shippable;

public class ShippableExpirableProducts extends Product implements Shippable, Expirable {
    private double weight;
    private LocalDate expiryDate;

    public ShippableExpirableProducts(String name, double price, int quantity, double weight, LocalDate expiryDate){
        super(name, price, quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }


    @Override
    public double getWeight(){
        return weight;
    }
    @Override
    public String getName(){
        return super.getName();
    }

    @Override
    public LocalDate getExpiryDate(){
        return expiryDate;
    }
        @Override
    public void displayProduct() {
        super.displayProduct();
        System.out.println("Weight: " + weight);
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("Expired: " + (isExpired() ? "Yes" : "No"));
    }

}
