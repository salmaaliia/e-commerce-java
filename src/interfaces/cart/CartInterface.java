package interfaces.cart;

import model.product.Product;

public interface CartInterface {
    public boolean addToCart(Product product, int amount);
    public boolean addToCart(String productName, int amount);
    public boolean removeFromCart(Product product, int amount);
    public boolean removeFromCart(String productName, int amount);

}
