package services.shipping;

import java.util.ArrayList;
import java.util.List;

import interfaces.product.Shippable;
import model.product.Product;

public class ShippingService {
    private List<ShippableItem> shippingList;

    public ShippingService(){
        this.shippingList = new ArrayList<>();
    }

    public void addToList(Product product){
        ShippableItem item = new ShippableItem(product.getName(), product.getWeightIfAvailable());
        shippingList.add(item);
    }

    public List<ShippableItem> getShippingList(){
        return shippingList;
    }

    public void displayShippingList(){
        System.out.println("\n ** Your shipping list **");
        for (ShippableItem shippableItem : shippingList) {
            System.out.println(shippableItem.getName() + " weights " + shippableItem.getWeight());
        }
    }
}
