<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/inc_header.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	
<script>
$(document).ready(function(){
	$('#btnSave').click(function(){
		insert();	
	});
});

function insert() {
	var name = $("#name").val();
	var content = $("#content").val();
	var param = "name="+name +"&content="+content;
	
	$.ajax({
		type: "post",
		data: param,
		url:"${path}/memo_servlet/writeProc.do",
		success:function() {
			$("#name").val("");
			$("#content").val("");
		}
	});
	
}


</script>

		<form>
			<h3 align="center">메모장</h3>
			<table align="center">
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" id="name" value=""> </td>
				</tr>
				<tr>
					<td>한줄메모</td>
					<td><input type="text" name="content" id="content" value=""> </td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<br/><input type="button" id="btnSave" value="확인">
					</td>
				</tr>
			</table>
		</form>
		
</body>
</html>

