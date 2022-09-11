package com.tms.prudnik.servlets;

import com.tms.prudnik.dto.Book;
import com.tms.prudnik.repository.BookDBRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/init", loadOnStartup = 1)
public class InitServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        BookDBRepository.repository = BookDBRepository.getInstance();
        BookDBRepository.repository.appendBook(new Book("Тигровый, черный, золотой","Елена Михалкова",120));
        BookDBRepository.repository.appendBook(new Book("Медвежатница","Борис Акунин",421));
        BookDBRepository.repository.appendBook(new Book("В отсутствие начальства","Николай Свечин",350));
        BookDBRepository.repository.appendBook(new Book("Имя шторма","Марина Суржевская",670));
        BookDBRepository.repository.appendBook(new Book("Приключения бодхисаттвы","Неизвестно",502));

    }
}
