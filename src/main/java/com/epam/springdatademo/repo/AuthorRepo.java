package com.epam.springdatademo.repo;


import com.epam.springdatademo.model.Author;
import com.epam.springdatademo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepo extends JpaRepository<Author, Long> {

    @Query(value = "SELECT * from Book where Book.author_id=:authorId", nativeQuery = true)
    List<Book> findBooksByAuthor (Long authorId);

}
