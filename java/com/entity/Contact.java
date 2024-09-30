package com.entity;

public class Contact {
   private int id;
   private String name;
   private String email;
   private String contact;
 private int userId;
 
 
public Contact() {
	super();
	// TODO Auto-generated constructor stub
}


public Contact(String name, String email, String contact, int userId) {
	super();
	this.name = name;
	this.email = email;
	this.contact = contact;
	this.userId = userId;
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}


@Override
public String toString() {
	return "Contact [id=" + id + ", name=" + name + ", email=" + email + ", contact=" + contact + ", userId=" + userId
			+ "]";
}
 
 


}
