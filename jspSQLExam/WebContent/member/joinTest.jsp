<%@page import="java.net.Inet4Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form name="joinFrm">
<table border="1"  align="center">

	<tr>
		<th height="30">HOME</th>
		<th>
			<a href="list.jsp">회원관리</a>
		</th>
		<th>게시판</th>
		<th>
			<a href="login.jsp">로그인</a>
		</th>
		<th>
			<%
			String ip =Inet4Address.getLocalHost().getHostAddress();
			%>
			<%=ip %>
		</th>
		
	</tr>
	
	<tr>
		<td colspan="10">
			<table align="center" >
			<tr>
				<td colspan="2">&nbsp;</td>
				
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
				
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
				
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" value=""></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="passwd" value=""></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="text" name="passwdChk" value=""></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value=""></td>
			</tr>
			<tr>
				<td>주소</td>
				<td>
				<input type="text" name="addr" value="">
				<a href="#">우편번호검색</a>
				</td>
			</tr>
			<tr>
				<td>기본주소</td>
				<td><input type="text" name="addrbasic" value=""></td>
			</tr>
			<tr>
				<td>상세주소</td>
				<td><input type="text" name="addrdetail" value=""></td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
				
			</tr>
			<tr>
				<td colspan="2" align = "center"><a href="#" onclick="join()">[가입하기]</a></td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
				
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
				
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
				
			</tr>
			</table>
		 </td>
	  </tr>
		
	<tr>
		<td colspan="10">경기도성남시 대왕판교로 000</td>	
	</tr>
</table>
</form>

</body>
</html>


<script>
function join() {
	if(document.joinFrm.id.value == ''||document.joinFrm.id.value == null) {
		alert('아이디를 입력해주세요.');
		history.back();
		return;
	}
	if(document.joinFrm.passwd.value == ''||document.joinFrm.passwd.value == null) {
		alert('비밀번호를 입력해주세요.');
		history.back();
		return;
	}
	if(document.joinFrm.passwdChk.value == ''||document.joinFrm.passwdChk.value == null) {
		alert('비밀번호 확인을 입력해주세요.');
		history.back();
		return;
	}
	if(document.joinFrm.name.value == ''||document.joinFrm.name.value == null) {
		alert('이름 입력해주세요.');
		history.back();
		return;
	}
	if(document.joinFrm.addr.value == ''||document.joinFrm.addr.value == null) {
		alert('주소를 입력해주세요.');
		history.back();
		return;
	}
	if(document.joinFrm.addrbasic.value == ''||document.joinFrm.addrbasic.value == null) {
		alert('기본주소 입력해주세요.');
		history.back();
		return;
	}
	if(document.joinFrm.addrdetail.value == ''||document.joinFrm.addrdetail.value == null) {
		alert('상세주소 입력해주세요.');
		history.back();
		return;
	}
	if(confirm('가입하시겠습니까?')) {
		joinFrm.method="post";
		joinFrm.action="joinProc.jsp";
		joinFrm.submit();
	}
}
</script>