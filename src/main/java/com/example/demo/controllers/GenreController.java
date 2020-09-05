package com.example.demo.controllers;

import com.example.demo.entity.Genres;
import com.example.demo.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GenreController {

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping("/genre/add")
    public String addGenre(@RequestBody Genres genres) {
        if (genreService.save(genres))
            return "Genre added";
        return "Genre Already exists";
    }

    @GetMapping("/genre/all")
    public List<Genres> fetchAll() {
        return genreService.findAllGenres();
    }

    @PostMapping("/genre")
    public Genres getGenre(@RequestParam int id) {
        return genreService.findGenre(id);
    }
}