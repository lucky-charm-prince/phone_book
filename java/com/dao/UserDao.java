package com.dao;

import java.sql.Connection;

import com.entity.Contact;
import com.entity.User;
import com.mysql.cj.protocol.ResultStreamer;
import com.mysql.cj.protocol.Resultset;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dbConnection.dbConnection;

public class UserDao {
	private Connection conn;

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public UserDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean userRegister(User u) {

		boolean f = false;
		try {
			conn = dbConnection.getConnection();
			String sql = "insert into   users(name, email, password)values(?,?,?)"; 
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			System.out.print(u.getName());

			int i = ps.executeUpdate();
			if (i != 0) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;

	}

	public User login(User u) {
		try {
			conn = dbConnection.getConnection();
			String sql = "select * from users where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPassword());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));

			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return u;
	}

	public boolean addContact(Contact c) {

		boolean f = false;

		try {
			conn = dbConnection.getConnection();
			String url = "insert into contact( name,email,contactNO, userId) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(url);
			ps.setString(1, c.getName());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getContact());
			ps.setInt(4, c.getUserId());
			int i = ps.executeUpdate();
			if (i != 0) {
				f = true;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return f;
	}
	
	public List<Contact> getAllContact(int userId)
	{
		List<Contact> list=new ArrayList<Contact>();
		Contact c=null;
		try{
			 String sql="select * from contact where userId=?";
			 PreparedStatement ps=conn.prepareStatement(sql);
			 ps.setInt(1,userId);
			 ResultSet rs=ps.executeQuery();
			 while(rs.next())
			 {
				 c=new Contact();
				 c.setId(rs.getInt(1));
				 c.setName(rs.getString(2));
				 c.setEmail(rs.getString(3));
				 c.setContact(rs.getString(4));
				 list.add(c);
			 }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	public Contact getContactById(int id)
	{
		 Contact c=null;
	    try
	    {
	    	String sql="select * from contact where id=?";
	    	PreparedStatement ps=conn.prepareStatement(sql);
	    	ps.setInt(1, id);
	      ResultSet rs=	ps.executeQuery();
	      while(rs.next())
	      {
	    	 c = new Contact();
	    	  c.setId(rs.getInt(1));
	    	  c.setName(rs.getString(2));
	    	  c.setEmail(rs.getString(3));
	    	  c.setContact(rs.getString(4));
	      }
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
        return c;		
	}
	
	public boolean updateContact(Contact c)
	{
	     Boolean f=false;
	     
	     try
	     {
	         String sql="update contact set name=?, email=?,contactNO=? where id=?";
	         PreparedStatement ps=conn.prepareStatement(sql);
	         ps.setString(1, c.getName());
	         ps.setString(2, c.getEmail());
	         ps.setString(3,c.getContact());
	         ps.setInt(4,c.getId());
	         int i=ps.executeUpdate();
	         
	         if(i!=0)
	         {
	        	 f=true;
	         }
	         
	         
	     }
	     catch(Exception e)
	     {
	    	 e.printStackTrace();
	     }
	     return f;
	}
	
	public boolean delectContact(int id)
	{
	   boolean f=false;
	   
	   try 
	   {
		
		   System.out.print(id+"  idididididididididid "
		   		+ conn+"   conn.....");
		     String sql="delete from contact where id=?";
		     PreparedStatement ps=conn.prepareStatement(sql);
		     
		     ps.setInt(1,id);
		     int i=ps.executeUpdate();
		      System.out.println("The value of i is "+i);
		     if(i!=0)
		     {
		    	 f=true;
		     }
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   return f;
	}

	public  List<Contact> searchContact(int userId,String s)
	{
		List<Contact> list=new ArrayList<Contact>();
		Contact c=null;
		try
		{
			String sql="select * from contact where userId=? and name like ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
		
			ps.setString(2, "%"+s+"%");
			
			ResultSet rs= ps.executeQuery();
		
			while(rs.next())
			{
								c=new Contact();
				 c.setId(rs.getInt(1));
				 
				 c.setName(rs.getString(2));
				 
				 c.setEmail(rs.getString(3));
				 c.setContact(rs.getString(4));
				 list.add(c);
			}
			
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
		return list;
	}
}


