package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books_table")
public class Books {

    @Id
    private int bookId;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "book", cascade = CascadeType.MERGE)
    private List<BooksGenre> booksGenre;

    public Books() {

    }


    public String getName() {
        return name;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Books(int bookId, String name, User user) {
        this.bookId = bookId;
        this.name = name;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<BooksGenre> getBooksGenre() {
        return booksGenre;
    }

    public void setBooksGenre(List<BooksGenre> booksGenre) {
        this.booksGenre = booksGenre;
    }
}
