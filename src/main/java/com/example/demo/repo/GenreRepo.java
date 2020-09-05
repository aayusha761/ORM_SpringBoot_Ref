package com.example.demo.repo;

import com.example.demo.entity.Genres;

import javax.transaction.Transactional;
import java.util.List;

public interface GenreRepo {
    @Transactional
    void save(Genres genres);

    Genres findBy(int id);

    List<Genres> findAllGenres();

    boolean exists(String name);
}
