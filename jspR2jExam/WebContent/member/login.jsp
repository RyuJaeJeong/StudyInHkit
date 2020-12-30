<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file = "../include/include_ipcheck.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>로그인페이지</title>
</head>
<body>

<form name=loginFrm>

<table align="center" border="1">
	<tr>
		<td>아이디</td>
		<td><input type="text" name="logInId" value=""></td>
	</tr>
	<tr>	
		<td>비밀번호</td>
		<td><input type="text" name="logInPass" value=""></td>
	</tr>
	<tr>	
		<td colspan="2" align="center"><input type="button" onclick="login()" value="로그인"></td>
	</tr>
</table>

</form>

</body>
</html>

<script>
function login() {
	loginFrm.method="post";
	loginFrm.action="loginProc.jsp";
	loginFrm.submit();
}


</script>
