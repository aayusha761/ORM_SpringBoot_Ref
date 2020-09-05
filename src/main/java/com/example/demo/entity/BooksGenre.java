package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "books_genre")
@SequenceGenerator(name = "generator", sequenceName = "generator", allocationSize = 1)
public class BooksGenre {

    @Id
    @GeneratedValue(generator = "generator")
    private int id;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Books book;

    @ManyToOne
    @JoinColumn
    private Genres genres;

    public BooksGenre() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public Genres getGenres() {
        return genres;
    }

    public void setGenres(Genres genres) {
        this.genres = genres;
    }
}