package com.example.demo.repo;

import com.example.demo.entity.User;

import java.util.List;

public interface UserRepo {
    void save(User user);

    User findBy(int id);

    abstract List<User> findAllUsers();

    boolean exists(String email);
}
