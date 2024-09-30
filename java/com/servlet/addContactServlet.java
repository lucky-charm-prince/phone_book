package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.entity.Contact;
import com.entity.User;

@WebServlet("/addContact")
public class addContactServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String contact=req.getParameter("contact");
	int userId= Integer.parseInt(req.getParameter("userId")); 
	
	    Contact c= new Contact(name,email,contact,userId);
	    
	    UserDao dao= new UserDao();
	    HttpSession session=req.getSession();
	    if(dao.addContact(c))
	    {
	          session.setAttribute("addMsg", "Add Contact Success-fully");
	          resp.sendRedirect("addContact.jsp");
	    }
	    else
	    {
	    	
	        session.setAttribute("notMsg", "not Add Contact ");
	          resp.sendRedirect("addContact.jsp");	
	    }
	    
		
		
		
	}
  
	
	
}
