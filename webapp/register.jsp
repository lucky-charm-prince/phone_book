<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/allCss.jsp"%>
</head>
<body style="background-color: #D8D8D8">
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
			<form class="form-inline my-2 my-lg-0">
				<a href="login.jsp" class="btn btn-success"><i
					class="fa-solid fa-user"></i>Login</a> <a href="register.jsp"
					class="btn btn-danger ml-2"><i class="fa-solid fa-users"></i>
					Register</a>
			</form>

		</div>
	</nav>

	<div class="container-fluid	">
		<div class="row p-2 ">
			<div class="col-md-6 offset-md-3  ">
				<div class="card">
					<div class="card-body">

						<h4 class="text-center text-success">Registration</h4>
						<%
						String sMsg = (String) session.getAttribute("success");
						String eMsg = (String) session.getAttribute("error");

						if (sMsg != null) {
						%>

						<p class="text-success text-center"><%=sMsg%></p>
						<%
						session.removeAttribute("success");
						}
						if (eMsg != null) {
						%>
						<p class="text-danger text-center"><%=eMsg%></p>
						<%
						session.removeAttribute("error");
						}
						%>
						<form method="post" action="register">
							<div class="form-group">
								<label for="exampleInputName">Name</label> <input type="text"
									name="name" class="form-control" id="exampleInputEmail1"
									placeholder="Enter Name">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									name="email" type="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter email">

							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									name="password" type="password" class="form-control"
									id="exampleInputPassword1" placeholder="Password">
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
	<div style="margin-top: 200px">
		<%@include file="component/footer.jsp"%></div>
</body>
</html>