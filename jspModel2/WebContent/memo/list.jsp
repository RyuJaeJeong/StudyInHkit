<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
	<tr>
	<td>no</td>
	<td>이름</td>
	<td>메모</td>
	<td>날짜</td>
	</tr>
	<c:forEach var="row" items="${list }">
	<tr>
		<td>${row.no}</td>
		<td>${row.writer}</td>
		<td>${row.content}</td>
		<td>${row.wdate}</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>