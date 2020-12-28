<%@page import="jspInterfaceExam.model.member.MemberDTO"%>
<%@page import="jspInterfaceExam.model.member.MemberDAO"%>
<%@page import="jspInterfaceExam.model.member.MemberDAOImplOracle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8"); %>


<%
String id = request.getParameter("id");
MemberDAO dao = new MemberDAOImplOracle();
MemberDTO dto =  dao.getSelectOne(id); 


String pwd = dto.getPwd();
String nme = dto.getNme();
String phone = dto.getPhone();
String job = dto.getJob();

%>

<form name ="modFrm">
<h3 align="center"><%=nme%>님의 회원정보 수정하기</h3>
	<table align="center">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" value="<%=id%>" readonly></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="pwd" value="<%=pwd%>"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="nme" value="<%=nme%>"></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="phone" value="<%=phone%>"></td>
		</tr>
		<tr>
			<td>직업</td>
			<td>
				<input type="radio" name="job" value="의사">의사
				<input type="radio" name="job" value="판사">판사
				<input type="radio" name="job" value="검사">검사
				<input type="radio" name="job" value="변호사">변호사
			</td>
		</tr>
		<tr>
			<td>&nbsp</td>
			<td>&nbsp</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><button type="button" onclick="mod()">수정하기</button></td>
		</tr>
	</table>
</form>

<script>
function mod() {
	if(confirm('수정하시겠습니까?')) {
		modFrm.method="post";
		modFrm.action="modifyProc.jsp"
		modFrm.submit();
	}
}
</script>