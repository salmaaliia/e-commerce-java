package interfaces;

public interface cartInterface {
    public boolean addToCart(String productName, int amount);
    public boolean removeFromCart(String productName, int amount);

}
