<%@page import="java.net.Inet4Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>

<% 
String ip = Inet4Address.getLocalHost().getHostAddress();
	//out.println("ip : " + ip+"<HR>");
	/*
	if(!ip.equals("118.45.204.179")) {
		out.println("<script>alert('접근불가');</script>");
	}*/
	
%>