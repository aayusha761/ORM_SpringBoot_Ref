package com.example.demo.services;

import com.example.demo.entity.Genres;

import java.util.List;

public interface GenreService {
    boolean save(Genres genres);

    List<Genres> findAllGenres();

    Genres findGenre(int id);
}
