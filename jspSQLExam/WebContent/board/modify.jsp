<%@page import="src.board.model.dto.BoardDTO"%>
<%@page import="src.board.model.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form name="DirForm">

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

	    <table align="center" border="1">
	      	
	        <tr>
	            <td>작성자</td>
	            <td><input type="text" name="jakseongja" value="<%=jakseongja%>"></td>
	        </tr>
	        <tr>
	            <td>제목</td>
	            <td><input type="text" name="subject" value="<%=subject%>"></td>
	        </tr>
	        <tr>
	            <td colspan="2"><textarea name="content" style="width: 200px; height: 100px;"><%=content%></textarea></td>
	        </tr>
	        <tr>
	            <td>이메일</td>
	            <td><input type="text" name="email" value="<%=email%>"></td>
	        </tr>
	        <tr>
	            <td>비밀번호</td>
	            <td><input type="text" name="passwd" value="<%=passwd%>"></td>
	        </tr>
	        <tr>
	            <td colspan="2" align="center"><a href="#" onclick="mod();">[수정하기]</a></td>
	        </tr>
	    </table>
			<input type="hidden" name="no" value="<%=no%>">
	      	<input type="hidden" name="num" value="<%=num%>">
	      	<input type="hidden" name="ref" value="<%=ref%>">
	      	<input type="hidden" name="re_step" value="<%=re_step%>">
	      	<input type="hidden" name="re_level" value="<%=re_level%>">
	      	<input type="hidden" name="hit" value="<%=hit%>">
</form>

</body>
</html>

<script>
function mod() {
	if(confirm('등록하시겠습니까')) {
		DirForm.method="post";
		DirForm.action="modifyProc.jsp";
		DirForm.submit();
	}
}
</script>