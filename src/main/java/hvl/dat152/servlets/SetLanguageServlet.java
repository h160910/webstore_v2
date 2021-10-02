package hvl.dat152.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;

@WebServlet("/SetLanguage")
public class SetLanguageServlet extends HttpServlet {

    private static final int COOKIE_MAX_AGE = 365 * 24 * 60 * 60; // one year in seconds

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String locale = request.getParameter("locale");

        if (locale != null) {
            Config.set(request.getSession(), Config.FMT_LOCALE, locale);

            Cookie localeCookie = new Cookie("locale", locale);
            localeCookie.setMaxAge(COOKIE_MAX_AGE); // one year
            response.addCookie(localeCookie);
        }

        String referrer = request.getHeader("referer");
        response.sendRedirect(referrer);
    }

}
