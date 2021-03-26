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
	
	

		<form>
			<h3 align="center">메모장</h3>
			<table align="center">
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" id="name" value="${dto.name}"> </td>
				</tr>
				<tr>
					<td>한줄메모</td>
					<td><input type="text" name="content" id="content" value="${dto.content}"> </td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					
					
							<button type="button" id="btnModify" >수정하기</button>
						
						
							<button type="button" id="btnSave">추가하기</button>
						
					
					
					
					
					
						
					</td>
				</tr>
			</table>
		</form>
		
</body>
</html>

<script>

	$(document).ready(function(){
		$("#name").focus();
		$("#btnSave").click(function(){
			if(confirm('메모를 등록하시겠습니까?')) {
				suntaek_proc('chugaProc', '1', '');
			}
		});
		$("#btnModify").click(function(){
			if(confirm('메모를 등록하시겠습니까?')) {
				suntaek_proc('sujungProc', '', '${dto.id}');
			}
		});
		
		$("#btnModify").css("display","none");
		$("#btnSave").css("display","");
		
	});
	

</script>
