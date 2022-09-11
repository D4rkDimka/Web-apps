package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;

@WebServlet(value = "/*")
public class ServletFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String method = request.getMethod();

        if ("GET".toUpperCase(Locale.ROOT).equals(method)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();

                if (headerName.isEmpty() && headerName == null) {
                    System.out.println("Request is empty!");
                  throw new ServletException();
                }
                else{
                    filterChain.doFilter(servletRequest,servletResponse);
                }
            }
        }
    }
}
