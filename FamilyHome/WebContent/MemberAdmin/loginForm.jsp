<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<form name="loginFrm"><a>
	<table align="center" style="border:1px solid black;">
		<tr>
			<td>
			아이디
			</td>
			<td>
			<input type="text" name="id" value="">
			</td>	
		</tr>
		<tr>
			<td>
			비밀번호
			</td>
			<td>
			<input type="text" name="pass" value="">
			</td>	
		</tr>
		<tr>
		<td colspan="2" align="center"><a href="#" onclick="login()">[로그인]</a></td>
		</tr>
	</table>


</form>

<script>
function login() {
	loginFrm.method="post";
	loginFrm.action="loginProc.jsp";
	loginFrm.submit();
}

</script>