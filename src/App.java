import java.time.LocalDate;

import interfaces.Expirable;
import products.AvailableProducts;
import products.ExpirableProducts;
import products.Product;
import products.ShippableExpirableProducts;
import products.ShippableProducts;
import services.*;
public class App {
    public static void main(String[] args) throws Exception {
        AvailableProducts store = new AvailableProducts();
        
        for (Product p: store.getProductList()) {
            System.out.println(p.getName());
        }

        Cart cart = new Cart(store);
        Customer salma = new Customer(cart, 1000);

        salma.addToCart("Cheese", 5);
        salma.addToCart("TV", 1);



    }
}
