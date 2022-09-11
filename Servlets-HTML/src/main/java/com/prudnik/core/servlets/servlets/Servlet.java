package com.prudnik.core.servlets.servlets;

import com.prudnik.core.servlets.database.DBService;
import com.prudnik.core.servlets.users.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@WebServlet(value = "/login")
public class Servlet extends HttpServlet {
    private DBService dbService = new DBService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isExistUser = false;
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User.role role = dbService.roleIdentifier(login,password);

        if(role!= null && "ADMIN".toUpperCase(Locale.ROOT).equals(role.toString())){
            req.getRequestDispatcher("/adminPage.html").forward(req,resp);
        }
        else if(role!= null && "USER".toUpperCase(Locale.ROOT).equals(role.toString())){
            req.getRequestDispatcher("/userPage.html").forward(req,resp);
        }else{
            resp.getWriter().write("Invalid input!");
        }
    }
}
