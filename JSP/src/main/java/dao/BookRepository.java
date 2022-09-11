package dao;

import entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private List<Book> books;
    private static BookRepository bookRepository;

    private BookRepository() {
        books = new ArrayList<>();
        books.add(new Book("Куриный бульон для души", "Джек Кенфилд", 120));
        books.add(new Book("1000 и 1 история жизни", "Дэвид Скварс", 251));
        books.add(new Book("45 оттенков зеленого", "Аля Самохина", 150));
        books.add(new Book("Беги до конца", "Ренат Шагабутдинов", 912));
        books.add(new Book("Питание в спорте на выносливость", "Мэт Фиджеральд", 171));
    }

    public static BookRepository getInstance() {
        if (bookRepository == null) {
            synchronized (BookRepository.class) {
                if (bookRepository == null) {
                    bookRepository = new BookRepository();
                } else {
                    return bookRepository;
                }
            }
        }
        return bookRepository;
    }

    public List<Book> getBooks() {
        if (books != null) {
            return books;
        } else {
            throw new RuntimeException();
        }
    }
}
