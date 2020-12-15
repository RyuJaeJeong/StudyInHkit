<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="dto" class="test.TestDTO20" scope="page"></jsp:useBean>
<jsp:setProperty name="dto" property="*"/>
    
<%
String id = dto.getId();
String passwd = dto.getPasswd();
String nme = dto.getNme();
String email = dto.getMobile();
String mobile = dto.getMobile();


out.println("id:" + id + "<br>");
out.println("passwd:" + passwd + "<br>");
out.println("nme:" + nme + "<br>");
out.println("email:" + email + "<br>");
out.println("mobile:" + mobile + "<br>");
%>    