<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="form" action ="04.jsp">
		<table border="1" align="center">
		<tr>
		<td>이름</td>
		<td>국어</td>
		<td>영어</td>
		<td>수학</td>
		</tr>
		<tr>
		<td><input type ="text" name="nme"></td>
		<td><input type ="text" name="kor"></td>
		<td><input type ="text" name="eng"></td>
		<td><input type ="text" name="mat"></td>
		</tr>
		<tr>
		<td colspan="4" align="right"><input type="submit" value="조회하기"></td>
		<tr>
		</table>
	</form>
</body>
</html>