<%@page import="member.MemberAdminDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="dto" class="member.MemberAdminDTO" scope="page"></jsp:useBean>
<jsp:setProperty name="dto" property="*"/>

<%

MemberAdminDAO dao = new MemberAdminDAO();
int result = dao.setInsert(dto);
if(result>0) {
	out.println("<script>");
	out.println("alert('가입이 완료되었습니다.')");
	out.println("location.href ='temp.jsp'");
	out.println("</script>");
}else{
	out.println("<script>");
	out.println("alert('가입이 완료되지 않았습니다.')");
	out.println("location.href ='joinForm.jsp'");
	out.println("</script>");
}


%>
