package com.example.demo.services;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    boolean save(User user);

    void addBookToUser(int userId, int bookId);

    List<User> findAll();

    User findUser(int id);
}
