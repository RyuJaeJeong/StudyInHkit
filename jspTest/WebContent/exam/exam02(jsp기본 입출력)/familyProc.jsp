<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
String father = request.getParameter("father");
String mother = request.getParameter("mother");
String grandmo = request.getParameter("grandmo");
String brother = request.getParameter("brother");
%>

<table border="1">
	<tr>
		<td>당신 아버지의 성함은 <%=father%>입니다.</td>
	</tr>
	<tr>
		<td>당신 어머니의 성함은 <%=mother%>입니다.</td>
	</tr>
	<tr>
		<td>당신 할머니의 성함은 <%=grandmo%>입니다.</td>
	</tr>
	<tr>
		<td>당신 동생의 성함은 <%=brother%>입니다.</td>
	</tr>
</table>

</body>
</html>