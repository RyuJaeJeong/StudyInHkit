<%@page import="etc.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../include/include_ipcheck.jsp" %>
<%
String id = request.getParameter("id");
System.out.println(id);
MemberDAO dao = new MemberDAO();

int result = dao.getDel(id);

if(result>0){
	out.println("<script>");
	out.println("alert('삭제가 완료되었습니다.')");
	out.println("location.href ='logout.jsp'");
	out.println("</script>");
	}else {
		out.println("<script>");
		out.println("alert('삭제에 실패하었습니다.')");
		out.println("location.href ='view.jsp?id="+id+"';");
		out.println("</script>");	
	}

%>