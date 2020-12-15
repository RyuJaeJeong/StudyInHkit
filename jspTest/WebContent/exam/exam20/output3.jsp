<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page import= "test.TestDTO30" %>

<%
String id = request.getParameter("id");
String passwd = request.getParameter("passwd");
String nme = request.getParameter("nme");
String email = request.getParameter("email");
String mobile = request.getParameter("mobile");

TestDTO30 t3 = new TestDTO30();

t3.setId(id);
t3.setPasswd(passwd);
t3.setNme(nme);
t3.setEmail(email);
t3.setMobile(mobile);

t3.display();

%>
