<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page import="java.util.ArrayList, model.Employee" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html 4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
</head>
<body>
Home Page

<%
ArrayList<Employee> empList = (ArrayList)request.getAttribute("empList");%>
<table>
	<% for(Employee emp : empList){
		
		out.println("<tr><td> EmployeeId: "  +emp.getEmpId() + "</td></tr>"); 
		out.println("<tr><td> Employee Name: " +emp.getEmpName() + "</td></tr>"); 
		out.println("<tr><td> Employee Gender: " +emp.getGender() + "</td></tr>"); 
		out.println("<tr><td> Employee Experience: "  +emp.getExperience() + "</td></tr>"); 
	}%>
</table>

	<h2>using jstl Core taglib to print list</h2>
	<ul>
		<c:forEach items="${empList}" var="emp">
			<li>${emp.empName }</li>
			<li>${emp.dob }</li>
			<li>${emp.empId}</li>
			<li>${emp.gender}</li>
			<li>${emp.experience}</li>
			
		</c:forEach>
	
	</ul>
	

</body>
</html>