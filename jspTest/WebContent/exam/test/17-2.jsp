<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<tr>
<td>이름</td>
<td><input type="text" name="nme" value=""></td>
</tr>

<%out.println(request.getParameter("nme"));%>
</body>
</html>