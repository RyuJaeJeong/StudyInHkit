<%@page import="Member.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
    
 <jsp:useBean id="dto" class="Member.model.MemberDTO" scope="page"></jsp:useBean>   
 <jsp:setProperty name="dto" property="*"/>
 	
<%
MemberDAO dao = new MemberDAO();

int result = dao.setInsert(dto);

if(result>0) {
	out.println("<script>");
	out.println("alert('가입성공');");
	out.println("location.href = 'login.jsp';");
	out.println("</script>");
}else {
	out.println("<script>");
	out.println("alert('가입실패');");
	out.println("location.href = 'join.jsp';");
	out.println("</script>");
}
 	
 	
 	
%>