<%@page import="etc.member.memberDTO"%>
<%@page import="etc.member.memberDAOImplOracle"%>
<%@page import="etc.member.memberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<% 
String cookId = null;
String aname = "";
String anickname = "";
String ajob = "";
String agrade="";

if(session.getAttribute("cookId") == null) {
		out.println("<script>alert('로그인후 이용하세요.'); location.href='login.jsp';</script>");
		%>
	
		<%
	}else {
		cookId = (String)session.getAttribute("cookId");
		memberDAO dao = new memberDAOImplOracle();
		memberDTO dto = dao.getSelectOne(cookId);
		
		 aname = dto.getName();
		 anickname = dto.getNickname();
		 ajob = dto.getJob();
		 agrade = dto.getGrade();
		
		 %>
		
		
		<%}%>