<%@page import="src.board.model.dao.BoardDAO"%>
<%@page import="src.board.model.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8"); %>

<%

String no_ = request.getParameter("no");
int no = Integer.parseInt(no_);
BoardDAO dao = new BoardDAO();
BoardDTO dto = dao.getSelectOne(no);
int num = dto.getNum();
String jakseongja = dto.getJakseongja();

String subject= "";
subject += "[Re]";
subject += dto.getSubject();

String content = "";
content += "[원본글]\n";
content += dto.getContent();
content += "\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ\n";


String email = dto.getEmail();
String passwd = dto.getPasswd();
int ref = dto.getRef();
int re_step = dto.getRe_step();
int re_level = dto.getRe_level();


int hit = dto.getHit();
String wdate = dto.getWdate();


%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form name="ansForm">
<input type="hidden" name = "no"value="<%=no%>">
	<table align="center" border="1">
	        <tr>
	            <td>작성자</td>
	            <td><input type="text" name="jakseongja" value=""></td>
	        </tr>
	        <tr>
	            <td>제목</td>
	            <td><input type="text" name="subject" value="<%=subject%>"></td>
	        </tr>
	        <tr>
	            <td colspan="2"><textarea name="content" style="width: 200px; height: 100px;"><%=content %></textarea></td>
	        </tr>
	        <tr>
	            <td>이메일</td>
	            <td><input type="text" name="email" value=""></td>
	        </tr>
	        <tr>
	            <td>비밀번호</td>
	            <td><input type="text" name="passwd" value=""></td>
	        </tr>
	        <tr>
	            <td colspan="2" align="center"><a href="#" onclick="chuga();">[답글달기]</a></td>
	        </tr>
	    </table>
</form>


</body>
</html>


<script>
function chuga() {
	if(confirm('등록하시겠습니까')) {
		ansForm.method="post";
		ansForm.action="writeProc.jsp?";
		ansForm.submit();
	}
}
</script>