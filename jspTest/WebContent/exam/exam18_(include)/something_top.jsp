<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String name = request.getParameter("name"); %>
<table border="1" width="800" align="center">
	<tr height="50">
		<td width="160" align="center">메뉴1</td>
		<td align="center">메뉴2</td>
		<td align="center">메뉴3</td>
		<td align="center">메뉴4</td>
		<td align="center">메뉴5</td>
	</tr>
	<tr height="50">
	<td colspan="5" align="center"><%=name%></td>
	</tr>
</table>

</body>
</html>