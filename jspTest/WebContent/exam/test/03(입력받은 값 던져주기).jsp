<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연습03</title>
</head>
<body>
	<form name="form" method="post" action="03proc.jsp">
	<table border="1" >
	<tr>
	<td>이름</td>
	<td><input type="text"	name="nme" value=""></td>
	</tr>
	<tr>
	<td>나이</td>
	<td><input type="text"	name="age" value=""></td>
	</tr>
	<tr>
	<td colspan="2" align="center"><input type="submit" value="가입하기"></td>
	</tr>
	</table>
	</form>
	
	<br>	<br>  <br>
	
	<form name="form2" method="post" action="03proc2.jsp">
	<table border="1">
	<tr>
	<td>영화제목</td>
	<td><input type="text"	name="movName" value=""></td>
	</tr>
	<tr>
	<td>지역</td>
	<td><input type="text"	name="country" value=""></td>
	</tr>
	<tr>
	<td colspan="2" align="center"><input type="submit" value="조회하기"></td>
	</tr>
	</table>
	</form>
	
	
	
	
	
</body>
</html>