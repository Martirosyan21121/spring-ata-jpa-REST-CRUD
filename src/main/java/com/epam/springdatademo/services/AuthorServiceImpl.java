package com.epam.springdatademo.services;

import com.epam.springdatademo.exeptions.ResourceNotFound;
import com.epam.springdatademo.model.Author;
import com.epam.springdatademo.model.Book;
import com.epam.springdatademo.repo.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

  private final AuthorRepo authorRepo;

  @Autowired
  public AuthorServiceImpl(AuthorRepo authorRepo) {
    this.authorRepo = authorRepo;
  }

  @Override
  public Author getById(Long id) {
    return authorRepo.findById(id).orElseThrow(ResourceNotFound::new);
  }

  @Override
  public List<Author> getAllAuthor() {
    return authorRepo.findAll();
  }

  @Override
  public Author saveAuthor(Author author) {
    authorRepo.save(author);
    return author;
  }

  @Override
  public Author updateAuthor(Author author) {
    Author author1 = authorRepo.findById(author.getId()).orElse(null);
    author1.setName(author.getName());
    author1.setLastName(author.getLastName());
    author1.setBookSet(author.getBookSet());
    return authorRepo.save(author1);
  }

  @Override
  public String deleteAuthor(Long id) {
     authorRepo.deleteById(id);
     return "Author removed !!!" + id;
  }

  @Override
  public List<Book> findAllBookByAuthor(Long id) {
    return authorRepo.findBooksByAuthor(id);
  }
}
