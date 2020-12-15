<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<form name="join" method="post" action="">
<h3 align="center">회원가입</h3>
<table align = "center">
<tr>
<td>아이디</td>
<td><input type="text" name="id" value=""></td>
</tr>
<tr>
<td>비밀번호</td>
<td><input type="text" name="pass" value=""></td>
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
<td><input type="text" name="email" value=""></td>
</tr>
<tr>
<td>출생년도</td>
<td><input type="text" name="birthYear" value=""></td>
</tr>
<tr>
<td colspan="2" align="center">
<a href="#" onclick="save();" align="center">[가입하기]</a>
</td>
</tr>
</table>

</form>

<script>
function save() {
	join.method="post";
	join.action="joinProc.jsp";
	join.submit();
}
</script>


</body>
</html>