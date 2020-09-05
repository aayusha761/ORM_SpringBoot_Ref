package com.example.demo.services;

import com.example.demo.entity.Genres;
import com.example.demo.repo.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepo genreRepo;

    @Autowired
    public GenreServiceImpl(GenreRepo genreRepo) {
        this.genreRepo = genreRepo;
    }

    @Override
    public boolean save(Genres genres) {
        if (!genreRepo.exists(genres.getName())) {
            genreRepo.save(genres);
            return true;
        }
        return false;
    }

    @Override
    public List<Genres> findAllGenres() {
        return genreRepo.findAllGenres();
    }

    @Override
    public Genres findGenre(int id) {
        return genreRepo.findBy(id);
    }

}
