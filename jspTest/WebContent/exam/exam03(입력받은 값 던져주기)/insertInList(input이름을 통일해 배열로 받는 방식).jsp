<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="format" action="receiptOfList.jsp">
		<table>
			<tr>
				<td>상품이름</td>
				<td>상품가격</td>
			</tr>
		
		<%
		for(int i=0; i<3; i++) {
		%>
			<tr>
				<td><input type="text" name="nme" value=""></td>
				<td><input type="text" name="price" value=""></td>
			</tr>
		<%}%>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="출력"></td>
			</tr>
		</table>
	</form>
</body>
</html>