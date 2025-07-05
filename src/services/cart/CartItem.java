package services.cart;
import model.product.Product;
public class CartItem {
    private Product product;
    private int amount;

    public CartItem(Product product, int amount){
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public void changeAmount(int quantity){
        amount += quantity;
    }

    public void displayItem() {
        product.displayProduct();
        System.out.println("Quantity in cart: " + amount);
    }



}
