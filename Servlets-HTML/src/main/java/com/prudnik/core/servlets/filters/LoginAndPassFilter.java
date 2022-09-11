package com.prudnik.core.servlets.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginAndPassFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if ((login != null && login.isEmpty() == false) && password != null && password.isEmpty() == false) {
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            request.getRequestDispatcher("/loginPage.html").forward(request,response);
        }
    }
}
