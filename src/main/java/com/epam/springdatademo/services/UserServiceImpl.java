package com.epam.springdatademo.services;

import com.epam.springdatademo.model.User;
import com.epam.springdatademo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl (UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User saveUser(User user) {
        userRepo.save(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        User user1 = userRepo.findById(user.getId()).orElse(null);
        user1.setName(user.getName());
        user1.setSurname(user.getSurname());
        user1.setPhoneNumber(user.getPhoneNumber());
        user1.setPassword(user.getPassword());
        return userRepo.save(user1);
    }

    @Override
    public String deleteUser(Long id) {
        userRepo.deleteById(id);
        return "User removed !!!" + id;
    }
}
