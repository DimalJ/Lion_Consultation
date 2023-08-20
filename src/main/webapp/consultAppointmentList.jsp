<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Appointment list</title>
<link rel="icon" href="./Images/favicon.ico" type="image/x-icon">
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
   <link rel="stylesheet" href="./css/styles.css">
</head>
<body>
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
    
    ${Message }
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
                    	<a href="DoneAppointment.jsp?id=${appointment.id}&seekerUsername=${appointment.seekerUsername}&consultUsername=${appointment.consultUsername}&date=${appointment.date}" target="blank">Start</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	                	
                    </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>	

</body>
</html>