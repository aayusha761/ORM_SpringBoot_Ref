package com.example.demo.services;

import com.example.demo.entity.Books;
import com.example.demo.entity.User;
import com.example.demo.repo.BooksRepo;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, BooksRepo booksRepo) {
        this.userRepo = userRepo;
        this.booksRepo = booksRepo;
    }

    private final BooksRepo booksRepo;

    @Override
    public boolean save(User user) {
        if (!userRepo.exists(user.getEmail())) {
            userRepo.save(user);
            return true;
        }
        return false;
    }

    @Override
    public void addBookToUser(int userId, int bookId) {
        User user = userRepo.findBy(userId);
        System.out.println("user "+user.getEmail());

        Books book = booksRepo.findBy(bookId);
        System.out.println("book "+book.getName());

        List<Books> books = new ArrayList<>();
        books.add(book);
        user.setBooks(books);
        book.setUser(user);
        userRepo.save(user);
        booksRepo.save(book);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAllUsers();
    }

    @Override
    public User findUser(int id) {
        return userRepo.findBy(id);
    }
}
