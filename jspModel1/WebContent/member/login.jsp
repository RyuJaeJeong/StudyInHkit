<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form name=loginFrm>

<table align="center">
	<tr>
		<td>아이디</td>
		<td><input type="text" name="logInid" value=""></td>
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


