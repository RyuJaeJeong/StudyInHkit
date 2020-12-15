<%@page import="member.MemberAdminDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<% 
String id = request.getParameter("id");
String pass = request.getParameter("pass");

MemberAdminDAO dao = new MemberAdminDAO();
dao.logIn(id);


%>