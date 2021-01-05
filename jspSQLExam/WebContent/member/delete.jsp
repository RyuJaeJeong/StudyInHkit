<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../include/include_session_check.jsp" %>

<%
MemberDAO dao = new MemberDAO();

int result = dao.getDelete(cookNo);

if(result>0) {
	out.println("<script>");
	out.println("alert('삭제에 성공하였습니다.')");
	out.println("location.href='login.jsp'");
	out.println("</script>");
}else {
	out.println("<script>");
	out.println("alert('삭제에 실패하였습니다.')");
	out.println("location.href='view.jsp?no="+cookNo+"';");
	out.println("</script>");
}


%>