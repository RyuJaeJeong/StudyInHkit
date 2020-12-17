<%@page import="jspInterface_member.jspInterface_memberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id = "dto" class="jspInterface_member.jspInterface_memberDTO" scope="page"></jsp:useBean>>
<jsp:setProperty name="dto" property="*"/>

<%

jspInterface_memberDAO dao = new jspInterface_memberDAO();

int result = dao.getUpdate(dto);

if(result>0) {
	out.println("<script>");
	out.println("alert('수정성공');");
	out.println("location.href = 'list.jsp';");
	out.println("</script>");
}else {
	out.println("<script>");
	out.println("alert('수정실패');");
	out.println("location.href = 'join.jsp';");
	out.println("</script>");
}


%>