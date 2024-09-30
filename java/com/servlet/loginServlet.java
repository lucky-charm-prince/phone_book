package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.entity.User;

@WebServlet("/login")
public class loginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		User u= new User();
		u.setEmail(email);
		u.setPassword(password);
		UserDao dao= new UserDao();
		 u=dao.login(u);
		 HttpSession session= req.getSession();
		 System.out.println(u.getId()+" "+u.getName()+" "+u.getEmail()+" "+u.getPassword());
		 if(u.getId()!=0)
		 {
			session.setAttribute("user", u); 
			 resp.sendRedirect("index.jsp");
		 }
		 else 
		 {
			 System.out.println("Invalid user email or password");
			 session.setAttribute("error","Invalid email or password");
			 resp.sendRedirect("login.jsp");
			 
		 }
		
		
	}
	
	

}
