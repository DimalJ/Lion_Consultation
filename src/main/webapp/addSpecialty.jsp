<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Specialty Form</title>
     <link rel="icon" href="./Images/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
     <link rel="stylesheet" href="./css/styles.css">
</head>
<body >
    <div class="container mt-5">
        <h1>Add Specialty</h1>
        <form action="<%= request.getServletContext().getContextPath()%>/AddSpecialtyServlet" method="post">
        
            <div class="form-group col-md-6">
                <label for="username">Username</label>
                <input type="text" class="form-control" id="username" name="username" value="${param.username}" required>
            </div>
           	
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
                    <select class="form-control" id="region" name="region" required>
                        <option value="" selected disabled>Select Region</option>
                        <option value="america">America</option>
                        <option value="europe">Europe</option>
                        <option value="gcc">GCC</option>
                        <option value="oceania">Oceania</option>
                    </select>
                </div>
              <div class="form-group col-md-6">
            <button type="submit" class="btn btn-dark btn-lg">Add </button>
            </div>
      </form>
    </div>
</body>
</html>