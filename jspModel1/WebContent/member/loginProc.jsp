<%@page import="etc.member.memberDTO"%>
<%@page import="etc.member.memberDAOImplOracle"%>
<%@page import="etc.member.memberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>

<%  
String logInId = request.getParameter("logInid");
String logInPass = request.getParameter("logInPass");
memberDAO dao = new memberDAOImplOracle();
String passwd = dao.getLogin(logInId);

memberDTO dto = dao.getSelectOne(logInId);
int counter = dto.getLoginFailCounter();
System.out.println(counter);
String cookId = null;

if(counter>3) {
	out.println("<script>");
	out.println("alert('로그인 연속실패!');");
	out.println("history.back();");
	out.println("</script>");
	return;		//아랫것을 실행안하고 끊어버린다. 
}
	
if(logInPass.equals(passwd)) {
	dao.counterReset(logInId);
	session.setAttribute("cookId", logInId);
	out.println("<script>");
	out.println("alert('정상적으로 로그인되었습니다.');");
	out.println("location.href='list.jsp'");
	out.println("</script>");
}else {
	dao.counterPlus(logInId);
	System.out.println("여기까지는 왔나");
	out.println("<script>");
	out.println("alert('아이디 또는 비밀번호가 다릅니다.');");
	out.println("location.href='login.jsp'");
	out.println("</script>");
		
}

%>