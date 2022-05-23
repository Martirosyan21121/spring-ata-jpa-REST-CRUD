package com.epam.springdatademo.controller;

import com.epam.springdatademo.model.Book;
import com.epam.springdatademo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "book")
public class BookController {


    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @GetMapping("/getBook")
    public List<Book> findAllBooks(){
        return bookService.getAllBook();
    }

    @GetMapping("/getBooksById/{id}")
    public Book book(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @PutMapping("/updateBook")
    public Book updateAuthor(@RequestBody Book book){
        return bookService.updateBook(book);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        return bookService.deleteBook(id);
    }

}
