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

<form name = "writeForm" align="center">
<h3></h3>
사진 : <input type = "text" name="pic">
<br>
이름 : <input type = "text" name="name">
<br>
이메일 : <input type = "text" name="email">
<br>
핸드폰 : <input type = "text" name="phone">
<br>
주소 : <input type = "text" name="address">
<br>
토익 : <input type = "text" name="TOEIC">
<br>
토플 : <input type = "text" name="TOEFL">
<br>
일본어 : <input type = "text" name="japan">
<br>
중국어 : <input type = "text" name="china">
<br>
<br>
기간1 : <input type="text" name="gigan1"><br> 
학교명1 : <input type="text" name="school1"><br> 
전공1 : <input type="text" name="jeongong1"><br> 
<br>
기간2 : <input type="text" name="gigan2"><br> 
학교명2 : <input type="text" name="school2"><br> 
전공2 : <input type="text" name="jeongong2"><br> 
<br>
기간3 : <input type="text" name="gigan3"><br> 
학교명3 : <input type="text" name="school3"><br> 
전공3 : <input type="text" name="jeongong3"><br> 
<br>
기간4 : <input type="text" name="gigan4"><br> 
학교명4 : <input type="text" name="school4"><br> 
전공4 : <input type="text" name="jeongong4"><br> 
<br><br>
<input type="button" value="저장하기" onclick="save();">
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