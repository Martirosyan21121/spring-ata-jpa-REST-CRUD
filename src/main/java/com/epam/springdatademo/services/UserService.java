package com.epam.springdatademo.services;

import com.epam.springdatademo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {

    User getUserById(Long id);

    List<User> getAllUser();

    User saveUser(User user);

    User updateUser(User user);

    String deleteUser(Long id);
}
