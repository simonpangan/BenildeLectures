package mvc.demo.model;

import java.io.Serializable;

public class GradeBean implements Serializable{

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
		this.finalGrade = preFinal + midterm;
	}

	public void determineRemarks() {

		if (this.finalGrade >= 75) {
			this.remarks =  "Passed";
		} else {
			this.remarks = "Failed";
		}
		
	}
		
}
