package hvl.dat152.servlets;

import hvl.dat152.services.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;

@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {

    ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        var obj = Config.get(request.getSession(), Config.FMT_LOCALE); // "xx_XX"
        Locale currentLocale = productService.createLocale(obj);

        // Get the pricelist (String)
        HashMap<Integer, String> pricelist = productService.getProductListWithCurrency(currentLocale);
        request.getSession().setAttribute("pricelist", pricelist);

        request.getRequestDispatcher("WEB-INF/cart.jsp").forward(request, response);
    }
}
