package hvl.dat152.servlets;

import hvl.dat152.database.ProductDAO;
import hvl.dat152.model.Cart;
import hvl.dat152.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductsServlet", urlPatterns = "/products")
public class ProductsServlet extends HttpServlet {

    ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productDAO.getProductList();
        request.setAttribute("productlist", productList);

        request.getRequestDispatcher("WEB-INF/products.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get product from button (value)
        int pid = Integer.parseInt(request.getParameter("pid"));

        // Get cart from session
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        // Add product to cart
        cart.addProduct(productDAO.getProduct(pid));

        response.sendRedirect("cart");
    }
}
