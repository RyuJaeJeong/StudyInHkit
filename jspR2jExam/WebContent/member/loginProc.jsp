<%@page import="etc.member.MemberDTO"%>
<%@page import="etc.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file = "../include/include_ipcheck.jsp" %>

<%
String logInId = request.getParameter("logInId");
String logInPass = request.getParameter("logInPass");
MemberDAO dao = new MemberDAO();
String passwd = dao.getLogin(logInId);
String cookId = null;

MemberDTO dto = dao.getSelectOne(logInId);
int counter = dto.getLoginFailCounter();
System.out.println(counter);

if(counter>4) {
	out.println("<script>");
	out.println("alert('로그인 연속실패!');");
	out.println("history.back();");
	out.println("</script>");
	return;		//아랫것을 실행안하고 끊어버린다. 
}

if(!passwd.equals("")&&logInPass.equals(passwd)) {
	dao.counterReset(logInId);
	session.setAttribute("cookId", logInId);
	out.println("<script>");
	out.println("alert('정상적으로 로그인되었습니다.');");
	out.println("location.href='list.jsp'");
	out.println("</script>");
}else {
	dao.counterPlus(logInId);
	out.println("<script>");
	out.println("alert('아이디 또는 비밀번호가 다릅니다.');");
	out.println("location.href='login.jsp'");
	out.println("</script>");
		
}





%>
