package model.product;


import java.util.ArrayList;
import java.util.List;

public class AvailableProduct {
    private List<Product> productList;

    public AvailableProduct(){
        productList = new ArrayList<>();
    }
    public void addProductToStore(Product product){
        productList.add(product);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void listStoreProducts(){
        for (Product product : productList) {
            product.displayProduct();
        }
    }


}
