<%@page import="java.net.Inet4Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>

<% 
String ip = Inet4Address.getLocalHost().getHostAddress();   //ip불러오기	

if(!ip.equals("220.94.19.115")) {
		out.println("<script>alert('접근권한이 할당된 ip가 아닙니다.');location.href = 'login.jsp';</script>");
}
	
%>