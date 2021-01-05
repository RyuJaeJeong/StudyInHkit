<%@page import="src.board.model.dto.BoardDTO"%>
<%@page import="src.board.model.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>

<%

String num_=request.getParameter("num");
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
num+=1;
num_ = Integer.toString(num);
dto.setNum(num);
dto.setJakseongja(num_);
dto.setSubject(num_);
dto.setContent(num_);
dto.setEmail(num_);
dto.setPasswd(num_);
dto.setRef(num);

BoardDAO dao = new BoardDAO();

int result = dao.setInsert(dto);

System.out.println(num);




%>




<script>
setTimeout(function() {
	location.href = 'pageMakerProc.jsp?num=<%=num%>';
}, 500);


</script>