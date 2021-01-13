<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align="center">
						<tr>
							<td>아이디</td>
							<td><input type="text" name="loginId" value=""></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="loginPasswd" value=""></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input type="button" value="로그인" onclick="login()"></td>
						</tr>
	</table>
</body>
</html>


<script>
function login() {
	location.href='modify.jsp';
}
</script>