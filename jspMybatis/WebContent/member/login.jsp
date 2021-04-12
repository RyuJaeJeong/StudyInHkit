<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../include/inc_header.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="loginFrm">
	<table align="center">
						<tr>
							<td>아이디</td>
							<td><input type="text" id="loginId" name="loginId" value="" onkeypress="JavaScript:press(this.form)"></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" id="loginPasswd" name="loginPasswd" value="" onkeypress="JavaScript:press(this.form)"></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<input type="button" value="로그인" onclick="suntaek_proc('loginProc', '', '');">
								<input type="button" value="회원가입" onclick="join()">
							</td>
						</tr>
	</table>
</form>
</body>
</html>


<script type="text/javascript" src="${path}/member/_member.js">

function join() {
	if(confirm('회원가입 하시겠습니까')) {
		location.href="${path}/member_servlet/chuga.do";
	}
	
}

$('form input').keydown(function(e) {
    if (e.keyCode == 13) {
    	suntaek_proc('loginProc', '', '');
    }
});			//엔터키 입력시 로그인.

</script>


