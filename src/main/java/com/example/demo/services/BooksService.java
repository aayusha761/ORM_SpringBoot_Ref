package com.example.demo.services;

import com.example.demo.entity.Books;

import java.util.List;

public interface BooksService {
    boolean save(Books books);

    List<Books> findAllBooks();

    Books findBook(int id);

    void addBookGenre(int bookId, int genreId);
}
