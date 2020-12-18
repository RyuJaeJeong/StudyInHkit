<%@page import="model.member.MemberDAOImplOracle"%>
<%@page import="model.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id = "dto" class="model.member.MemberDTO" scope="page"></jsp:useBean>>
<jsp:setProperty name="dto" property="*"/>

<%

MemberDAO dao = new MemberDAOImplOracle();

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