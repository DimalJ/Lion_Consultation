<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
<link rel="icon" href="./Images/favicon.ico" type="image/x-icon">
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
   
</head>
<body>
<body >
 <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <a class="navbar-brand" href="#">Lion Consultants</a>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contact</a>
                </li>
            </ul>
        </div>
        <div class="navbar-text ml-auto">
            Welcome, ${sessionScope.username} (${sessionScope.userType})
        </div>
        <div class="navbar-text ml-auto">
           <a class="nav-link" href="LogoutServlet">Logout</a>
        </div>
   </nav>
   <div class="container mt-5">
	   <form action="<%= request.getServletContext().getContextPath()%>/EditUserServlet" method="post">
	   	 <div class="form-group col-md-6">
		  	<div class="input-group mb-3">
		  		<input type="text" class="form-control" id="editUsername" name="editUsername" value="${param.username}" required>
		  	
		 
		  <div class="form-group col-md-6">
		  		<div class="input-group-append">
		    	<button type="submit" class="btn btn-dark">Retrive Data</button>
		  		</div>
		  	</div>
		  	 </div> 
		 </div>
	    </form>
   </div>
  
   
    <div class="container mt-5">
        <h1>Update Form</h1>
        <form action="<%= request.getServletContext().getContextPath()%>/UpdateUserServlet" method="post">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="firstName">First Name</label>
                    <input type="text" class="form-control" id="firstName" name="firstName" value="${user.fName}" required>
                </div>
                <div class="form-group col-md-6">
                    <label for="lastName">Last Name</label>
                    <input type="text" class="form-control" id="lastName" name="lastName" value="${user.lName}"  required>
                </div>
            </div>
           <div class="form-row">
            <div class="form-group col-md-6">
                <label for="username">Username</label>
                <input type="text" class="form-control" id="username" name="username" value="${user.username}" required>
            </div>
            <div class="form-group col-md-6">
                <label for="password">Password</label>
                <input type="text" class="form-control" id="password" name="password" value="${user.password}" required>
            </div>
            </div>
             <div class="form-row">
				<div class="form-group col-md-6">
	                <label for="email">Email</label>
	                <input type="email" class="form-control" id="email" name="email" value="${user.email}"  required>
            	</div>
                  <div class="form-group col-md-6">
	                <label for="contact">Contact</label>
	                <input type="text" class="form-control" id="contact" name="contact" value="${user.contact}" required>
            	 </div>
            	 
             </div>
            <div class="form-row">
	            <div class="form-group col-md-6">
	                    <label for="dob">Date of Birth</label>
	                    <input type="date" class="form-control" id="dob" name="dob" value="${user.dob}" required>  
	            </div> 
                <div class="form-group col-md-6">
                    <label for="gender">Gender</label>
                    <select class="form-control" id="gender" name="gender" required>
                        <option value="" selected disabled>Select Gender</option>
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                        <option value="Other">Other</option>
                    </select>
                </div>
            </div>
            <div class="form-row">
	           
                <div class="form-group col-md-6">
                    <label for="type">User Type</label>
                    <select class="form-control" id="type" name="type" required>
                        <option value="" selected disabled>Select User Type</option>
                        <option value="jobSeeker">Job Seeker</option>
                        <option value="consultant">Consultant</option>
                        <option value="admin">Admin</option>
                    </select>
                </div>
            </div>  
           	<button type="submit" class="btn btn-outline-warning btn-lg">Update</button>
           
            
        </form>
    </div>
    <div class="container mt-5">
	   <form action="<%= request.getServletContext().getContextPath()%>/DeleteUserServlet" method="post">
	   	 <div class="form-group col-md-6">
		  	<div class="input-group mb-3">
		  		<input type="text" class="form-control" id="delUsername" name="delUsername" value="${user.username}" required>
		  	
		  <div class="form-group col-md-6">
		  		<div class="input-group-append">
		    	 <button type="submit" class="btn btn-outline-danger btn-lg">Delete</button>
		  		</div>
		  	</div>
		  	 </div> 
		 </div>
	    </form>
   </div>
</body>
</html>

