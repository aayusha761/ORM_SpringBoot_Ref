package com.example.demo.services;

import com.example.demo.entity.Books;
import com.example.demo.entity.BooksGenre;
import com.example.demo.entity.Genres;
import com.example.demo.repo.BooksRepo;
import com.example.demo.repo.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {
    private final BooksRepo booksRepo;

    @Autowired
    public BooksServiceImpl(BooksRepo booksRepo, GenreRepo genreRepo) {
        this.booksRepo = booksRepo;
        this.genreRepo = genreRepo;
    }

    private final GenreRepo genreRepo;

    @Override
    public boolean save(Books books) {
        if (!booksRepo.exists(books.getBookId())) {
            booksRepo.save(books);
            return true;
        }
        return false;
    }

    @Override
    public List<Books> findAllBooks() {
        return booksRepo.findAllBooks();
    }

    @Override
    public Books findBook(int id) {
        return booksRepo.findBy(id);
    }

    @Override
    public void addBookGenre(int bookId, int genreId) {
        Books book = booksRepo.findBy(bookId);
        Genres genre = genreRepo.findBy(genreId);

        BooksGenre booksGenre = new BooksGenre();
        List<BooksGenre> booksGenres = new ArrayList<>();
        booksGenres.add(booksGenre);

        book.setBooksGenre(booksGenres);
        booksGenre.setBook(book);
        genre.setBooksGenres(booksGenres);
        booksGenre.setGenres(genre);

        booksRepo.save(book);
        booksRepo.saveBookGenre(booksGenre);
        genreRepo.save(genre);

    }
}
