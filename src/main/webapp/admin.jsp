
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
 <link rel="icon" href="./Images/favicon.ico" type="image/x-icon">
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
   <link rel="stylesheet" href="./css/styles.css">
</head>
<body>
<!-- Navigation Bar -->
   <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <a class="navbar-brand" href="admin.jsp">Top Jobs</a>
       
        <div class="navbar-text ml-auto">
            Welcome, ${sessionScope.username} (${sessionScope.userType})
        </div>
        <div class="navbar-text ml-auto">
           <a class="nav-link" href="LogoutServlet">Logout</a>
        </div>
    </nav>
 
 <div  class="message">
 <h3>Welcome to Top jobs,<br></h3>
	${Message}
</div>
 
<div class="container">
 	<div class="card-deck">
	   <div class="card text-white bg-dark mb-3" style="width: 18rem;">
		  <div class="card-body">
		    <h5 class="card-title">Add User</h5>
		    <p class="card-text">Click here for add users</p>
		    <a href="adminAddUser.jsp" class="card-link"><button type="submit"  class="btn btn-success btn-sm" id="addUser" name="addUser">Add User</button></a>
		  </div>
		  </div>
	   <div class="card text-white bg-dark mb-3" style="width: 18rem;">
		  <div class="card-body">
		    <h5 class="card-title">View User List</h5>
		    <p class="card-text">Click here to See User List</p>
		    <a href="viewUserList.jsp" class="card-link"><button type="submit"  class="btn btn-success btn-sm" id="userList" name="userList">user List</button></a>
		  </div>
   	   </div>
   	   <div class="card text-white bg-dark mb-3" style="width: 18rem;">
		  <div class="card-body">
		    <h5 class="card-title">Appointment List</h5>
		    <p class="card-text">Click here for see Appointment List</p>
		    <a href="<%= request.getServletContext().getContextPath()%>/ViewadminAppointmentList" class="card-link"><button type="submit"  class="btn btn-success btn-sm" id="addUser" name="addUser">Add User</button></a>
		  </div>
	   </div>
	</div>
 </div>
 <div class="container">
 	<div class="card-deck">
	   <div class="card text-white bg-dark mb-3" style="width: 18rem;">
		  <div class="card-body">
		    <h5 class="card-title">Add Specialty</h5>
		    <p class="card-text">Click here for add Specialty</p>
		    <a href="<%= request.getServletContext().getContextPath()%>/ConsultListServlet" class="card-link"><button type="submit"  class="btn btn-success btn-sm" id="typeC" name="typeC">Click Here</button></a>
		  </div>
		</div>
	   <div class="card text-white bg-dark mb-3" style="width: 18rem;">
		  <div class="card-body">
		    <h5 class="card-title">Finished Appointments</h5>
		    <p class="card-text">Monthly Finished Appointments</p>
		    <a href="<%= request.getServletContext().getContextPath()%>/FinishedAppointmentServlet" class="card-link"><button type="submit"  class="btn btn-success btn-sm" id="Fappo" name="Fappo">Click Here</button></a>
		  </div>
   	   </div>
   	   <div class="card text-white bg-dark mb-3" style="width: 18rem;">
		  <div class="card-body">
		    <h5 class="card-title">Report</h5>
		    <p class="card-text">Click here for see the report Dashbaord</p>
		    <a href="<%= request.getServletContext().getContextPath()%>/ReportServlet" class="card-link"><button type="submit"  class="btn btn-success btn-sm" id="appointmentList" name="appointmentList">Click Here</button></a>
		  </div>
	   </div>
	</div>
 </div>
 
       
</body>
</html>