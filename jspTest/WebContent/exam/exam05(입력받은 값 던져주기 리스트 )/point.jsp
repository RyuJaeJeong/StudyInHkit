<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="inputScore" action="pointProc.jsp">
<%for(int i=0; i<3; i++) {%>
<table align="center" border="1">
<tr>
<td>이름</td>
<td><input type="text" name="nme" value=""></td>
</tr>
<tr>
<td>국어</td>
<td><input type="text" name="kor" value=""></td>
</tr>
<tr>
<td>영어</td>
<td><input type="text" name="eng" value=""></td>
</tr>
<tr>
<td>수학</td>
<td><input type="text" name="math" value=""></td>
</tr>
</table>
<br>
<%}%>
<table align="center">
<tr><td><input type="submit"></td></tr>
</table>
</form>

</body>
</html>