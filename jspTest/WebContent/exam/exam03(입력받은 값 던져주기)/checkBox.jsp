<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="form" method="post" action=foodProc.jsp>
<table border="1" width="500">
	<tr>
		<td>
		<input type = "checkbox" name="food" value="붕어빵">붕어빵&nbsp;&nbsp;
		<input type = "checkbox" name="food" value="소주">소주&nbsp;&nbsp;
		<input type = "checkbox" name="food" value="맥주">맥주&nbsp;&nbsp;
		<input type = "checkbox" name="food" value="막걸리">막걸리&nbsp;&nbsp;
		<input type = "checkbox" name="food" value="와인">와인&nbsp;&nbsp;
		<input type = "checkbox" name="food" value="양주">양주&nbsp;&nbsp;
		</td>
	</tr>
	<tr>
		<td align="center" height="40"><input type="submit"></td>
	</tr>	
</table>
</form>
</body>
</html>