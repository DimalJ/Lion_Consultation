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
        <h2>Add Available Time</h2>
        <form action="<%= request.getServletContext().getContextPath()%>/ConsultantAvailabilityServlet" method="post">
            <div class="form-group">
                <label for="availableDate">Available Date:</label>
                <input type="date" class="form-control" name="availableDate" id="availableDate" required>
            </div>
            <div class="form-group">
				    <label for="start_time">Start Time:</label>
				    <select class="form-control" name="start_time" id="start_time" onchange="updateEndTimeOptions()" required>
				        <!-- Generate 30-minute time slots -->
				        <c:forEach var="hour" begin="0" end="23">
				            <c:forEach var="minute" begin="0" end="30" step="30">
				                <option>${String.format('%02d', hour)}:${String.format('%02d', minute)}</option>
				            </c:forEach>
				        </c:forEach>
				    </select>
				</div>
				
				<div class="form-group">
				    <label for="end_time">End Time:</label>
				    <select class="form-control" name="finish_time" id="finish_time" required>
				        <!-- Generate 30-minute time slots -->
				        <c:forEach var="hour" begin="0" end="23">
				            <c:forEach var="minute" begin="0" end="30" step="30">
				                <option>${String.format('%02d', hour)}:${String.format('%02d', minute)}</option>
				            </c:forEach>
				        </c:forEach>
				    </select>
</div>
            <button type="submit" class="btn btn-primary">Add Availability</button>
        </form>
    </div>
   
</body>
</html>