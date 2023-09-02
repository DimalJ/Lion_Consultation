<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
 <link rel="icon" href="./Images/favicon.ico" type="image/x-icon">
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
   <link rel="stylesheet" href="./css/styles.css">
</head>
<body>
<!-- Navigation Bar -->
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
 
 <div  class="message">
 <h3>Welcome to Lion Consultation,<br></h3>
	${Message}
</div>
 
 <div class="container">

        <h2>View Users</h2>
         <form action="<%= request.getServletContext().getContextPath()%>/AdminViewUserServlet" method="post">
         
        
		  	<div class="input-group mb-3">
		  		 <select class="form-control" id="type" name="type" required>
                        <option value="" selected disabled>Select User Type</option>
                        <option value="jobSeeker">Job Seeker</option>
                        <option value="consultant">Consultant</option>
                        <option value="admin">Admin</option>
                    </select>
		  	
		 
		  <div class="form-group col-md-6">
		  		<div class="input-group-append">
		    	 <button type="submit" class="btn btn-dark">Search</button>
		  		</div>
		  	</div>
		  	 </div> 
		 
         </form>
        

       <table class="table table-bordered">
            <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Contact</th>
                </tr>
            </thead>
            <tbody>              
                <c:forEach items="${users}" var="user">             
                <tr>
                        <td>${user.fName}</td>
                        <td>${user.lName}</td>
                        <td>${user.username}</td>
                        <td>${user.email}</td>
                        <td>${user.contact}</td>
                         <td>
                    	<a href="edit.jsp?username=${user.username}">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	                	
                    </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>	
</body>
</html>

