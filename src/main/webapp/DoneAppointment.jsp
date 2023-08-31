<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Appointment Edit</title>
	<link rel="icon" href="./Images/favicon.ico" type="image/x-icon">
   	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  
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
        
        <label for="startTime">Start Time: </label>
      	<input type="text" id="startTime" name="startTime" >
         </div>
        
        
          <div class="form-group col-md-6">
        <button type="submit" id="finishTime">Finish the Appointment</button>
         </div>
         
    </form>
       <script>
       window.onload = function(){
    	   var startTimeField = document.getElementById("startTime");
    	    var currentTime = new Date();
    	    var hours = currentTime.getHours();
    	    var minutes = currentTime.getMinutes();
    	    
    	    var formattedHours = (hours < 10) ? "0" + hours : hours;
    	    var formattedMinutes = (minutes < 10) ? "0" + minutes : minutes;
    	    
    	    var formattedTime = formattedHours + ":" + formattedMinutes;
    	    startTimeField.value = formattedTime;
       }
	  
    </script>
	
    
</body>
</html>