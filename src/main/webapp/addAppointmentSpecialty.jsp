<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Appointment</title>
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
${param.consult_username}
 <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Date</th>
                    <th>Start Time</th>
                    <th>End Time</th>
                   
                </tr>
            </thead>
            <tbody>              
                <c:forEach items="${availableTime}" var="time">             
                <tr>
                        <td>${time.date}</td>
                        <td>${time.startTime}</td>
                        <td>${time.endTime}</td>
                       
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>	
<div class="container">
        <h2>Book an Appointment</h2>
        <form action="<%= request.getServletContext().getContextPath()%>/CheckConsultServlet" method="post">
        <div class="form-group">
                <label for="consultant">Consult username:</label>
                <input type="text" class="form-control" name="consultant" id="consultant" value="${username}"  required>
            </div>
            <div class="form-group">
                <label for="appointmentDate">Enter Date:</label>
                <input type="date" class="form-control" name="appointmentDate" id="appointmentDate"  required>
            </div>
            <div class="form-group">
                <label for="appointmentTime">Enter Time:</label>
                <input type="time" class="form-control" name="appointmentTime" id="appointmentTime" required>
            </div>
            
            <button type="submit" class="btn btn-primary" name="action" value="addAppointment">Book Appointment</button>
        </form>
    </div>
</body>
</html>