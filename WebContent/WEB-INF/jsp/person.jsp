<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Persones</title>
</head>
<body>
	<table border=1>
		<thead>
			<tr>
				<th>AGE</th>
				<th>Name</th>
			</tr>
		</thead>
		<c:forEach var="persones" items="${persones.persones}">
			<tr>
				<td>${person.age}</td>
				<td>${person.name}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>