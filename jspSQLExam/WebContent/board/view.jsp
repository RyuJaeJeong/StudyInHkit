<%@page import="src.board.model.dto.BoardDTO"%>
<%@page import="src.board.model.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<%

String no_ = request.getParameter("no");
int no = Integer.parseInt(no_);

BoardDAO dao = new BoardDAO();

BoardDTO dto = dao.getSelectOne(no);

int num = dto.getNum();
String jakseongja = dto.getJakseongja();
String subject = dto.getSubject();
String content = dto.getContent();
String email = dto.getEmail();
String passwd = dto.getPasswd();
int ref = dto.getRef();
int re_step = dto.getRe_step();
int re_level = dto.getRe_level();
int hit = dto.getHit();
String wdate = dto.getWdate();






%>
<form>
	<table border="1" width="600" align="center">
		<tr>
			<td width="300px">순번 : <%=num%></td>
		</tr>
		<tr>
			<td>작성자 : <%=jakseongja%></td>
		</tr>
		<tr>
			<td>등록일 : <%=wdate%></td>
		</tr>
		<tr>
			<td>조회수 : <%=hit%></td>
		</tr>
		<tr>
			<td><%=subject%></td>
		</tr>
		<tr>
			<td style="width:500px; height:200px;"><%=content%></td>
		</tr>
		<tr>
			<td>
			<a href="#" onclick="move('m',<%=no%>)">[수정하기]</a>
			<a href="#" onclick="move('d',<%=no%>)">[삭제하기]</a>
			<a href="#" onclick="move('w',<%=no%>)">[답글달기]</a>
			</td>
		</tr>
	</table>

</form>






<script>
function move(value1, value2) {
	if(value1=='m') {
		location.href='modify.jsp?no='+value2
	}else if(value1=='d') {
		location.href='delete.jsp?no='+value2
	}else if(value1=='w') {
		location.href='answer.jsp?no='+value2
	}
	
}

</script>