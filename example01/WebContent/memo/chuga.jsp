<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello, smart!</title>
</head>
<body>
	<h3 align="center">메모장</h3>
	<form>	
		<table border="1" align="center">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" id="name" value=""></td>
			</tr>
			<tr>
				<td>메모</td>
				<td>
					<input type="text" name="content" id="content" value="">
					<button type="button" id="btnSave">확인</button>
				</td>
			</tr>
		</table>
		<br><br/>
	</form>
</body>
</html>

<script>
$(document).ready(function(){
	$("#btnSave").click(function(){
		GoChugaProc();
	});
	
});

</script>