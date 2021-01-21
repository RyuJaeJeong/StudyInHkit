<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
	String cookId =(String)session.getAttribute("cookId");
	String cookDate = (String)session.getAttribute("cookDate");
	if(cookId == null||cookId.length()==0) {
		out.println("<script>");
		out.println("alert('로그인후 이용해주세요');");
		out.println("location.href='login.jsp';");
		out.println("</script>");
	}
	%>
	
	<h2><%=cookId %>님 환영합니다.!  비밀번호 수정페이지입니다.</h2>
	<a href="logout.jsp">[로그아웃]</a><br>
	
	<form name="modifyFrm">
		<table border="1" align="center">
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="passwd" value=""></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="text" name="passwdCheck" value=""></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><button type="button" onclick="mod()">변경하기</button></td>
			</tr>
			
		</table>
	</form>
	
</body>
</html>

<script>

function mod(){
	/* if(document.modifyFrm.passwd.value==""||document.modifyFrm.passwd.value==null) {
		alert('비밀번호를 입력하세요.')
		location.href='change.jsp';
		return;
	} */
	if(confirm('변경하시겠습니까?')) {
		modifyFrm.method="post";
		modifyFrm.action="modifyProc.jsp";
		modifyFrm.submit();
	}
}

</script>