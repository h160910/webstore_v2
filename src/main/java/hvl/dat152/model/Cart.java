package hvl.dat152.model;

import hvl.dat152.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {

    private List<Product> cart;

    public Cart() {
        this.cart = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        cart.add(product);
    }

    public void removeProduct(int id) {
        cart.removeIf(product -> product.getPid() == id );
    }

    public List<Product> getCart() {
        return cart;
    }

    @Override
    public String toString() {
        return cart.stream().map(Product::toString).collect(Collectors.joining(" | ", "[", "]"));
    }
}
