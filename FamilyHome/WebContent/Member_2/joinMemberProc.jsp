<%@page import="member_2.joinMemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="dto" class="member_2.joinMemberDTO" scope="page"></jsp:useBean>
<jsp:setProperty name="dto" property="*"/>

<% 
joinMemberDAO dao = new joinMemberDAO();

int result = dao.setInsert(dto);
if(result>0) {
	out.println("<script>");
	out.println("alert('정상처리 되었습니다.');");
	out.println("location.href='joinMemberList.jsp';");
	out.println("</script>");
}else {
	out.println("<script>");
	out.println("alert('정상처리 되지 않았습니다.');");
	out.println("location.href='joinMemberForm.jsp';");
	out.println("</script>");
}



%>