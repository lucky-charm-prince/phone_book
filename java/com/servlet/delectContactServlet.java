package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.dbConnection.dbConnection;
import com.entity.Contact;

@WebServlet("/delect")
public class delectContactServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub	
		int cid=Integer.parseInt(req.getParameter("cid"));
		System.out.println(cid);
		Contact c = new Contact();
		c.setId(cid);
		UserDao dao= new UserDao(dbConnection.getConnection());
		HttpSession session = req.getSession();
		if(dao.delectContact(cid))
		{
			
			
			resp.sendRedirect("viewContact.jsp");
		}
		else
		{
			resp.sendRedirect("addContact.jsp");
		}
		
	}

	
    
}
