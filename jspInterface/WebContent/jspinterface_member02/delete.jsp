<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String no_ = request.getParameter("no");
int no = Integer.parseInt(no_);


%>
<form name="delFrm">
<table>
<tr>
<td>비밀번호</td>
<td><input type="text" name="delPass" value=""></td>
</tr>
<tr>
<td colspan="2" align="center"><button type="button" onclick="goDel()">삭제하기</button></td>
</tr>
</table>
</form>
</body>
</html>

<script>
function goDel() {
	if(confirm('삭제하시겠습니까')) {
		delFrm.method='post';
		delFrm.action='deleteProc.jsp?no=<%=no%>';
		delFrm.submit();
	}
}
</script>