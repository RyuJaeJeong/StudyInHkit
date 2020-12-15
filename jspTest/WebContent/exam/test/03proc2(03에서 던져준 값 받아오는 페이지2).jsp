<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<%
String movName = request.getParameter("movName");
String count = request.getParameter("country");
%>

영화제목은 <%=movName%>입니다. <br>
상영관은 <%=count%>입니다. 