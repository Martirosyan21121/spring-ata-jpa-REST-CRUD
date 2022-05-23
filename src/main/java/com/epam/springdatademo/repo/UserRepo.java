package com.epam.springdatademo.repo;

import com.epam.springdatademo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
