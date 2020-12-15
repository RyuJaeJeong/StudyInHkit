<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String name = "홍길동";%>
<table border="1" width="800" align="center">
<tr height="100"> 
<td colspan="2"> 
<jsp:include page="something_top.jsp">
 <jsp:param value="<%=name%>" name="name"/>
</jsp:include>
</td>
</tr>
<tr height="300">
<td>&nbsp</td>
<td>&nbsp</td>
</tr>
<tr height="200">
	<td colspan="2">
		<%@ include file="somthing_bottom.jsp"%>
	</td>
</tr>
</table>
