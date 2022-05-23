package com.epam.springdatademo.services;

import com.epam.springdatademo.model.Author;
import com.epam.springdatademo.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {

  Author getById(Long id);

  List<Author> getAllAuthor();

  Author saveAuthor(Author author);

  Author updateAuthor(Author author);

  String deleteAuthor(Long id);

  List<Book> findAllBookByAuthor(Long id);
}
