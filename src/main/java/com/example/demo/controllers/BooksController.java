package com.example.demo.controllers;

import com.example.demo.entity.Books;
import com.example.demo.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {

    private final BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @PostMapping("/books/add")
    public String addBooks(@RequestBody Books books) {
        if (booksService.save(books))
            return "Book added";
        return "Book Already exists";
    }

    @GetMapping("/books/all")
    public List<Books> fetchAll() {
        return booksService.findAllBooks();
    }

    @PostMapping("/books")
    public Books getBook(@RequestParam int id) {
        return booksService.findBook(id);
    }

    @PostMapping("books/addGenre")
    public void addGenre(@RequestParam int bookId, @RequestParam int genreId) {
        booksService.addBookGenre(bookId, genreId);
    }
}
