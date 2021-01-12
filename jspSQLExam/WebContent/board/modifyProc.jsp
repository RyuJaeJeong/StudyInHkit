<%@page import="src.board.model.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="dto" class="src.board.model.dto.BoardDTO" scope="page"></jsp:useBean>
<jsp:setProperty name="dto" property="*"/>

<%
BoardDAO dao = new BoardDAO();

int result = dao.getUpdate(dto);

if(result>0) {
out.println("<script>");
out.println("alert('삭제되었습니다.');");
out.println("location.href='list.jsp';");
out.println("</script>");
}else {
out.println("<script>");
out.println("alert('삭제에 실패하였습니다..');");
out.println("location.href='view.jsp?no="+dto.getNo()+"';");
out.println("</script>");
}



%>