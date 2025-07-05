package model.product;

import java.time.LocalDate;

import interfaces.product.Expirable;

public class ExpirableProduct extends Product {
    private LocalDate expiryDate;

    public ExpirableProduct(String name, double price, int quantity, LocalDate expiryDate){
        super(name, price, quantity);
        this.expiryDate = expiryDate;

        this.expirable = new Expirable() {
        @Override
        public LocalDate getExpiryDate(){
            return expiryDate;
        }
        
    }; 
    
}

    /* 
    @Override
    public LocalDate getExpiryDate(){
        return expiryDate;
    }*/

    

    @Override
    public void displayProduct() {
        super.displayProduct();
        System.out.println("Expiry Date: " + expiryDate);
        System.out.println("Expired: " + (isExpired() ? "Yes" : "No"));
    }


}
