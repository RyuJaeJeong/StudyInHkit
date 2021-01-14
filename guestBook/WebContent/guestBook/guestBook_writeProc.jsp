<%@page import="guestBook.src.model.dao.guestBookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8");	%>


<jsp:useBean id="dto" class="guestBook.src.model.dto.guestBookDTO" scope="page"></jsp:useBean>
<jsp:setProperty name="dto" property="*"/>

<%

guestBookDAO dao = new guestBookDAO();

int result = dao.setInsert(dto);


if(result>0) {
	out.println("<script>");
	out.println("alert('입력성공');");
	out.println("location.href = 'guestBook_list.jsp';");
	out.println("</script>");
}else {
	out.println("<script>");
	out.println("alert('입력실패');");
	out.println("location.href = 'guestBook_write.jsp';");
	out.println("</script>");
}




%>