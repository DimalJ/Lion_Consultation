<%@ page import="controller.AdminViewUserServlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <table class="table table-bordered">
            <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Contact</th>
                </tr>
            </thead>
            <tbody>
              
             
              
                <c:forEach items="${users}" var="user">
                <tr>
                        <td>${user.fName}</td>
                        <td>${user.lName}</td>
                        <td>${user.username}</td>
                        <td>${user.email}</td>
                        <td>${user.contact}</td>
                         <td>
                    	<a href="edit?username=<c:out value='${user.username}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?username=<c:out value='${user.username}' />">Delete</a>                    	
                    </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
</body>
</html>