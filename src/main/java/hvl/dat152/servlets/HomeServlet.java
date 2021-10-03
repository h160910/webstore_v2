package hvl.dat152.servlets;

import hvl.dat152.model.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;
import java.util.Locale;

@WebServlet(name="HomeServlet", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {

    private static final int COOKIE_MAX_AGE = 365 * 24 * 60 * 60; // one year in seconds
    private static final Cart cart = new Cart();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Get cookies
        Cookie[] cookies = request.getCookies();

        // Check if cookie for locale exists
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("locale")) {
                    // Set locale from cookie
                    Config.set(request.getSession(), Config.FMT_LOCALE, cookie.getValue());
                }
            }
        } else {
            // If no cookie found, get locale from HTTP request
            Locale locale = request.getLocale();

            Config.set(request.getSession(), Config.FMT_LOCALE, locale.getLanguage());

            // Create new cookie with locale
            Cookie localeCookie = new Cookie("locale", locale.getLanguage());
            localeCookie.setMaxAge(COOKIE_MAX_AGE);
            response.addCookie(localeCookie);
        }

        // Create cart and saves it to the Session object
        request.getSession().setAttribute("cart", cart);

        request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
    }
}
