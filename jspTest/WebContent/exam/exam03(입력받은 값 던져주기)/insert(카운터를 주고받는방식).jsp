<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="format" method="post" action="receipt.jsp">
<table border="1">
	<tr>
		<td width="30">no</td>
		<td width="200">상품이름</td>
		<td width="100">상품가격</td>
	</tr>
	<%
	int counter = 0;
	for(int i=0; i<3; i++) {
	%>
		<tr>
			<td width="30"><%=i%></td>
			<td width="200"><input type="text" name="prod_nme<%=i%>" value="" width="200"></td>
			<td width="100"><input type="text" name="prod_price<%=i%>" value="" width="100"></td>
		</tr>
	<% 
		counter++;
	   } 
	%>
	<input type="hidden" name="counter" value="<%=counter%>">
	
	<tr>
		<td colspan="3" align="center"><input type="submit"></td>
	</tr>

</table>
</form>



</body>
</html>
<%-- 입력받아서 영수증 찍기 --%>

