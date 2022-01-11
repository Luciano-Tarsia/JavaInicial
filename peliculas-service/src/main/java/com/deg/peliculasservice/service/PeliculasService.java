package com.deg.peliculasservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.deg.peliculasservice.general.general;
import com.deg.peliculasservice.model.Pelicula;

@Service
public class PeliculasService {
	
	private final general movieDao;
	private Integer id = 0;
    
    @Autowired
    public PeliculasService(@Qualifier("FakeDao") general movieDao) {
        this.movieDao = movieDao;
    }

    public Pelicula[] getAllMovies() {
        return movieDao.selectAllMovies();
    }

    public int addMovie(Pelicula movie){
    	this.id = this.id + 1;
        return movieDao.insertMovie(this.id, movie);
    }

    public int deleteMovie(Integer id){
        return movieDao.deleteMovieById(id);
    }

    public int updateMovieById(Integer id, Pelicula movie){
        return movieDao.updateMovieById(id, movie);
    }

    public int deleteAllMovies(){
        return movieDao.deleteAllMovies();
    }

    public Pelicula getMovieById(Integer id){
        return movieDao.selectMovieById(id);
    }
	
}
