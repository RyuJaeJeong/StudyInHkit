<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>파일 업로드</h2>
<form name="formal" method="post" enctype="multipart/form-data" <%--짧게 짧게 잘라서 보낸다 --%> action="uploadProc.jsp">
이름 : <input type="text" name="name" value=""><br>
연락처 : <input type="text" name="phone" value=""><br>
사진 : <input type="file" name="file1"><br>
사진2 : <input type="file" name="file2"><br>
<input type="submit" value="확인">
</form>
</body>
</html>