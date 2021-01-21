<%@page import="application_test.model.member.MemberDAO"%>
<%@page import="application_test.model.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<%
String id = request.getParameter("id");
String passwd = request.getParameter("passwd");
MemberDTO dto = new MemberDTO();
dto.setId(id);
dto.setPasswd(passwd);
MemberDAO dao = new MemberDAO();
String changeDate = dao.getLogin(dto);

String cookDate="";
String cookId = "";
if(changeDate==""||changeDate.length()==0) {
	out.println("<script>");
	out.println("alert('아이디 또는 비밀번호가 다릅니다.');");
	out.println("location.href='login.jsp'");
	out.println("</script>");
}else {
	session.setMaxInactiveInterval(60); //세션 시간 제한. 
	session.setAttribute("cookDate", changeDate);
	session.setAttribute("cookId", id);
	out.println("<script>alert('로그인되었습니다.'); location.href='main.jsp';</script>");
	
}



%>