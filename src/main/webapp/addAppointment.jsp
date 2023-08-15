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
<div class="container">
        <h2>Book an Appointment</h2>
        <form action="<%= request.getServletContext().getContextPath()%>/CheckConsultServlet" method="post">
            <div class="form-group">
                <label for="appointmentDate">Select Date:</label>
                <input type="date" class="form-control" name="appointmentDate" required>
            </div>
            <div class="form-group">
                <label for="appointmentTime">Select Time:</label>
                <input type="time" class="form-control" name="appointmentTime" required>
            </div>
            <button type="submit" class="btn btn-primary">Check Availability</button>
        </form>
    </div>
    
   <div class="container">
        <h2>Available Consultants</h2>
        
        <form action="BookAppointmentServlet" method="post">
            <div class="form-group">
                <label for="consultant">Select Consultant:</label>
                <select class="form-control" name="consultant" required>
                    <c:forEach var="consultant" items="${availableConsultants}">
                        <option value="${consultant.username}">${consultant.fName} - ${consultant.gender}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Book Appointment</button>
        </form>
    </div>
</body>
</html>