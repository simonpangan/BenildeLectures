package com.benilde.lecture;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Movies {
	
	private int id;
	private String title;
	private String description;
	private String directors;
	private String actors;
	private String genre;
	private String yearpublished;
	
	

	public Movies(int id,String title,String description,String directors,String actors,String genre ,String yearpublished){
		
	 this.id=id;
	 this.title=title;
	 this.description=description;
	 this.directors=directors;
	 this.actors=actors;
	 this.genre=genre;
	 this.yearpublished =yearpublished;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getDirectors() {
		return directors;
	}


	public void setDirectors(String directors) {
		this.directors = directors;
	}


	public String getActors() {
		return actors;
	}


	public void setActors(String actors) {
		this.actors = actors;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getYearpublished() {
		return yearpublished;
	}


	public void setYearpublished(String yearpublished) {
		this.yearpublished = yearpublished;
	}



}
