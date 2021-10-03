package hvl.dat152.database;

import hvl.dat152.model.Product;

import java.util.Arrays;
import java.util.List;

public class ProductDAO {

    private final static String baseUrl = "/webstore/ProductImages";
    private final List<Product> productList;

    public ProductDAO() {
        productList = Arrays.asList(
                new Product(32, "White Cup", 8899999.50, baseUrl+"/whitecup.jpg"),
                new Product(33, "Black Cup", 3.50, baseUrl+"/blackcup.jpg"),
                new Product(21, "Doctor Who Cup", 7.50, baseUrl+"/doctorwho.jpg"),
                new Product(65, "Swan Cup", 12.99, baseUrl+"/swan.jpg")
                );
    }

    // returns null if products is empty or no product with specified id is found
    public Product getProduct(int pid) {
        return productList.stream().filter(p -> p.getPid() == pid).findAny().orElse(null);
    }

    public List<Product> getProductList() {
        return productList;
    }
}
