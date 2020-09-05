package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genre_table")
@SequenceGenerator(name = "generator", sequenceName = "generator", allocationSize = 1)
public class Genres {

    @Id
    @GeneratedValue(generator = "generator")
    private int genreId;

    @Column
    private String name;

    @OneToMany(mappedBy = "genres", cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<BooksGenre> booksGenres;

    public Genres(int genreId, String name) {
        this.genreId = genreId;
        this.name = name;
    }

    public Genres() {

    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BooksGenre> getBooksGenres() {
        return booksGenres;
    }

    public void setBooksGenres(List<BooksGenre> booksGenres) {
        this.booksGenres = booksGenres;
    }
}
