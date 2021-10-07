package mvc.demo.model;

import java.io.Serializable;
import java.sql.*;

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
			//perform JDBC Driver enrollment
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/appadvc"
					,"root" ,"" );
			
			if (connection != null) {
				System.out.println("Connection is valid");
			} else {
				System.err.println("connection is not valid");
			}
			
		} catch(ClassNotFoundException cfne) {
			System.err.println(cfne.getMessage());
		} catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
		}
		return connection;
	}
	
	public boolean insertRecord() {
		boolean isSuccess = false;
		
		try {
			Connection connection = getConnection();
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
			isSuccess = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isSuccess; 
	}
}
