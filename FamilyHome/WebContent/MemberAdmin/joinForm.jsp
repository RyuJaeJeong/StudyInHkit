<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="join">
		<table style="border: 1px solid black; margin-top: 300px;" align="center" width="350" height="300">
			<tr>
				<td>
				&nbsp;&nbsp;이름
				</td>
				<td>
				<input type="text" name="nme" value="" >
				</td>
			</tr>
			<tr>	
				<td>
				&nbsp;&nbsp;아이디
				</td>
				<td>
				<input type="text" name="id" value="">
				</td>
			</tr>
			<tr>	
				<td>
				&nbsp;&nbsp;비밀번호
				</td>
				<td>
				<input type="password" name="pass" value="">
				</td>
			</tr>
			<tr>	
				<td>
				&nbsp;&nbsp;비밀번호 확인
				</td>
				<td>
				<input type="password" name="passck" value="">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<a href="#" onclick="goJoin()"><img src="가입하기.png" height="100"></a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>

<script>
function goJoin() {
	if(confirm('가입하시겠습니까?')){
		join.method="post";
		join.action="joinProc.jsp";
		join.submit();
	}
}



</script>
