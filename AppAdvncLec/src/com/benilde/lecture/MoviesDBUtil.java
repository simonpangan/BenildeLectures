package com.benilde.lecture;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MoviesDBUtil {
	
	private static MoviesDBUtil instance;
	private DataSource dataSource;
	private String jndiName = "java:comp/env/jdbc/moviesdb";
	
	public static MoviesDBUtil getInstance() throws Exception
	{
		if(instance == null)
		{
			instance = new MoviesDBUtil();
		}
		
		return instance;
	}

	private MoviesDBUtil() throws Exception
	{
		dataSource = getDataSource();
	}
	
	private DataSource getDataSource() throws NamingException
	{
		Context context = new InitialContext();
		DataSource theDataSource = (DataSource) context.lookup(jndiName);
		return theDataSource;
	}
	
	public List<Movies> getMovies() throws Exception
	{
		List<Movies> movie = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try
		{
			myConn = getConnection();
			String sql = "select * from tblmovies";
			
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);
			
			//process results
			while (myRs.next())
			{
				//get data from result set row
				int id = myRs.getInt("ID");
				String Title  = myRs.getString("Title");
				String Desciption  = myRs.getString("Desciption");
				String Director = myRs.getString("Director");
				String Actors = myRs.getString("Actors");
				String Genre = myRs.getString("Genre");
				String YearPublished = myRs.getString("YearPublished");
				
				//create student object
				Movies moviestemp = new Movies(id, Title, Desciption, Director,Actors, Genre, YearPublished);
				
				//add it to the list of students
				movie.add(moviestemp);
			}
			
	
			
			return movie;
			
		}
		
		finally
		{
			//clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}
	
	private Connection getConnection() throws Exception {

		Connection theConn = dataSource.getConnection();
		
		return theConn;
	}
	
	private void close(Connection theConn, Statement theStmt, ResultSet theRs) {

		try {
			if (theRs != null) {
				theRs.close();
			}

			if (theStmt != null) {
				theStmt.close();
			}

			if (theConn != null) {
				theConn.close();
			}
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}	
}
