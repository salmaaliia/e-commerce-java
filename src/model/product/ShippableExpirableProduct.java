package model.product;

import java.time.LocalDate;

import interfaces.*;
import interfaces.product.Expirable;
import interfaces.product.Shippable;

public class ShippableExpirableProduct extends Product  {
    private double weight;
    private LocalDate expiryDate;

    public ShippableExpirableProduct(String name, double price, int quantity, double weight, LocalDate expiryDate){
        super(name, price, quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;

        this.shippable = new Shippable() {
        @Override
        public double getWeight(){
            return weight;
        }
        @Override
        public String getName(){
            return name;
        }
        
    };

        this.expirable = new Expirable() {
        @Override
        public LocalDate getExpiryDate(){
            return expiryDate;
        }
    };
    
}


    /* 
    @Override
    public double getWeight(){
        return weight;
    }
    @Override
    public String getName(){
        return super.getName();
    }*/

    /* 
    @Override
    public LocalDate getExpiryDate(){
        return expiryDate;
    }*/
    
    @Override
    public void displayProduct() {
        super.displayProduct();
        System.out.println("Weight: " + weight);
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("Expired: " + (isExpired() ? "Yes" : "No"));
    }
        

}
