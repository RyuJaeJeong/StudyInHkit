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
			<td>
				<input type="password" name="checkPass" id="checkPass" value="">
			</td>
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
	$("#btnDelete").click(function(){
		location.href="deleteProc.do?id=${dto.id}&checkPass="+$("#checkPass").val();	
	});
});


</script>