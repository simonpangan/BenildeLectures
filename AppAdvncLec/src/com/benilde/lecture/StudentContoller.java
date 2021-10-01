package com.benilde.lecture;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class StudentContoller {

	private List<Student> students;
	private StudentDBUtil studentDBUtil;
	private Logger logger = Logger.getLogger(getClass().getName());

	public StudentContoller() throws Exception {
		students = new ArrayList<>();
			
		studentDBUtil = StudentDBUtil.getInstance();
	}
	
	public List<Student> getStudents() {
		return students;
	}
	
	public void loadStudents()
	{
		logger.info("Loading students");
		students.clear();
		
		try
		{
             // get all students from database
              students = studentDBUtil.getStudents();
            
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
