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
		<h3 align="center">로그인 페이지</h3>
		<table border="1" align="center">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" value=""></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="passwd" value=""></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><button type="button" onclick="login()">로그인</button></td>
			</tr>
			
		</table>
	</form>
	
</body>
</html>

<script>
function login() {
	if(confirm('로그인 하시겠습니까?')) {
		loginFrm.method="post";
		loginFrm.action="loginProc.jsp";
		loginFrm.submit();
		
	}
}

</script>