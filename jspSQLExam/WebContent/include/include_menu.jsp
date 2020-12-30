<%@page import="java.net.Inet4Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/include_session_check.jsp" %>

<table border="0" align="center" width="1000">
	<tr>
		<th height="30">HOME</th>
		<th>회원관리</th>
		<th>게시판</th>
		<th>
		<%if(cookNo == 0) { %>
		<a href="login.jsp">로그인</a>
		<%} else {  %>
		<a href="logout.jsp">로그아웃</a>(<%=sName%>)
		<%}%>
		</th>
		<th><%=ip%></th>
	</tr>


</table>

