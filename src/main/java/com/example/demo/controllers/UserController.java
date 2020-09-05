package com.example.demo.controllers;

import com.example.demo.entity.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/add")
    public String addUser(@RequestBody User user) {
        System.out.println(user.getEmail());

        if (userService.save(user))
            return "User added successfully";
        else
            return "User already exists";
    }

    @GetMapping("/user/all")
    public List<User> fetchAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/user")
    public User findUser(@RequestParam int id) {
        return userService.findUser(id);
    }

    @PostMapping("/user/addBook")
    public void addBooks(@RequestParam int userId, @RequestParam int bookId) {
        userService.addBookToUser(userId, bookId);
    }

}
