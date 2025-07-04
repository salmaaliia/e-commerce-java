package products;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AvailableProducts {
    private List<Product> productList;

    public AvailableProducts(){
        productList = new ArrayList<>();
        productList.add(new ShippableExpirableProducts("Cheese", 150, 100, 200, LocalDate.of(2027, 10, 1)));

        productList.add(new ShippableProducts("TV", 1000, 20, 5000));

        productList.add(new Product("Mobile scratch cards", 10, 100));
    }

    public List<Product> getProductList() {
        return productList;
    }

}
