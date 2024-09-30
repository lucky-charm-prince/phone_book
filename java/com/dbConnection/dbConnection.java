package com.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {
  private static Connection conn=null;
  private static String name="root";
  private static String password="";
 private static String url="jdbc:mysql://localhost:3306/phonebook";
  
  public static Connection getConnection()
  {
	  try {
		  
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(url,name,password);
	  }
	  catch(Exception e )
	  {
		  
		  e.printStackTrace();
	  }
	  return conn;
	  
  }
  
  public static void main(String[] args)
  {
	  
	  
	 System.out.println(dbConnection.getConnection()) ;
	  
  }
	
}
