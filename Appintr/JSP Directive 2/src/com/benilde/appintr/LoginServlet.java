package com.benilde.appintr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginService auth = new DummyLoginAuth();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		if(username != null) username = ServletUtilities.filter(username);
		else username = "";

		String password = req.getParameter("password");
		if(password != null) password = ServletUtilities.filter(password);
		else password = "";
		
		HttpSession session = req.getSession();
		if(auth.login(username, password)) {
			// when user is successfully authenticated, store username
			// in session, and redirect to the main page
			session.setAttribute("username", username);
			resp.sendRedirect("main.jsp");
		}
		else {
			// if invalid username/password, store error message in session
			// and redirect back to the login page
			session.setAttribute("errorMessage", "Invalid user name/password.");
			resp.sendRedirect("login.jsp");
		}
	}

}
