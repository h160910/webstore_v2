package hvl.dat152.model;

import java.util.HashMap;

public class Cart {

    // Stores the unique items and how many of them there are in the cart
    private final HashMap<Product, Integer> content;

    public Cart() {
        this.content = new HashMap<>();
    }

    // Will increment value if the product exists in map
    // Will put the new product in map if it does not already exist (quantity will be 1)
    public void addToCart(Product product) {
        if(content.containsKey(product)) {
            content.put(product, content.get(product) + 1);
        } else {
            content.put(product, 1);
        }
    }

    public HashMap<Product, Integer> getContent() {
        return content;
    }

}