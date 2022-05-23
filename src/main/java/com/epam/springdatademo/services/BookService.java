package com.epam.springdatademo.services;

import com.epam.springdatademo.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {


    Book getBookById(Long id);

    List<Book> getAllBook();

    Book saveBook(Book book);

    Book updateBook(Book book);

    String deleteBook(Long id);
}
