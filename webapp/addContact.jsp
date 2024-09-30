<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.entity.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/allCss.jsp"%>

</head>
<body style="background-color: #D8D8D8">
	<%
	User u = (User) session.getAttribute("user");
	out.println(u);
	String addMsg=(String)session.getAttribute("addMsg");
	String notMsg=(String)session.getAttribute("notMsg");
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
	<%
	if (u == null) {

		response.sendRedirect("login.jsp");
	} else {
	%>
	<div class="container-fluid	">
		<div class="row p-2 ">
			<div class="col-md-6 offset-md-3  ">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-success">Add Contact</h4>
						<form method="post" action="addContact">
							<% if(addMsg!=null) {%>

							<h6 class="text-center btn-btn-success"><%=addMsg%></h6>
							<% session.removeAttribute("addMsg");} %>
							<%if(notMsg!=null){ %>
							<h6 class="text-center btn-btn-danger"><%=notMsg%></h6>
							<% session.removeAttribute(notMsg);}%>
							<input type="hidden" value="<%=u.getId()%>" name="userId">
							<div class="form-group">
								<label for="exampleInputName">Name</label> <input type="text"
									name="name" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter Name">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									name="email" type="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter email">

							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Enter Phone No</label> <input
									name="contact" type="text" class="form-control"
									id="exampleInputPassword1" placeholder="Enter Phone No">
							</div>

							<div class="text-center mt-2">
								<button type="submit" class="btn btn-primary">Submit</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%
	}
	%>
	<div style="margin-top: 200px">
		<%@include file="component/footer.jsp"%></div>
</body>
</html>