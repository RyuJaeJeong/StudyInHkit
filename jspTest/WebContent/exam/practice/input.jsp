<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Input channel</title>
</head>
<body>
<form name="frm" action="output.jsp">
	<% for(int i=1; i<=3; i++) {%>
	<table border="1" align="center">
		<tr>
			<td>상품이름</td>
			<td><input type="text" name="nme<%=i%>" value=""></td>
		</tr>
		<tr>
			<td>상품가격</td>
			<td><input type="text" name="pri<%=i%>" value=""></td>
		</tr>
	</table>
	<br>
	<%}%>
	<table align="center">
	<tr>
	<td colspan="2" align="center"><input type="submit" name="출력"></td>
	</tr>
	</table>
</form>
</body>
</html>