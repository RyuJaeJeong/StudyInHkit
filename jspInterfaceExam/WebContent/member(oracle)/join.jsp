<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>

<form name="joinFrm">
	<table border="1" align="center">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" value=""></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="pwd" value=""></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="nme" value=""></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="phone" value=""></td>
		</tr>
		<tr>
			<td>직업</td>
            <td>
                <input type="radio" name="job" value="의사">의사
                <input type="radio" name="job" value="판사">판사
                <input type="radio" name="job" value="변호사">변호사
                <input type="radio" name="job" value="검사">검사
            </td>
		</tr>
		<tr>
			<td colspan="2" align="center"><button type="button" onclick="join();">가입하기</button></td>
		</tr>
	</table>
</form>

<script>
function join() {
	if(confirm('가입하시겠습니까?')) {
		joinFrm.method="post";
		joinFrm.action="joinProc.jsp";
		joinFrm.submit();
	}
	
}
</script>