<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/inc_menu.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1" align="center" width="80%">



	<tr>
		<td colspan="10"><h2>회원정보 상세보기</h2></td>
	</tr>

		
		<tr>
			<td>아이디</td>	
			<td>${dto.id }</td>
		</tr>	
		<tr>
			<td>비밀번호</td>	
			<td>${dto.passwd}</td>
		</tr>
		<tr>
			<td>이름</td>	
			<td>${dto.name}</td>
		</tr>
		<tr>
			<td>이메일</td>	
			<td>${dto.email}</td>
		</tr>
		<tr>
			<td>가입일</td>
			<td>${dto.regi_date}</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="button" id="btnModify">
					수정하기
				</button>
				<button type="button" id="btnDelete">
					삭제하기
				</button>
			</td>
		</tr>

</table>



</body>
</html>


<script>

$(document).ready(function(){
	$("#btnModify").click(function(){
		location.href="update.do?id=${dto.id}"	
	});
	
	$("#btnDelete").click(function(){
		location.href="delete.do?id=${dto.id}"	
	});
});


</script>