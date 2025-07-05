package model.product;

import interfaces.product.Shippable;

public class ShippableProduct extends Product {
    private double weight;

    public ShippableProduct(String name, double price, int quantity, double weight){
        super(name, price, quantity);
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
    }
    

    /* 
    public String getName(){
        return super.getName();
    }
        */


    @Override
    public void displayProduct() {
        super.displayProduct();
        System.out.println("Weight: " + weight);
    }
        

}
