<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<%@ include file="../include/include_session_check.jsp" %>

<jsp:useBean id="dto" class="Member.model.MemberDTO" scope="page"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>

 

<%
String gender = dto.getGender();
if(gender==null) {
	out.println("<script>");
	out.println("alert('성별을 체크하세요')");
	out.println("location.href='modify.jsp'");
	out.println("</script>");
}
%>

<%
dto.setNo(cookNo);

MemberDAO dao = new MemberDAO();

int result = dao.getUpdate(dto);

if(result>0) {
	out.println("<script>");
	out.println("alert('수정에 성공하였습니다.')");
	out.println("location.href='view.jsp?no="+cookNo+"';");
	out.println("</script>");
}else {
	out.println("<script>");
	out.println("alert('수정에 실패하였습니다.')");
	out.println("location.href='modify.jsp'");
	out.println("</script>");
}



%>