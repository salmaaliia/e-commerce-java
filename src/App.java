import java.time.LocalDate;

import interfaces.*;
import model.product.AvailableProduct;
import model.product.Product;
import model.product.ShippableExpirableProduct;
import model.product.ShippableProduct;
import model.user.Customer;
import services.*;
import services.cart.Cart;
public class App {
    public static void main(String[] args) throws Exception {

        // Provide Items to the store 
        AvailableProduct store = new AvailableProduct();
        ShippableExpirableProduct Biscuits = new ShippableExpirableProduct("shato", 25, 1, 150, LocalDate.of(2026, 2, 1));
        ShippableExpirableProduct cheese = new ShippableExpirableProduct("Cheese", 150, 100, 200, LocalDate.of(2027, 10, 1));
        ShippableProduct TV =  new ShippableProduct("TV", 1000, 20, 5000);
        Product mobileScratchCards =   new Product("Mobile scratch cards", 10, 100);

        store.addProductToStore(cheese);
        store.addProductToStore(TV);
        store.addProductToStore(mobileScratchCards);
        store.addProductToStore(Biscuits);
        
        /*for (Product p: store.getProductList()) {
            p.displayProduct();
            System.out.println();
        }*/

        // create new cart
        Cart cart = new Cart(store);
        // new customer with the cart and balance
        Customer salma = new Customer(cart, 10000);


        // Add and remove items from cart
        salma.addToMyCart("Cheese", 5);
        salma.addToMyCart("TV", 1);
        salma.addToMyCart("Shato", 2);
        salma.addToMyCart("Cheese", 2);
        salma.addToMyCart(Biscuits, 1);
        salma.addToMyCart(cheese, 1);
        salma.addToMyCart(mobileScratchCards, 2);
        
        salma.removeFromMyCart(cheese, 2);

        salma.viewMyCart();

        salma.checkout();

        salma.displayShippingList();
    }
}
