package hvl.dat152.services;

import hvl.dat152.database.ProductDAO;
import hvl.dat152.model.Cart;
import hvl.dat152.model.Product;
import hvl.dat152.utils.CurrencyConverter;

import java.util.HashMap;
import java.util.Locale;

public class ProductService {

    private final ProductDAO productDAO = new ProductDAO();

    public void addProductToCart(Cart cart, int id) {
        Product p = productDAO.getProduct(id);
        cart.addProduct(p);
    }

    // Converts the prices of products to correct currency based on locale
    public HashMap<Integer, Object[]> getProductListWithCurrency(Locale locale) {
        HashMap<Integer, Object[]> pricelist = new HashMap<>();

        for (Product p : productDAO.getProductList()) {
            String localePrice = CurrencyConverter.convertToCurrencyString(locale, p.getPriceInEuros());

            Object[] values = new Object[2];
            values[0] = localePrice;
            values[1] = p.getImageFile();

            pricelist.put(p.getPid(), values);
        }

        return pricelist;
    }


    // Creates a locale based on the object retrieved from Config.FMT_LOCALE
    public Locale createLocale(Object obj) {

        String str = (String) obj; // "xx_XX"

        String language = str.substring(0,2); // "xx"
        String country = str.substring(3); // "XX"

        return new Locale(language, country);
    }

}
