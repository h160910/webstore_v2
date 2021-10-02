package hvl.dat152.services;

import hvl.dat152.database.ProductDAO;
import hvl.dat152.model.Cart;
import hvl.dat152.model.Product;

import java.util.List;

public class ProductService {

    private final ProductDAO productDAO = new ProductDAO();

    public void addProductToCart(Cart cart, int id) {
        Product p = productDAO.getProduct(id);
        cart.addProduct(p);
    }

    public List<Product> getProductList() {
        return productDAO.getProductList();
    }

}
