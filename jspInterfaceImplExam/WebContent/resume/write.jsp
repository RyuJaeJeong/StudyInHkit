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

<form name = "writeForm"   enctype="multipart/form-data">
	<table border="1" align="center">
		<tr>
			<td>사진</td>
			<td ><input type = "file" name="file1"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type = "text" name="name"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type = "text" name="email"></td>
		</tr><tr>
			<td>핸드폰</td>
			<td><input type = "text" name="phone"></td>
		</tr><tr>
			<td>주소</td>
			<td><input type = "text" name="address"></td>
		</tr>
		
		<tr>
			<td>토익</td>
			<td><input type = "text" name="TOEIC"></td>
		</tr>
		
		<tr>
			<td>토익</td>
			<td><input type = "text" name="TOEFL"></td>
		</tr>
		
		<tr>
			<td>일본어</td>
			<td><input type = "text" name="japan"></td>
		</tr>
		
		<tr>
			<td>중국어</td>
			<td><input type = "text" name="china"></td>
		</tr>
		<tr>
			<td>기간</td>
			<td><input type = "text" name="gigan1"></td>
		</tr>
		
		<tr>
			<td>학교</td>
			<td><input type = "text" name="school1"></td>
		</tr>
		
		<tr>
			<td>전공</td>
			<td><input type = "text" name="jeongong1"></td>
		</tr>
		<tr>
			<td>기간</td>
			<td><input type = "text" name="gigan2"></td>
		</tr>
		
		<tr>
			<td>학교</td>
			<td><input type = "text" name="school2"></td>
		</tr>
		
		<tr>
			<td>전공</td>
			<td><input type = "text" name="jeongong2"></td>
		</tr>
		<tr>
			<td>기간</td>
			<td><input type = "text" name="gigan3"></td>
		</tr>
		
		<tr>
			<td>학교</td>
			<td><input type = "text" name="school3"></td>
		</tr>
		
		<tr>
			<td>전공</td>
			<td><input type = "text" name="jeongong3"></td>
		</tr>
		<tr>
			<td>기간</td>
			<td><input type = "text" name="gigan4"></td>
		</tr>
		
		<tr>
			<td>학교</td>
			<td><input type = "text" name="school4"></td>
		</tr>
		
		<tr>
			<td>전공</td>
			<td><input type = "text" name="jeongong4"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="button" value="저장하기" onclick="save();"></td>
		</tr>
	</table>
</form>

<script>
function save() {
	if(confirm('저장하시겠습니까?')) {
		writeForm.method = "post";
		writeForm.action = "writeProc.jsp";
		writeForm.submit();
	}
}


</script>
</body>
</html>