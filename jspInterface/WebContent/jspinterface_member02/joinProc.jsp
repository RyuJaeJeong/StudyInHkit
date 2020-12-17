<%@page import="jspInterface_member02.jspInterface_member02DAO"%>
<%@page import="jspInterface_member.jspInterface_memberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id = "dto" class="jspInterface_member02.jspInterface_member02DTO" scope="page"></jsp:useBean>>
<jsp:setProperty name="dto" property="*"/>

<%

jspInterface_member02DAO dao = new jspInterface_member02DAO();

int result = dao.setInsert(dto);

if(result>0) {
	out.println("<script>");
	out.println("alert('가입성공');");
	out.println("location.href = 'list.jsp';");
	out.println("</script>");
}else {
	out.println("<script>");
	out.println("alert('가입실패');");
	out.println("location.href = 'join.jsp';");
	out.println("</script>");
}

%>