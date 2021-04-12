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

<h1>로그인 예습2</h1>
<form>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id"  id="id"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="passwd"  id="passwd"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email"  id="email"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="button" id="btnClick">
					로그인
				</button>
			</td>
		</tr>
	</table>
</form>


</body>
</html>

<div id="result" style="border: 1px solid black; height: inherit;"></div>


<script>

$(document).ready(function(){
	$("#btnClick").click(function(){		
		var id = $("#id").val();
		var passwd = $("#passwd").val();
		var email = $("#email").val();
		var param = "id="+id+"&passwd="+passwd+"&email="+email;
		//alert(param);
			$.ajax({
				type: "post",
				data: param,
				url: "test09Proc.do",
				success: function(data) {
					$("#result").html("id: " + data.id+", passwd: " + data.passwd + ", email: " + data.email);
				}
			});
	});	
});


</script>