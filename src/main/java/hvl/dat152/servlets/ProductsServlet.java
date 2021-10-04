package hvl.dat152.servlets;

import hvl.dat152.model.Cart;
import hvl.dat152.model.Product;
import hvl.dat152.services.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "ProductsServlet", urlPatterns = "/products")
public class ProductsServlet extends HttpServlet {

    ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        var obj = Config.get(request.getSession(), Config.FMT_LOCALE); // "xx_XX"
        Locale currentLocale = productService.createLocale(obj);

        HashMap<Integer, String> pricelist = productService.getProductListWithCurrency(currentLocale);
        request.getSession().setAttribute("pricelist", pricelist);

        List<Product> productlist = productService.getProductList();
        request.setAttribute("productlist", productlist);

        request.getRequestDispatcher("WEB-INF/products.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get product from button (value)
        int pid = Integer.parseInt(request.getParameter("pid"));

        // Get cart from session
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        // Add product to cart
        productService.addProductToCart(cart, pid);

        response.sendRedirect("cart");
    }
}
