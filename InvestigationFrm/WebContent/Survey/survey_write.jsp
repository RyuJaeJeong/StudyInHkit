<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form name=surFrm>
	<table align="center">
		<tr>
			<td>항목 제목</td>
			<td><input type="text" name="question" value=""></td>
		</tr>
		<tr>
			<td>선택지1</td>
			<td><input type="text" name="select1" value=""></td>
		</tr>
		<tr>
			<td>선택지2</td>
			<td><input type="text" name="select2" value=""></td>
		</tr>
		<tr>
			<td>선택지3</td>
			<td><input type="text" name="select3" value=""></td>
		</tr>
		<tr>
			<td>선택지4</td>
			<td><input type="text" name="select4" value=""></td>
		</tr>
		<tr>
			<td>조사 활성화 여부</td>
			<td>
				<input type="radio" name="serviceStatus" value="1">활성화
				<input type="radio" name="serviceStatus" value="0">비활성화
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><a href="#" onclick="submit()">[제출하기]</a></td>
		</tr>
	</table>
</form>


</body>
</html>

<script>
	function submit() {
		if(confirm('제출하시겠습니까?')) {
				surFrm.method = "post";
				surFrm.action = "survey_writeProc.jsp";
				surFrm.submit();
		}
	}
</script>