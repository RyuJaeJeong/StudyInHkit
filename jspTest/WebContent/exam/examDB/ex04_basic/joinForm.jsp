<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="join" method="post" action="joinProc.jsp"> 
<table align = "center" border="1">
<tr>
<td>아이디</td>
<td><input type="text" name="id" value=""></td>
</tr>
<tr>
<td>비밀번호</td>
<td><input type="text" name="passwd" value=""></td>
</tr>
<tr>
<td>비밀번호확인</td>
<td><input type="text" name="passcheck" value=""></td>
</tr>
<tr>
<td>이름</td>
<td><input type="text" name="nme" value=""></td>
</tr>
<tr>
<td>전화번호</td>
<td><input type="text" name="phone" value=""></td>
</tr>
<tr>
<td>이메일</td>
<td><input type="text" name="mail" value=""></td>
</tr>
<tr>
<td>출생년도</td>
<td><input type="text" name="birth" value=""></td>
</tr>
<tr>
<td colspan="2" align="center"><a href="#" onclick="login()">[가입하기]</a></td>
</tr>
</table>
</form>
<script>
function login() {
	if(confirm('가입하시겠습니까?')) {
		join.method="post";
		join.action="joinProc.jsp";
		join.submit();
	}
}
</script>
</body>
</html>