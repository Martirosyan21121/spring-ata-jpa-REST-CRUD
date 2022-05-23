package com.epam.springdatademo.controller;

import com.epam.springdatademo.model.Author;
import com.epam.springdatademo.model.Book;
import com.epam.springdatademo.model.BooksResponse;
import com.epam.springdatademo.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

  private final AuthorService authorService;

  @Autowired
  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  @GetMapping(value = "/{authorId}/books", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<BooksResponse> getBooksByAuthor(@PathVariable Long authorId) {
    List<Book> allBookByAuthor = authorService.findAllBookByAuthor(authorId);
    return ResponseEntity.ok(new BooksResponse(allBookByAuthor));
  }

  @PostMapping("/addAuthor")
  public Author addAuthor(@RequestBody Author authors){
    return authorService.saveAuthor(authors);
  }

  @GetMapping("/getAuthors")
  public List<Author> findAllAuthors(){
    return authorService.getAllAuthor();
  }

  @GetMapping("/getAuthorsById/{id}")
  public Author authors(@PathVariable Long id){
    return authorService.getById(id);
  }

  @PutMapping("/updateAuthor")
  public Author updateAuthor(@RequestBody Author authors){
    return authorService.updateAuthor(authors);
  }
@DeleteMapping("/delete/{id}")
  public String deleteAuthor(@PathVariable Long id){
    return authorService.deleteAuthor(id);
  }
}
