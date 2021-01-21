<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="application_test.model.member.MemberDAO"%>
<%@page import="application_test.model.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>


<%
String cookId =(String)session.getAttribute("cookId");
String passwd = request.getParameter("passwd");
if(passwd==null||passwd.length()==00) {
	out.println("<script>");
	out.println("alert('비밀번호를 입력하세요.');");
	out.println("location.href='change.jsp'");
	out.println("</script>");
}
MemberDTO dto = new MemberDTO();
dto.setId(cookId);
dto.setPasswd(passwd);


MemberDAO dao = new MemberDAO();
String cookDate="";
int result = dao.getUpdate(dto);
String date = "0";

if(result>0) {
	session.setAttribute("cookDate", date );
	out.println("<script>alert('비밀번호가 수정되었습니다.'); location.href='main.jsp';</script>");
}else {
	out.println("<script>");
	out.println("alert('비밀번호수정에 실패하였습니다.');");
	out.println("location.href='change.jsp'");
	out.println("</script>");
}



%>
