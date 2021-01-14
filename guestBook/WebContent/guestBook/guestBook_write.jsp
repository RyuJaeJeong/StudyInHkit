<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="gbookfrm">
<h2 align="center">방명록 작성</h2>
	<table border="1" align="center">
                    <tr style="width: 500px;">
                        <td style="width: 100px;">이름</td>
                        <td><input type="text" name="name" value=""></td>
                    </tr>

                    <tr style="width: 500px;">
                        <td>이메일</td>
                        <td><input type="text" name="email" value=""></td>
                    </tr>

                    <tr style="width: 500px;">
                        <td>비밀번호</td>
                        <td><input type="text" name="passwd" value=""></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                        	<textarea style="width: 266px; height: 100px;" name="content"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <button type="button" onclick="move('o')">확인</button> 
                            <button type="button" onclick="move('x')">취소</button>
                        </td>
                    </tr>
    </table>
</form>
</body>
</html>

<script>

function move(value1) {
	if(value1=='o') {
		alert('등록되었습니다.');
		gbookfrm.method='post';
		gbookfrm.action='guestBook_writeProc.jsp';
		gbookfrm.submit();
	}else {
		history.back();
	}
	
}

</script>