package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        long sessionLastAccessedTime = session.getLastAccessedTime();
        String time = Long.toString(sessionLastAccessedTime);

        resp.addCookie(new Cookie("Last_server_call", time));
        resp.getWriter().write("Cookies:\n");
        /* Arrays.stream(req.getCookies())
                .forEach(System.out::println);
        .map(cookie -> {
                    String cookies = "Name: " + cookie.getName() + " Value: " + cookie.getValue();
                    return  cookies;
                })*/

        Cookie[] cookies = req.getCookies();
        if(cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie=cookies[i];
                String cookieName = cookie.getName();
                String cookieValue = cookie.getValue();
                resp.getWriter().write(cookieName+" "+ cookieValue+'\n');
            }
        }
    }
}
