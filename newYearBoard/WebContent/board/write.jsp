<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form name="DirForm">

	    <table align="center" border="1">
	      	
	        <tr>
	            <td>작성자</td>
	            <td><input type="text" name="jakseongja" value=""></td>
	        </tr>
	        <tr>
	            <td>제목</td>
	            <td><input type="text" name="subject" value=""></td>
	        </tr>
	        <tr>
	            <td colspan="2"><textarea name="content" style="width: 200px; height: 100px;"></textarea></td>
	        </tr>
	        <tr>
	            <td>이메일</td>
	            <td><input type="text" name="email" value=""></td>
	        </tr>
	        <tr>
	            <td>비밀번호</td>
	            <td><input type="text" name="passwd" value=""></td>
	        </tr>
	        <tr>
	            <td colspan="2" align="center"><a href="#" onclick="chuga();">[등록하기]</a></td>
	        </tr>
	    </table>


</form>

</body>
</html>

<script>
function chuga() {
	if(confirm('등록하시겠습니까')) {
		DirForm.method="post";
		DirForm.action="writeProc.jsp";
		DirForm.submit();
	}
}
</script>