package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.dbConnection.dbConnection;
import com.entity.Contact;

@WebServlet("/searchContact")
public class searchServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String s=req.getParameter("search");
		
		
	  int userId=Integer.parseInt(req.getParameter("u"));
	  
	  dbConnection conn=new dbConnection();
	  
	  UserDao dao= new UserDao(conn.getConnection());
	  List<Contact> list = new ArrayList<Contact>();
	  HttpSession session=req.getSession();
	  list =dao.searchContact(userId, s);
	  
	  if(list!=null)
	  {
		  
		session.setAttribute("seMsg", list);
		
		resp.sendRedirect("searchContact.jsp");
	  }
	  else 
	  {
		
		  session.setAttribute("senMsg","Something went wrong search not perform");
		 resp.sendRedirect("viewContact.jsp");
	  }
	  
	  
	}

	
}
