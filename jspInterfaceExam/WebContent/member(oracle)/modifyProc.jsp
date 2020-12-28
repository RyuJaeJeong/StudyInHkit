<%@page import="jspInterfaceExam.model.member.MemberDAO"%>
<%@page import="jspInterfaceExam.model.member.MemberDAOImplOracle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id = "dto" class="jspInterfaceExam.model.member.MemberDTO" scope="page"></jsp:useBean>>
<jsp:setProperty name="dto" property="*"/>

<%

MemberDAO dao = new MemberDAOImplOracle();

int result = dao.getUpdate(dto);
String id = dto.getId();

if(result>0) {
	out.println("<script>");
	out.println("alert('수정성공');");
	out.println("location.href = 'list.jsp';");
	out.println("</script>");
}else {
	out.println("<script>");
	out.println("alert('수정실패');");
	out.println("location.href = 'modify.jsp?id="+id+"';");
	out.println("</script>");
}


%>