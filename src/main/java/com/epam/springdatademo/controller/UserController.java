package com.epam.springdatademo.controller;

import com.epam.springdatademo.model.User;
import com.epam.springdatademo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/getUser")
    public List<User> findAllUsers(){
        return userService.getAllUser();
    }

    @GetMapping("/getUsersById/{id}")
    public User user(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }
}
