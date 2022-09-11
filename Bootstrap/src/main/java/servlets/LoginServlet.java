package servlets;

import dao.DBRepository;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    private DBRepository repository = DBRepository.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String gitName = req.getParameter("gitname");

        resp.getWriter().write(username+" " + email+" " + password+ " " + gitName);
        User user = new User(username,email,password,gitName);

        if(repository.existingTest(user) == true){
            req.getRequestDispatcher("userpage.html").forward(req,resp);
        }

    }
}
