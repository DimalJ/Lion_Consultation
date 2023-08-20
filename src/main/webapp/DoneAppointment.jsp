<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Appointment Edit</title>
	<link rel="icon" href="./Images/favicon.ico" type="image/x-icon">
   	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
   <script>
        const startButton = document.getElementById("startButton");
        const endButton = document.getElementById("endButton");
        const startTimeInput = document.getElementById("startTime");
        const endTimeInput = document.getElementById("endTime");
        alert("Hello, JavaScript World!");
        startButton.addEventListener("click", function () {
            const currentTime = new Date().toISOString();
            startTimeInput.value = currentTime;
            startTime.textContent = currentTime;
        });

        endButton.addEventListener("click", function () {
            const currentTime = new Date().toISOString();
            endTimeInput.value = currentTime;
            endTimeLabel.textContent = "End Time: " +currentTime;
        });
        const endButton = document.getElementById("endButton");
        
        finishTime.addEventListener("click", function () {
            window.close();
        });
    </script>
</head>
<body>
${Message}
 
    
    <form action="<%= request.getServletContext().getContextPath()%>/DoneAppointmentServlet" method="post">
    	 <div class="form-group col-md-6">
    	 <label for="id">Appointment id</label>
         <input type="text" class="form-control" id="id" name="id" value="${param.id}" required>
         </div>
          <div class="form-group col-md-6">
    	 <label for="seekerUsername">Seeker Username</label>
         <input type="text" class="form-control" id="seekerUsername" name="seekerUsername" value="${param.seekerUsername}" required>
          </div>
          <div class="form-group col-md-6">
         <label for="consultUsername">Consult Username</label>
         <input type="text" class="form-control" id="consultusername" name="consultUsername" value="${param.consultUsername}" required>
          </div>
          <div class="form-group col-md-6">
         <label for="date">Date</label>
         <input type="text" class="form-control" id="date" name="date" value="${param.date}" required>
          </div>
          <div class="form-group col-md-6">
        
        <label id="startTimeLabel">Start Time: </label>
      	<input type="text" id="startTime" name="startTime">
         </div>
         <div class="form-group col-md-6">
        
         <label id="endTimeLabel">End Time: </label>
       	<input type="text" id="endTime" name="endTime">
          </div>
          <div class="form-group col-md-6">
        <button type="submit" id="finishTime">Finish the Appointment</button>
         </div>
         
    </form>
      <button id="startButton">Start</button>
       <button id="endButton">End</button>
	
    
</body>
</html>