<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../include/inc_menu.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>회원등록</h2>
	<form name="formal" method="post" action="member/memberChugaProc.do">
		<table border="1" width="400">
			<tr>
				<td width="150">아이디</td>
				<td>
					<input type="text" name="id" id="id" value="">
				</td>
			</tr>
			<tr>
				<td width="150">비밀번호</td>
				<td><input type="password" name="passwd" value=""></td>
			</tr>
			<tr>
				<td width="150">이름</td>
				<td><input type="text" name="name" value=""></td>
			</tr>
			<tr>
				<td width="150">이메일</td>
				<td><input type="text" name="email" value=""></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit" onclick="submit">
						가입하기
					</button>
				</td>
			</tr>
		</table>
	</form>
	
	
</body>
</html>