package com.sakshi.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.sakshi.dao.UserDao;
import com.sakshi.dao.UserDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static UserDao userDao = new UserDaoImpl();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        
					if (userDao.isValidUser(username, password)) {
					    HttpSession session = request.getSession();
					    session.setAttribute("username", username);
					    response.sendRedirect("welcome.jsp");
					    //System.out.println("Hi - "+username);
					} else {
					    response.sendRedirect("login.jsp?error=1");
						//System.out.println("Error A gya");
					}
				
		//doGet(request, response);
	}

}
