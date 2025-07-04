package products;

import interfaces.Shippable;

public class ShippableProducts extends Product implements Shippable {
    private double weight;

    public ShippableProducts(String name, double price, int quantity, double weight){
        super(name, price, quantity);
        this.weight = weight;
    }

    public double getWeight(){
        return weight;
    }

    @Override
    public String getName(){
        return super.getName();
    }

    @Override
    public void displayProduct() {
        super.displayProduct();
        System.out.println("Weight: " + weight);
    }

}
