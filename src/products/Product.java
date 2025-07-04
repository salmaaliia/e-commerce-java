package products;


public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {return name;}
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void decreaseQuantity(int amount){
        if(quantity >= amount) quantity -= amount;
        else System.out.println("Not enough stock to decrease.");
    }
    public void increaseQuantity(int amount){
        quantity += amount;
    }

    public void displayProduct(){
        System.out.println("Product: " + name);
        System.out.println("Price: EGP " + price);
        System.out.println("Quantity: " + quantity);

    }

}

