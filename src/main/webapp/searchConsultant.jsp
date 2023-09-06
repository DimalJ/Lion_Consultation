<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Appointment</title>
   <link rel="icon" href="./Images/favicon.ico" type="image/x-icon">
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
   <link rel="stylesheet" href="./css/styles.css">
   
    <script>
        function setMinDate() {
            var today = new Date();
            var dd = today.getDate();
            var mm = today.getMonth() + 1; // January is 0!
            var yyyy = today.getFullYear();
            if (dd < 10) {
                dd = '0' + dd;
            }
            if (mm < 10) {
                mm = '0' + mm;
            }
            today = yyyy + '-' + mm + '-' + dd;
            
            document.getElementById("availableDate").setAttribute("min", today);
        }
       
        
    </script>
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
${Message}
<div class="container">
        <h2>Search Consultant</h2>
        <form action="<%= request.getServletContext().getContextPath()%>/CheckConsultantSpecialtyServlet" method="post">
            <div class="form-group col-md-6">
                    <label for="industry">Industry</label>
                    <select class="form-control" id="industry" name="industry" required>
                        <option value="" selected disabled>Select Industry</option>
                        <option value="it">IT</option>
                        <option value="hr">HR</option>
                        <option value="finance">FINANCE</option>
                        <option value="marketing">marketing</option>
                        <option value="logistics">Logistics</option>
                    </select>
                  </div>
                    <div class="form-group col-md-6">
                    <label for="region">Country</label>
                    <select class="form-control" id="region" name="region"  required>
                        <option value="" selected disabled>Select Region</option>
                        <option value="america">America</option>
                        <option value="europe">Europe</option>
                        <option value="gcc">GCC</option>
                        <option value="oceania">Oceania</option>
                    </select>
                </div>
                <div class="form-group col-md-6">
            <button type="submit" class="btn btn-primary" name="action" value="checkTime">Check Availability</button>
            </div>
            </form>
             <form action="<%= request.getServletContext().getContextPath()%>/CheckConsultantTime" method="post">
            <div class="form-group col-md-6">
            <h2>Available Consultants</h2>
            <div class="form-group">
                <label for="consultant">Select Consultant:</label>
                <select class="form-control" name="consultant">
                    <c:forEach var="consultant" items="${availableConsultants}">
                        <option value="${consultant.username}">${consultant.fName} - ${consultant.gender}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-primary" name="action" value="addAppointment">Get Time Slots</button>
            </div>
        </form>
        
    </div>
    
  
</body>
</html>