<%@page import="src.board.model.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %> 

<%
BoardDAO dao = new BoardDAO();

String no_ = request.getParameter("no");
int no = Integer.parseInt(no_);

int result = dao.getDel(no);

if(result>0) {
out.println("<script>");
out.println("alert('삭제되었습니다.');");
out.println("location.href='list.jsp';");
out.println("</script>");
}else {
out.println("<script>");
out.println("alert('삭제에 실패하였습니다..');");
out.println("location.href='view.jsp?no="+no+"';");
out.println("</script>");
}

%>