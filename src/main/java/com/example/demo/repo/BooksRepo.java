package com.example.demo.repo;

import com.example.demo.entity.Books;
import com.example.demo.entity.BooksGenre;

import javax.transaction.Transactional;
import java.util.List;

public interface BooksRepo {
    @Transactional
    abstract void save(Books books);

    @Transactional
    void saveBookGenre(BooksGenre booksGenre);

    abstract Books findBy(int id);

    abstract List<Books> findAllBooks();

    boolean exists(int id);
}
