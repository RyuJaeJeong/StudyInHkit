<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="frm" action=sellProc.jsp>
	<table>
		<tr>
			<td>no</td>
			<td>상품이름</td>
			<td>상품가격</td>
		</tr>
		<%
		int counter = 0;
		for(int i=0; i<3; i++) {
		%>
		<tr>
			<td><%=i+1%></td>
			<td><input type="text" name="nme<%=i%>"></td>
			<td><input type="text" name="price<%=i%>"></td>
		</tr>
		<%
		counter++;
		}
		%>
		<tr>
			<td colspan="3" align="center"><input type="submit"></td>
			<input type="hidden" name="counter" value="<%=counter%>">
		</tr>
		
	</table>
</form>
</body>
</html>