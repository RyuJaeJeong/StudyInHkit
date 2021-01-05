<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form name="joinFrm">
<table border="1"  align="center">

	<tr>
		<td colspan="2"><%@ include file="../include/include_menu.jsp" %></td>
		
	</tr>
	
	<tr>
		<td>
			<table align="center" >
			<tr>
				<td colspan="2">&nbsp;</td>
				
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
				
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
				
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" value=""></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="passwd" value=""></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="text" name="passwdChk" value=""></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value=""></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
				<input type="radio" name="gender" value="남자">남자
				<input type="radio" name="gender" value="여자">여자
				</td>
			</tr>
			<tr>
				<td>출생연도</td>
				<td><input type="text" name="bornYear" value=""></td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
				
			</tr>
			<tr>
				<td colspan="2" align = "center"><a href="#" onclick="join()">[가입하기]</a></td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
				
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
				
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
				
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
function join() {
	if(confirm('가입하시겠습니까?')) {
		joinFrm.method="post";
		joinFrm.action="joinProc.jsp";
		joinFrm.submit();
	}
}
</script>