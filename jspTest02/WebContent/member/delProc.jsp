<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page import ="member.MemberDAO" %>

<% 
MemberDAO dao = new MemberDAO();
String dbid = request.getParameter("id");
int result = dao.delete(dbid);

if(result>0) {
	out.println("<script>");
	out.println("alert('삭제가 완료되었습니다.')");
	out.println("location.href ='joinList.jsp'");
	out.println("</script>");
}else {
	out.println("<script>");
	out.println("alert('삭제가 완료되지 않았습니다.')");
	out.println("location.href ='join.jsp'");
	out.println("</script>");
}

%>