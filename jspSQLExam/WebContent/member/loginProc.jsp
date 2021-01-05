<%@page import="Member.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<%
String loginId = request.getParameter("loginId");
String loginPasswd = request.getParameter("loginPasswd");

MemberDAO dao = new MemberDAO();

int result = dao.getLogin(loginId, loginPasswd);

int cookNo = 0;

if(result>0) {
	session.setAttribute("cookNo", result);		//세션등록
	out.println("<script>alert('로그인되었습니다.'); location.href='list.jsp';</script>");
}else {
	out.println("<script>");
	out.println("alert('아이디 또는 비밀번호가 다릅니다.');");
	out.println("location.href='login.jsp'");
	out.println("</script>");
}

%>


<%

//세션 (sessiont)  -  서버에 저장, 보안우수

//쿠키(cookie)  -  클라이언트pc, 보안취햑


%>