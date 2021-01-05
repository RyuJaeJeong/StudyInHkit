<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="loginFrm">
		<table border="1" align="center">
			
			<tr>
				<td>
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
				</td>
			</tr>
			<tr>
				<td colspan="2"><%@ include file="../include/include_bottom.jsp" %></td>
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