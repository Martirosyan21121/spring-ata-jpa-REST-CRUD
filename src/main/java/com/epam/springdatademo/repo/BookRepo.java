package com.epam.springdatademo.repo;

import com.epam.springdatademo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {


}
