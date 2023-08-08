<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Record</title>
</head>
<body bgcolor="lightblue">
<br>
<br>
<br>
<br>
	<c:choose>
			<c:when test="${student ne null || !empty student}">
				<table border="1" align="center">
				<caption>STUDENT RECORD</caption>
					<tr>
						<th>ID</th>
						<th>NAME</th>
						<th>AGE</th>
						<th>ADDRESS</th>
					</tr>
					<tr>
						<td>${student.sid}</td>
						<td>${student.sname}</td>
						<td>${student.sage}</td>
						<td>${student.saddress}</td>
					</tr>
				</table>
			</c:when>
			<c:otherwise>
				<h1 style="color: red;text-align: center;">Record not found for the id: ${param.sid }</h1>
			</c:otherwise>
	</c:choose>
</body>
</html>