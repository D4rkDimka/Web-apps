package servlet;

import dao.BookRepository;
import entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/library")
public class BookServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookRepository repository = BookRepository.getInstance();
        List<Book> internalBookLibrary = new ArrayList<>();
        List<Book> externalBookLibrary = repository.getBooks();

        HttpSession session = req.getSession();

        if (externalBookLibrary == null) {
            internalBookLibrary.add(new Book("Куриный бульон для души", "Джек Кенфилд", 120));
            internalBookLibrary.add(new Book("1000 и 1 история жизни", "Дэвид Скварс", 251));
            internalBookLibrary.add(new Book("45 оттенков зеленого", "Аля Самохина", 150));
            internalBookLibrary.add(new Book("Беги до конца", "Ренат Шагабутдинов", 912));
            internalBookLibrary.add(new Book("Питание в спорте на выносливость", "Мэт Фиджеральд", 171));
            session.setAttribute("books", internalBookLibrary);
            session.setAttribute("amount", internalBookLibrary.size());
            getServletContext().getRequestDispatcher("/books.jsp").forward(req, resp);
        } else {
            session.setAttribute("books", externalBookLibrary);
            session.setAttribute("amount", externalBookLibrary.size());
            getServletContext().getRequestDispatcher("/books.jsp").forward(req, resp);
        }

    }
}
