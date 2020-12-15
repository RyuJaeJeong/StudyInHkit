<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<form name="frmLog"  >
<table align="center" border="1">
<tr>
	<td>아이디</td>
	<td><input type="text" name="iden" value=""></td>
</tr>
<tr>
	<td>비밀번호</td>
	<td><input type="text" name="pass" value=""></td>
</tr>
<tr>
<td colspan="2" align ="center"><a href ="#" onclick="login()">[로그인]</a> </td>
</tr>


</table>
</form>

<script>
function login() {
	if(confirm('로그인 하시겠습니까?')){
	frmLog.method="post";
	frmLog.action="loginProc.jsp";
	frmLog.submit();
	}
}
</script>