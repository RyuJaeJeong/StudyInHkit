<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>familyName</title>
</head>
<body>
	<form name="form" method="post" action="familyProc.jsp">
		<table border="1">
			<tr>
				<td>
				아빠
				</td>
				<td>
				<input type="text" name="father" value="" placeholder="아빠">
				</td>
			</tr>
			<tr>
				<td>
				엄마
				</td>
				<td>
				<input type="text" name="mother" value="" placeholder="엄마">
				</td>
			</tr>
			<tr>
				<td>
				할머니
				</td>
				<td>
				<input type="text" name="grandmo" value="" placeholder="할머니">
				</td>
			</tr>
			<tr>
				<td>
				동생
				</td>
				<td>
				<input type="text" name="brother" value="" placeholder="동생">
				</td>
			</tr>
			<tr>
				<td  colspan="2" align="center">
				<input type="submit" value="출력하기" >
				</td>
			</tr>
		</table>
	</form>
</body>
</html>


<%--가족이름 찍기--%>