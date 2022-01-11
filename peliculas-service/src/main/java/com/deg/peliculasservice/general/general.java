package com.deg.peliculasservice.general;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import com.deg.peliculasservice.model.Pelicula;
import java.util.List;

@Repository("general")
public class general {

	private static List<Pelicula> movies = new ArrayList<>();
	
	public int insertMovie(Integer id, Pelicula movie) {
		movies.add(new Pelicula(id, movie.getName(), movie.getDirector()));
	    return 1;
	}

	public Pelicula selectMovieById(Integer id) {
		try {
			return movies.stream()
					.filter(movie -> movie.getId().equals(id))
	                .findFirst()
	                .get();
		} catch (Exception e) {
			return null;
	    } 
	}

	public int deleteMovieById(Integer id) {
		try {
			movies.removeIf(movie -> movie.getId().equals(id));
	        return 1;
	    } catch (Exception e) {
	    	return 0;
	    }
	}

	public int updateMovieById(Integer id, Pelicula movie) {
		try {
			for (int i = 0; i < movies.size(); i++) {
				if (movies.get(i).getId().equals(id)) {
					movies.set(i, new Pelicula(id, movie.getName(), movie.getDirector()));
	                return 1;
	            }
			}
	        return 0;
		} catch (Exception e) {
			return 0;
	    }
	}

	public int deleteAllMovies() {
		try {
			movies.clear();
	        return 1;
		} catch (Exception e) {
			return 0;
	    }
	}

	public Pelicula[] selectAllMovies() {
		try {
			return movies.toArray(new Pelicula[movies.size()]);
	    } catch (Exception e) {
	    	return null;
	    }
	}
	
}
