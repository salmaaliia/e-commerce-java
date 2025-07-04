package products;

import java.time.LocalDate;

import interfaces.Expirable;

public class ExpirableProducts extends Product implements Expirable {
    private LocalDate expiryDate;

    public ExpirableProducts(String name, double price, int quantity, LocalDate expiryDate){
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    @Override
    public LocalDate getExpiryDate(){
        return expiryDate;
    }

    @Override
    public void displayProduct() {
        super.displayProduct();
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("Expired: " + (isExpired() ? "Yes" : "No"));
    }


}
