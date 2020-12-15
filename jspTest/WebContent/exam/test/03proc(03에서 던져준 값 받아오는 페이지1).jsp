<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	int age =Integer.parseInt(request.getParameter("age"));
	String name = request.getParameter("nme");
	out.println("당신의 이름은 " + name+ "입니다.");
	out.println("당신의 만 나이는 "+(age-1)+"입니다.");
%>   