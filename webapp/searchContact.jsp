<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.entity.*"%>
	<%@ page import="com.dao.*"%>
	<%@ page import="com.dbConnection.*"%>
	<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/allCss.jsp"%>
	<style>
	.crd-ho:hover {
		background-color: #f7f7f7;
	}
	</style>
	</head>
	<body>
		<%
		User u = (User) session.getAttribute("user");
		if (u == null) {
			session.setAttribute("error", "Login Please");
			response.sendRedirect("login.jsp");
		}
		%>
		<nav class="navbar navbar-expand-lg navbar-dark  bg-primary">
			<a class="navbar-brand" href="index.jsp"><i
				class="fa-solid fa-phone"></i>PhoneBook</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
	
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link"
						href="index.jsp"><i class="fa-solid fa-house"></i> Home <span
							class="sr-only">(current)</span> </a></li>
					<li class="nav-item active"><a class="nav-link"
						href="addContact.jsp"><i class="fa-solid fa-user-plus"></i>Add
							Phone No </a></li>
	
	
					<li class="nav-item active"><a class="nav-link "
						href="viewContact.jsp"><i class="fa-solid fa-eye"></i>View
							Contact</a></li>
				</ul>
				
				<%
				if (u == null) {
				%>
				<form class="form-inline my-2 my-lg-0">
					<a href="login.jsp" class="btn btn-success"><i
						class="fa-solid fa-user"></i>Login</a> <a href="register.jsp"
						class="btn btn-danger ml-2"><i class="fa-solid fa-users"></i>
						Register</a>
				</form>
				<%
				} else {
				%>
				
				<form action="searchContact" method="post" class="btn btn text-center">
				
				<input type="hidden" value="<%=u.getId()%>" name="u">
				   <input type="text" name="search" placeholder="search">
				   <button type="submit" class="btn btn-success ">Search</button>
				</form>
				<form class="form-inline my-2 my-lg-0">
					<a class="btn btn-success"><i class="fa-solid fa-user"></i><%=u.getName()%></a>
					<a data-toggle="modal" data-target="#exampleModalCenter"
						class="btn btn-danger ml-2"><i class="fa-solid fa-users"></i>
						logout</a>
				</form>
				<!-- Button trigger modal -->
	
				<!-- Modal -->
				<div class="modal fade" id="exampleModalCenter" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalCenterTitle"
					aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLongTitle">Logout</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body text-center">
								<h6>Press yes if you want to logout</h6>
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">No</button>
								<a href="logout" type="button" class="btn btn-primary">LogOut</a>
							</div>
							<div class="modal-footer"></div>
						</div>
					</div>
				</div>
				<%
				}
				%>
	
			</div>
		</nav>
	
		<div class="container">
			<div class="row p-4">
	
				<%
			
	
				if (u != null) {
	
					List<Contact> contact = (List)session.getAttribute("seMsg");
	
					for (Contact c : contact) {
				%><div class="col-md-3 ">
					<div class="card crd-ho">
						<div class="card-body">
							<h5>
								Name:
								<%=c.getName()%></h5>
							<p>
								Email:
								<%=c.getEmail()%></p>
							<p>
								Contact:
								<%=c.getContact()%></p>
							<div class="text-center">
								<a class="btn btn-success btn-sm text-white"
									href="editcontact.jsp?cid=<%=c.getId()%>">Edit</a> <a
									class="btn btn-danger btn-sm text-white"
									href="delect?cid=<%=c.getId()%>">Delect</a>
							</div>
						</div>
					</div>
				</div>
	
				<%
				}
	
				}
				%>
	
	
	
	
			</div>
	
		</div>
	
	
	</body>
	</html>