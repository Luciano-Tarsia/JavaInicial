package com.deg.peliculasservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.deg.peliculasservice.service.PeliculasService;

import com.deg.peliculasservice.model.Pelicula;


@RequestMapping("/api/peliculas")
@RestController
public class PeliculasController {
	
    private final PeliculasService movieService;

    @Autowired
    public PeliculasController(PeliculasService movieService) {
        this.movieService = movieService;
    }
    
    @GetMapping
    public Pelicula[] getAllMovies() {
        return movieService.getAllMovies();
    }
    
    @PostMapping
    public int addMovie(@RequestBody Pelicula movie) {
        return movieService.addMovie(movie);
    }
    
    @DeleteMapping(path= "{id}")
    public int deleteMovie(@PathVariable("id") Integer id) {
        return movieService.deleteMovie(id);
    }

    @PatchMapping(path= "{id}")
    public int updateMovieById(@PathVariable("id") Integer id, Pelicula movie) {
        return movieService.updateMovieById(id, movie);
    }

    @DeleteMapping
    public int deleteAllMovies() {
        return movieService.deleteAllMovies();
    }

    @GetMapping(path= "{id}")
    public Pelicula getMovieById(@PathVariable("id") Integer id) {
        return movieService.getMovieById(id);
    } 

}

