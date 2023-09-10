<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consultants</title>
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
        function updateEndTimeOptions() {
            var startTime = document.getElementById("start_time").value;
            var endSelect = document.getElementById("finish_time");
            
            // Clear previous options
            endSelect.innerHTML = "";
            
            var startHour = parseInt(startTime.split(":")[0]);
            var startMinute = parseInt(startTime.split(":")[1]);
            
            // Generate options for later times
            for (var hour = startHour; hour <= 23; hour++) {
                for (var minute = (hour === startHour ? startMinute + 30 : 0); minute < 60; minute += 30) {
                    var timeText = (hour < 10 ? "0" + hour : hour) + ":" + (minute < 10 ? "0" + minute : minute);
                    var option = new Option(timeText, timeText);
                    endSelect.appendChild(option);
                }
            }
        }
    </script>
</head>
<body onload="setMinDate()">
 <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <a class="navbar-brand" href="consultants.jsp">Top Jobs</a>
       
        <div class="navbar-text ml-auto">
            Welcome, ${sessionScope.username} (${sessionScope.userType})
        </div>
        <div class="navbar-text ml-auto">
           <a class="nav-link" href="LogoutServlet">Logout</a>
        </div>
    </nav>
<h1>Welcome to Top Jobs</h1>
${Message}
<div class="container">
 	<div class="card-deck">
	   <div class="card text-white bg-dark mb-3" style="width: 18rem;">
		  <div class="card-body">
		    <h5 class="card-title">Add Available time</h5>
		    <p class="card-text">Click here for add new time slot</p>
		    <a href="consultAvailability.jsp" class="card-link"><button type="submit"  class="btn btn-success btn-sm" >Enter</button></a>
		  </div>
		  </div>
	   <div class="card text-white bg-dark mb-3" style="width: 18rem;">
		  <div class="card-body">
		    <h5 class="card-title">Appointment List</h5>
		    <p class="card-text">Click here to See appointment List</p>
		    <a href="<%= request.getServletContext().getContextPath()%>/ViewConsultAppointmentListServlet?username=${sessionScope.username}" class="card-link"><button type="submit"  class="btn btn-success btn-sm"  >Enter</button></a>
		  </div>
   	   </div>
   	   
	</div>
 </div>
   
</body>
</html>