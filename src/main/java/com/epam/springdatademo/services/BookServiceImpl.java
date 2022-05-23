package com.epam.springdatademo.services;

import com.epam.springdatademo.exeptions.ResourceNotFound;
import com.epam.springdatademo.model.Book;
import com.epam.springdatademo.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
  private final BookRepo bookRepo;

  @Autowired
  public BookServiceImpl(BookRepo bookRepo) {
    this.bookRepo = bookRepo;
  }

  @Override
  public Book getBookById(Long id) {
    return bookRepo.findById(id).orElseThrow(ResourceNotFound::new);
  }

  @Override
  public List<Book> getAllBook() {
    return bookRepo.findAll();
  }

  @Override
  public Book saveBook(Book book) {
    bookRepo.save(book);
    return book;
  }

  @Override
  public Book updateBook(Book book) {
    Book book1 = bookRepo.findById(book.getId()).orElse(null);
    book1.setName(book.getName());
    book1.setReleaseDate(book.getReleaseDate());
    book1.setAuthor(book.getAuthor());
    return bookRepo.save(book);
  }

  @Override
  public String deleteBook(Long id) {
    bookRepo.deleteById(id);
    return "Book removed !!!" + id;
  }
}
