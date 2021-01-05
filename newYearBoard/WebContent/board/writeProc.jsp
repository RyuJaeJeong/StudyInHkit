<%@page import="src.board.model.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="dto" class="src.board.model.dto.BoardDTO" scope="page"></jsp:useBean>
<jsp:setProperty name="dto" property="*"/>

<% 

BoardDAO dao = new BoardDAO();
String jakseongja = request.getParameter("jakseongja");
System.out.println(jakseongja);
int num = dao.getMaxNum() + 1;
int ref = dao.getMaxRef() + 1;
dto.setNum(num);
dto.setRef(ref);

int result = dao.setInsert(dto);

if(result>0) {
	out.println("<script>");
	out.println("alert('입력성공');");
	out.println("location.href = 'list.jsp';");
	out.println("</script>");
}else {
	out.println("<script>");
	out.println("alert('입력실패');");
	out.println("location.href = 'write.jsp';");
	out.println("</script>");
}




%>