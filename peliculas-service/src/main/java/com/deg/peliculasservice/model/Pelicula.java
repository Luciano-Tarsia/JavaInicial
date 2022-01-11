package com.deg.peliculasservice.model;

public class Pelicula {
    private Integer id;
    private String name;
    private String director;
    
    public Pelicula() {};
    
    public Pelicula(Integer id, String name, String director) {
    	this.id = id;
    	this.name = name;
    	this.director = director;
    }
    
    public Integer getId() {
    	return this.id;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public String getDirector() {
    	return this.director;
    }

}
