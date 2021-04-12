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
	<c:if test="${menu_gubun=='member_chuga'}">
		<h2>회원등록</h2>
	</c:if>
	<c:if test="${menu_gubun=='member_update'}">
		<h2>회원수정</h2>
	</c:if>
	
	<c:if test="${menu_gubun=='member_chuga'}">
		<form name="formal" method="post" action="memberChugaProc.do">				
	</c:if>
	<c:if test="${menu_gubun=='member_update'}">
		<form name="formal" method="post" action="memberUpdateProc.do">
	</c:if>
	
	
		<table border="1" width="400">
			<tr>
				<td width="150">아이디</td>
				<td>
					<c:if test="${menu_gubun=='member_chuga'}">
						<input type="text" name="id" id="id" value="${dto.id}">				
					</c:if>
					<c:if test="${menu_gubun=='member_update'}">
						<input type="text" name="id" id="id" value="${dto.id}" readonly>
					</c:if>
					
				</td>
			</tr>
			<tr>
				<td width="150">비밀번호</td>
				<td><input type="password" name="passwd" id="passwd" value="${dto.passwd}"></td>
			</tr>
			<tr>
				<td width="150">이름</td>
				<td><input type="text" name="name" id="name" value="${dto.name}"></td>
			</tr>
			<tr>
				<td width="150">이메일</td>
				<td><input type="text" name="email" id="email" value="${dto.email}"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					
					<c:if test="${menu_gubun=='member_chuga'}">
						<button type="submit">
							가입하기
						</button>
					</c:if>
					<c:if test="${menu_gubun=='member_update'}">
						<button type="submit">
							수정하기
						</button>
					</c:if>
				
					
				</td>
			</tr>
		</table>
	</form>
	
	
</body>
</html>