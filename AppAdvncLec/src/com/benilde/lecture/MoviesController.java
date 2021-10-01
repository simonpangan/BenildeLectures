package com.benilde.lecture;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class MoviesController {

	private List<Movies> movies;
	private MoviesDBUtil moviesDBUtil;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	public MoviesController() throws Exception {
		movies = new ArrayList<>();
			
		moviesDBUtil = MoviesDBUtil.getInstance();
	}
	
	public List<Movies> getMovies() {
		return movies;
	}
	
	public void loadMovies()
	{
		logger.info("Loading movies");
		movies.clear();
		
		try
		{
             // get all students from database
			movies = moviesDBUtil.getMovies();
            
		}
		catch(Exception ex)
		{
			// add error message for JSF page
			addErrorMessage(ex);
		}
	}
	
	
	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
