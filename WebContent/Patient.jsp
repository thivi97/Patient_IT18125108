<%@ page import="com.model.Patient" %> 
<%@ page import="javax.servlet.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.5.0.min.js"></script>
<script src="Components/Patient.js"></script>
</head>
<body>
<div class="container">
		<div class="row">
			<div class="col-6">
				<h1>Patient Management</h1>

				<form id="formPatient" name="formPatient" method="post" action="Patient.jsp">

					First Name: <input id="firstName" name="firstName" type="text"
						class="form-control form-control-sm"> 
					Last Name: <input id="lastName" name="lastName" type="text"
						class="form-control form-control-sm"> Age: <input id="age"
						name="age" type="text" class="form-control form-control-sm">

					Gender: <input id="gender" name="gender" type="text"
						class="form-control form-control-sm"> Email: <input
						id="email" name="email" type="text"
						class="form-control form-control-sm"> Address: <input
						id="address" name="address" type="text"
						class="form-control form-control-sm"> Phone Number: <input
						id="phoneNumber" name="phoneNumber" type="text"
						class="form-control form-control-sm"> Username: <input
						id="username" name="username" type="text"
						class="form-control form-control-sm"> Password: <input
						id="password" name="password" type="text"
						class="form-control form-control-sm"> <br> <input
						id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">

					<input type="hidden" id="hidUserIDSave" name="hidUserIDSave"
						value="">

				</form>

				<br>

				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>

				<br>

				 	<div id="divUsersGrid">
		<% 
			Patient itemObj = new Patient();
			out.print(itemObj.readUsers());
		%>
	
	</div>
	
	

			</div>
		</div>
	</div>

</body>
</html>