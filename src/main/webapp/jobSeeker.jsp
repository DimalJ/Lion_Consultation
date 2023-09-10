<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Job Seeker</title>
<link rel="icon" href="./Images/favicon.ico" type="image/x-icon">
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
   <link rel="stylesheet" href="./css/styles.css">
</head>
<body>

 <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <a class="navbar-brand" href="jobSeeker.jsp">Top Jobs</a>
       
        <div class="navbar-text ml-auto">
            Welcome, ${sessionScope.username} (${sessionScope.userType})
        </div>
        <div class="navbar-text ml-auto">
           <a class="nav-link" href="LogoutServlet">Logout</a>
        </div>
    </nav>
<h3>Welcome to Top jobs</h3><br>
 ${Message}
 
 <div class="container">
 	<div class="card-deck">
	   <div class="card text-white bg-dark mb-3" style="width: 18rem;">
		  <div class="card-body">
		    <h5 class="card-title">Add appointment</h5>
		    <p class="card-text">Click here for add a new appointment</p>
		    <a href="searchConsultant.jsp" class="card-link"><button type="submit"  class="btn btn-success btn-sm" >Enter</button></a>
		  </div>
		  </div>
	   <div class="card text-white bg-dark mb-3" style="width: 18rem;">
		  <div class="card-body">
		    <h5 class="card-title">Appointment List</h5>
		    <p class="card-text">Click here to See appointment List</p>
		    <a href="<%= request.getServletContext().getContextPath()%>/ViewAppointmentListServlet?username=${sessionScope.username}" class="card-link"><button type="submit"  class="btn btn-success btn-sm"  >Enter</button></a>
		  </div>
   	   </div>
   	 
	</div>
 </div>

</body>
</html>