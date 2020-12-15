<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <table border="1" align="center">
    <%
    String temp = request.getParameter("no");
    int sik = Integer.parseInt(temp);
    for(int i=1; i<=9; i++) {%>
    	<tr>
    	<td><%=i%></td>
    	<td><%=sik*i%></td>
    	</tr>
   <%}%>
   </table>