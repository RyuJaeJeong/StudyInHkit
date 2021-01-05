<%@page import="src.board.model.dto.BoardDTO"%>
<%@page import="src.board.model.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<% request.setCharacterEncoding("UTF-8"); %>


<%

String num_ = request.getParameter("num");
int num;
if(num_.equals(null)||num_.length()==0) {
	num=0;
}else {
	num=Integer.parseInt(num_);
}

if(num>1000) {
	out.println("종료");
	return;
}

BoardDTO dto = new BoardDTO();



BoardDAO dao = new BoardDAO();






%>




<script>
setTimeout(function() {
	location.href = 'test.jsp?num=<%=num%>';
}, 100);


</script>