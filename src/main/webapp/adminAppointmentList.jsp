<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Appointment List</title>
 <link rel="icon" href="./Images/favicon.ico" type="image/x-icon">
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
   <link rel="stylesheet" href="./css/styles.css">
   <script type="text/javascript">
   console.log('confirmDelete function called with itemId:', "13");
   function confirmDelete(deleteURL) {	 
	    var confirmMsg = "Are you sure you want to delete this item?";
	    if (confirm(confirmMsg)) {
	        // If the user confirms, redirect to the delete servlet
	        window.location.href = deleteURL;
	    }
	}

   </script>
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
 <h3>Welcome to Lion Consultation,<br></h3>
	${Message}
</div>
 
<div class="container" >
 <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Job seeker</th>
                    <th>Consultant</th>
                    <th>Date</th>
                    <th>Time</th>
                   
                </tr>
            </thead>
            <tbody>              
                <c:forEach items="${appointmentList}" var="appointment">             
                <tr>
                        <td>${appointment.seekerFname}</td>
                        <td>${appointment.consultFname}</td>
                        <td>${appointment.date}</td>
                        <td>${appointment.time}</td>
                     	<td>
                     	<a href="javascript:void(0);" onclick="confirmDelete(<%= request.getServletContext().getContextPath()%>/AbsentAppointmentServlet?id=${appointment.id})">Delete</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	                	
                    </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>	
</body>
</html>

