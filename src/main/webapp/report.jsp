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
   <link rel="stylesheet" href="./css/kpi.css">
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
 <h3>Welcome to Top Jobs,<br></h3>
	${Message}
</div>
 
<div id="container" align="center">
  <div class="kpi-card orange" align="center">
    <span class="card-value">${newUser} </span>
    
    <span class="card-text">Number of New Users</span>
     <i class="fas fa-shopping-cart icon"></i>
  </div>
 
 
    <div class="kpi-card purple">
    <span class="card-value">${totalConsult} </span>
    <span class="card-text">Number of consultants </span>
       <i class="fas fa-shopping-cart icon"></i>
  </div>
  
      <div class="kpi-card grey-dark">
    <span class="card-value">${totalUser} </span>
    <span class="card-text">Number of Users</span>
         <i class="fas fa-shopping-cart icon"></i>
  </div>
  
</div>
 
  <div id="container" align="center">
  <div class="kpi-card orange" align="center">
    <span class="card-value">${monthlyAppo} </span>
    
    <span class="card-text">Number of Appointments(month)</span>
     <i class="fas fa-shopping-cart icon"></i>
  </div>
 
    <div class="kpi-card purple">
    <span class="card-value">${pendingAppo}</span>
    <span class="card-text">Pending Appointments </span>
       <i class="fas fa-shopping-cart icon"></i>
  </div>
  
      <div class="kpi-card grey-dark">
    <span class="card-value">${totalAppo}</span>
    <span class="card-text">Total Appointment</span>
         <i class="fas fa-shopping-cart icon"></i>
  </div>
  
</div>
</body>
</html>