package com.epam.springdatademo.model;

import java.util.List;

public class BooksResponse {

    private List<Book> bookList;

    public BooksResponse(List<Book> bookList) {
        this.bookList = bookList;
    }
}
