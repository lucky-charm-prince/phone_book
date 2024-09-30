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

@WebServlet("/updateContact")
public class updateContactServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=req.getParameter("name");
		
		String email=req.getParameter("email");
		String contact=req.getParameter("contact");
		int cid=Integer.parseInt(req.getParameter("cid"));
		
		Contact c = new Contact();
		c.setName(name);
		c.setEmail(email);
		c.setContact(contact);
		c.setId(cid);
		  HttpSession session=req.getSession();
		UserDao dao= new UserDao(dbConnection.getConnection());
		  if(dao.updateContact(c))
		    {
		          session.setAttribute("upMsg", "Add Contact Success-fully");
		          resp.sendRedirect("viewContact.jsp");
		    }
		    else
		    {
		    	
		        session.setAttribute("nupMsg", "not Update Contact ");
		          resp.sendRedirect("editcontact.jsp?cid="+cid);	
		    }
		    
			
		
	}
   
	
}
