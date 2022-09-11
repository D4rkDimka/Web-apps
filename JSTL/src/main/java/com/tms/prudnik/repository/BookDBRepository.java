package com.tms.prudnik.repository;

import com.tms.prudnik.dto.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDBRepository {
    private List<Book> books = new ArrayList<>();
    public static BookDBRepository repository = null;

    private BookDBRepository() {
    }

    public static BookDBRepository getInstance() {
        if (repository != null) {
            return repository;
        } else {
            synchronized (BookDBRepository.class) {
                if (repository == null) {
                    repository = new BookDBRepository();
                }
            }
            return repository;
        }
    }

    public void appendBook(Book book) {
        books.add(book);
    }

    public Book isExist(String bookName) {
        Book foundBook = new Book();

        for (Book book : books) {
            if (book.getName().equals(bookName)) {
                foundBook = book;
            }
        }
        return foundBook;
    }




    public void deleteBook(Book book) {
        books.remove(book);
    }

    public List<Book> getBooks() {
        if (books.size() != 0) {
            return books;
        } else {
            throw new RuntimeException();
        }
    }
}
