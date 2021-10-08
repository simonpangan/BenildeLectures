package mvc.demo.model;

import java.io.Serializable;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;

import mvc.demo.utiliy.DBOperation;

public class GradeBean implements Serializable, DBOperation{

	private static final long serialVersionUID = 1L;

	//input values
	private String id;
	private String name;
	private double midterm;
	private double preFinal;
	
	//computed values
	private double finalGrade;
	private String remarks;
	
	public GradeBean()
	{
			
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMidterm() {
		return midterm;
	}

	public void setMidterm(double midterm) {
		this.midterm = midterm;
	}

	public double getPreFinal() {	
		return preFinal;
	}

	public void setPreFinal(double preFinal) {
		this.preFinal = preFinal;
	}
	public double getFinalGrade() {
		return finalGrade;
	}

	public String getRemarks() {
		return remarks;
	}
	
	public void computeFinalGrade() {
		this.finalGrade = (preFinal + midterm) / 2;
	}

	public void determineRemarks() {
		if (this.finalGrade >= 75) {
			this.remarks =  "Passed";
		} else {
			this.remarks = "Failed";
		}
	}
		
	//JDBC related operation
	//private only because the model can perform the connection
	//should not use by view and controller 
	private Connection getConnection() throws SQLException {
		
		Connection connection = null;
		try {

//			Context initContext = new InitialContext();
//			Context envContext  = (Context)initContext.lookup("java:/comp/env");
//			DataSource ds = (DataSource)envContext.lookup("jdbc/APPACVC");
//			connection = ds.getConnection();
	
			connection = 
					((DataSource)InitialContext.doLookup("java:/comp/env/jdbc/APPACVC"))
					.getConnection();
		
			if (connection != null) {
				System.out.println("Connection is valid");
			} else {
				System.err.println("connection is not valid");
			}
			
		} catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		} catch(NamingException sqle) {
			System.err.println(sqle.getMessage());
		} 
		return connection;
	}
	
	public boolean insertRecord() {
		boolean isSuccess = false;
		
		Connection connection = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false); 
			PreparedStatement prep;
			
			prep = connection.prepareStatement(DBOperation.INSERT_RECORD);
			prep.setString(1, this.id);
			prep.setString(2, this.name);
			prep.setDouble(3, this.midterm);
			prep.setDouble(4, this.preFinal);
			prep.setDouble(5, this.finalGrade);
			prep.setString(6, this.remarks);
			//now commit this to the database table
			prep.executeUpdate();
			connection.commit();
		
			isSuccess = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException sqle1) {
				System.err.println(sqle1.getMessage());
			}
		}
		return isSuccess; 
	}

	public ResultSet getAllRecords() {
	
		ResultSet records = null;
		
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement prep = 
					connection.prepareStatement(DBOperation.SELECT_ALL_RECORDS);
			
			records = prep.executeQuery();
			
			return records;
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException sqle1) {
				System.err.println(sqle1.getMessage());
			}
		}
		return records;
	}
}
