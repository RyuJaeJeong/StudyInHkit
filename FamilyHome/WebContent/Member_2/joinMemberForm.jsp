<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<form name="frmNme">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" value=""></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="" name="password" value=""></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="nme" value=""></td>
		</tr>
		<tr>
			<td>핸드폰</td>
			<td><input type="text" name="phone" value=""></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email" value=""></td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td><input type="text" name="birthYear" value=""></td>
		</tr>
		<tr>
		<td><a href="#" onclick="join();">[가입하기]</a></td>
		</tr>
	</table>
</form>

<script>
function join(){
if (confirm("가입하시겠습니까?")){
	frmNme.method ="post";
 	frmNme.action ="joinMemberProc.jsp";
 	frmNme.submit();
 }
}
</Script>




