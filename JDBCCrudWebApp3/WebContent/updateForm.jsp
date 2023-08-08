<%@ page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Update Form</title>
</head>
<body bgcolor="lightblue">
	<br>
	<br>
	<br>
	<br>
	<c:choose>
		<c:when test="${student ne null || !empty student}">
			<form action="./controller/updateRecord" method="post">
				<table align="center">
					<caption>UPDATE STUDENT RECORD</caption>
					<tr>
						<th>ID</th>
						<td><input type="text" readonly="readonly" name="sid"
							value="${student.sid}" /></td>
					</tr>
					<tr>
						<th>NAME</th>
						<td><input type="text" name="snameUpdated"
							value="${student.sname}" /></td>
					</tr>
					<tr>
						<th>AGE</th>
						<td><input type="text" name="sageUpdated"
							value="${student.sage}" /></td>
					</tr>
					<tr>
						<th>ADDRESS</th>
						<td><input type="text" name="saddressUpdated"
							value="${student.saddress}" /></td>
					</tr>
					<tr>
						<th></th>
						<td><input type="submit" value="UPDATE" /></td>
					</tr>
				</table>
			</form>
		</c:when>
		<c:otherwise>
			<h1 style="color: red; text-align: center;">Record not found for the id: ${param.sid }</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>