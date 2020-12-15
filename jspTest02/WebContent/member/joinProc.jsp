
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="dto" class="member.MemberDTO" scope="page"></jsp:useBean>
<jsp:setProperty name="dto" property="*"/>

<%@ page import ="member.MemberDAO" %>

<%

MemberDAO dao = new MemberDAO();
int result = dao.setInsert(dto);
System.out.println(result);
out.println(result);
if(result>0) {
	out.println("<script>");
	out.println("alert('가입이 완료되었습니다.')");
	out.println("location.href ='join.jsp'");
	out.println("</script>");
}else {
	out.println("<script>");
	out.println("alert('가입이 완료되지 않았습니다.')");
	out.println("location.href ='join.jsp'");
	out.println("</script>");
}
%>