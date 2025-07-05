package services.shipping;

import interfaces.product.Shippable;

public class ShippableItem implements Shippable {
    private String name;
    private double weight;

    public ShippableItem(String name, double weight){
        this.name = name;
        this.weight = weight;
    }

    @Override
    public double getWeight(){
        return weight;
    }
    @Override
    public String getName(){
        return name;
    }
}
