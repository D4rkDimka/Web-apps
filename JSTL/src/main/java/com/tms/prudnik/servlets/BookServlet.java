package com.tms.prudnik.servlets;

import com.tms.prudnik.dto.Book;
import com.tms.prudnik.repository.BookDBRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/bookslibrary")
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDBRepository.repository = BookDBRepository.getInstance();
        List<Book> books = BookDBRepository.repository.getBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDBRepository repository = BookDBRepository.getInstance();
        String bookNameToDelete = req.getParameter("bookname");
        Book deleteBook =  repository.getBooks()
                .stream()
                .filter(book -> book.getName().equals(bookNameToDelete))
                .findFirst().orElse(null);
        repository.deleteBook(deleteBook);

        List<Book> books = BookDBRepository.repository.getBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
