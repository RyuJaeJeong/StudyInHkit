<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<% 
out.println("아이디: " + request.getParameter("id")+"<br>");
out.println("비밀번호: " + request.getParameter("passwd")+"<br>");
out.println("이름: " + request.getParameter("nme")+"<br>");
out.println("이메일: " + request.getParameter("email")+"<br>");
out.println("전화번호: " + request.getParameter("mobile")+"<br>");
%>