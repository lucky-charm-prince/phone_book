package com.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.dbConnection.dbConnection;
import com.entity.User;

@WebServlet("/register")
public class registerServlet extends HttpServlet {
  

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	
	String name=req.getParameter("name"); 
	String email=req.getParameter("email");
	String password=req.getParameter("password"); 
	User u= new User(name,email,password);
	HttpSession session=req.getSession();
	
	try {
		
		UserDao dao= new UserDao();
		
		if(dao.userRegister(u))
		{
			session.setAttribute("success", "Register SuccessFully");
			System.out.println("User register success fully");
			resp.sendRedirect("register.jsp");
		}
		else 
		{
			session.setAttribute("error", "something went wrong");
			System.out.println("Something went wrong");
			resp.sendRedirect("register.jsp");
			
		}
		
		 
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
}
  
  
}
